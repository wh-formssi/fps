package com.forms.ffp.mq.listener.mq;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.net.ssl.SSLContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.connection.UserCredentialsConnectionFactoryAdapter;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import com.forms.ffp.config.FFPRuntimeConfigSvc;
import com.forms.ffp.mq.config.FFPMqConfig;
import com.forms.ffp.mq.config.FFPQueueConfig;
import com.forms.ffp.mq.config.FFPQueueManagerConfig;
import com.forms.ffp.mq.listener.FFPMessageConverter;
import com.forms.ffp.mq.listener.msg.FFPBaseMsgListener;
import com.forms.ffp.utils.FFPSecurityUtils;
import com.ibm.mq.jms.MQXAQueueConnectionFactory;
public class FFPIbmWebSphereMqListenerAgent implements FFPMqListenerAgentInterface
{
	private static Logger logger = LoggerFactory.getLogger(FFPIbmWebSphereMqListenerAgent.class);

	protected FFPMqConfig config;

	protected JmsTemplate jmsTemplate;
	
	private List<ConnectionFactory> connectionFactories;

	private List<DefaultMessageListenerContainer> listenerContainer;
	@Resource(name = "runtimeConfigSvc")
	private FFPRuntimeConfigSvc runtimeConfigSvc;

	@Resource(name= "messageConverter")
	private FFPMessageConverter msgConverter;

	public FFPIbmWebSphereMqListenerAgent() {
	}

	public FFPIbmWebSphereMqListenerAgent(FFPMqConfig config) {
		this.config = config;
	}

	@PostConstruct
	public void init() {
		initJmsTemplate();
		startListeners();
	};

	@PreDestroy
	public void onDestory() {
		destoryListeners();
	}

	public void initJmsTemplate() {
		if (logger.isInfoEnabled()) {
			logger.info("[{}] MQ Agent Initialization started.");
		}
		try {
			this.jmsTemplate = new JmsTemplate();
			this.connectionFactories = new ArrayList<ConnectionFactory>();
			List<ConnectionFactory> subscribeInward = new ArrayList<ConnectionFactory>();

			FFPQueueManagerConfig qmCfg = this.config.getQmCfg();
			MQXAQueueConnectionFactory factory = new MQXAQueueConnectionFactory();
			factory.setHostName(qmCfg.getHostName());
			factory.setPort(qmCfg.getPort().intValue());
			factory.setQueueManager(qmCfg.getQueueManagerName());
			factory.setChannel(qmCfg.getClientChannel());
			factory.setCCSID(qmCfg.getCcsid().intValue());
			factory.setTransportType(1);
			if ((qmCfg.getSslEnable() != null) && (qmCfg.getSslEnable().booleanValue())) {
				factory.setSSLPeerName(qmCfg.getSslPeerName());
				factory.setSSLCipherSuite(qmCfg.getSslCipherSuite());
				try {
					SSLContext sslContext = FFPSecurityUtils.createSSLContext(
							this.runtimeConfigSvc.getConfigFilePath(qmCfg.getSslTrustStoreFilename()),
							qmCfg.getSslTrustStorePassword(), "JKS",
							this.runtimeConfigSvc.getConfigFilePath(qmCfg.getSslKeyStoreFilename()),
							qmCfg.getSslKeyStorePassword(), "JKS");

					factory.setSSLSocketFactory(sslContext.getSocketFactory());
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}

			UserCredentialsConnectionFactoryAdapter adapter = new UserCredentialsConnectionFactoryAdapter();
			adapter.setTargetConnectionFactory(factory);
			adapter.setUsername(qmCfg.getUser());
			adapter.setPassword(qmCfg.getPassword());

			CachingConnectionFactory ccf = new CachingConnectionFactory();
			ccf.setTargetConnectionFactory(adapter);
			ccf.setSessionCacheSize(this.config.getSessionCacheSize().intValue());

			if ((qmCfg.getSubscribeInward() == null) || (Boolean.TRUE.equals(qmCfg.getSubscribeInward()))) {
				subscribeInward.add(ccf);
			}

			if (logger.isInfoEnabled()) {
				logger.info(
						"[{}] Connection Factory initialized [{}] Host: [{}:{}] QM: [{}], Client Channel: [{}], CCSID: [{}], SSL Enabled: [{}]",
						new Object[] { this.config.getMqName(), ccf.toString(), qmCfg.getHostName(), qmCfg.getPort(),
								qmCfg.getQueueManagerName(), qmCfg.getClientChannel(), qmCfg.getCcsid(),
								qmCfg.getSslEnable() });
			}

			this.connectionFactories.add(ccf);

			this.jmsTemplate.setConnectionFactory((ConnectionFactory) this.connectionFactories.get(0));
			this.jmsTemplate.setSessionTransacted(true);
			this.jmsTemplate.setPubSubDomain(false);
			this.jmsTemplate.setDefaultDestinationName("queue:///" + this.config.getDefaultDestinationQueueName());

			initListeners(subscribeInward);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void initListeners(List<ConnectionFactory> subscribeInwardConnectionFactories) throws Exception {
		if (this.listenerContainer == null) {
			this.listenerContainer = new ArrayList<DefaultMessageListenerContainer>();
		} else {
			destoryListeners();
		}

		for (ConnectionFactory factory : subscribeInwardConnectionFactories) {
			if (logger.isInfoEnabled()) {
				logger.info("[{}] Initializing MQ Listeners (Connection Factory Index = {})", this.config.getMqName(),
						Integer.valueOf(this.connectionFactories.indexOf(factory)));
			}

			Iterator<String> iter = this.config.getReceiveQueueNameMap().keySet().iterator();
			while (iter.hasNext()) {
				String key = iter.next();
				FFPQueueConfig queueConfig = this.config.getReceiveQueueNameMap().get(key);
				FFPBaseMsgListener listener = (FFPBaseMsgListener) Class.forName(queueConfig.getListener())
						.newInstance();
				this.listenerContainer.add(initListener(factory, queueConfig.getQueueName(),
						queueConfig.getThreadPoolSize(), this.config.getInwardSelector(), listener));
			}
		}
	}

	public void startListeners() {
		if (logger.isInfoEnabled()) {
			logger.info("[{}] Starting Listeners in new Thread...", this.config.getMqName());
		}

		Runnable run = new Runnable() {

			@Override
			public void run() {
				for (DefaultMessageListenerContainer container : FFPIbmWebSphereMqListenerAgent.this.listenerContainer) {
					if (FFPIbmWebSphereMqListenerAgent.logger.isInfoEnabled()) {
						FFPIbmWebSphereMqListenerAgent.logger.info(
								"[{}] Starting listener... (Connection Factory Index = {}) Destination: [{}]",
								new Object[] { FFPIbmWebSphereMqListenerAgent.this.config.getMqName(),
										Integer.valueOf(FFPIbmWebSphereMqListenerAgent.this.connectionFactories
												.indexOf(container.getConnectionFactory())),
										container.getDestinationName() });
					}
					container.start();
				}
				if (FFPIbmWebSphereMqListenerAgent.logger.isInfoEnabled()) {
					FFPIbmWebSphereMqListenerAgent.logger.info("[{}] All Listeners started.",
							FFPIbmWebSphereMqListenerAgent.this.config.getMqName());
				}
			}
		};

		new Thread(run).start();
	}

	public FFPMqConfig getConfig() {
		return this.config;
	}

	public void setConfig(FFPMqConfig config) {
		this.config = config;
	}

	public JmsTemplate getJmsTemplate() {
		return this.jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	private DefaultMessageListenerContainer initListener(final ConnectionFactory connectionFactory,
			final String destinationName, final int concurrentConsumers, final String selector,
			final FFPBaseMsgListener listener) throws Exception {
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setMessageConverter(this.msgConverter);
		container.setRecoveryInterval(6000L);
		container.setDestinationName(destinationName);
		container.setMessageSelector(selector);
		container.setConcurrentConsumers(1);
		container.setMaxConcurrentConsumers(concurrentConsumers);
		container.setSessionAcknowledgeMode(0);
		container.setExceptionListener(new ExceptionListener() {
			public void onException(JMSException ex) {
				if (FFPIbmWebSphereMqListenerAgent.logger.isErrorEnabled()) {
					StringBuilder sb = new StringBuilder();
					Throwable e = ex;
					int idx = 0;
					while (e != null) {
						idx++;
						if (sb.length() != 0) {
							sb.append(" --> ");
						}
						sb.append(String.format("[%s][%s][%s]",
								new Object[] { Integer.valueOf(idx), e.getClass().getSimpleName(), e.getMessage() }));
						e = e.getCause();
					}
					FFPIbmWebSphereMqListenerAgent.logger.error(
							"[{}] Exception catched for JMS Message Container. Connection Factory: [{}] Destination: [{}] Concurrency: [{}] Selector: [{}] Listener: [{}] Cause: {}",
							new Object[] { FFPIbmWebSphereMqListenerAgent.this.config.getMqName(),
									connectionFactory.toString(), destinationName, Integer.valueOf(concurrentConsumers),
									selector, listener.getClass().getSimpleName(), sb.toString(), ex });
				}
			}
		});

		MessageListener msgListener = new MessageListener() {
			@Override
			public void onMessage(Message msg) {
				try {
					listener.onMessage(msg, FFPIbmWebSphereMqListenerAgent.this.config.getMqName());
				} catch (Exception e) {
					if (FFPIbmWebSphereMqListenerAgent.logger.isErrorEnabled()) {
						FFPIbmWebSphereMqListenerAgent.logger.error("Unexpected Error.", e);
					}
				}

			}
		};

		container.setMessageListener(msgListener);
		container.initialize();

		if (logger.isInfoEnabled()) {
			logger.info(
					"[{}] MQ Listener initialized. Connection Factory: [{}] Destination: [{}] Concurrency: [{}] Selector: [{}] Listener: [{}]",
					new Object[] { this.config.getMqName(), connectionFactory.toString(), destinationName,
							Integer.valueOf(concurrentConsumers), selector, listener.getClass().getSimpleName() });
		}

		return container;
	}

	private void destoryListeners() {
		if (this.listenerContainer != null) {
			for (DefaultMessageListenerContainer container : this.listenerContainer) {
				if (logger.isInfoEnabled()) {
					logger.info("[{}] MQ Listener destory. Destination: [{}]", this.config.getMqName(),
							container.getDestinationName());
				}

				container.destroy();
			}

			this.listenerContainer.clear();
		}
	}

}
