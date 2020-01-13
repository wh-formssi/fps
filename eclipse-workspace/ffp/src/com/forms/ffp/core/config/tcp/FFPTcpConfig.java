package com.forms.ffp.core.config.tcp;

import com.forms.ffp.core.config.FFPConnectorConfig;

public class FFPTcpConfig implements FFPConnectorConfig
{
	private String connectorName;
	private String connectorType;
	private String receivehost;
	private int receiveport;
	private int receiveSessionCount;
	private int receiveTimeOut;
	private String receiveListenerClass;
	private String sendhost;
	private int sendport;

	public String getConnectorName()
	{
		return connectorName;
	}
	
	

	public int getReceiveTimeOut() {
		return receiveTimeOut;
	}



	public void setReceiveTimeOut(int receiveTimeOut) {
		this.receiveTimeOut = receiveTimeOut;
	}



	public void setConnectorName(String connectorName)
	{
		this.connectorName = connectorName;
	}

	public String getConnectorType()
	{
		return connectorType;
	}

	public void setConnectorType(String connectorType)
	{
		this.connectorType = connectorType;
	}

	public String getReceivehost()
	{
		return receivehost;
	}

	public void setReceivehost(String receivehost)
	{
		this.receivehost = receivehost;
	}

	public int getReceiveport()
	{
		return receiveport;
	}

	public void setReceiveport(int receiveport)
	{
		this.receiveport = receiveport;
	}

	public String getSendhost()
	{
		return sendhost;
	}

	public void setSendhost(String sendhost)
	{
		this.sendhost = sendhost;
	}

	public int getSendport()
	{
		return sendport;
	}

	public void setSendport(int sendport)
	{
		this.sendport = sendport;
	}

	public int getReceiveSessionCount()
	{
		return receiveSessionCount;
	}

	public void setReceiveSessionCount(int receiveSessionCount)
	{
		this.receiveSessionCount = receiveSessionCount;
	}

	public String getReceiveListenerClass()
	{
		return receiveListenerClass;
	}

	public void setReceiveListenerClass(String receiveListenerClass)
	{
		this.receiveListenerClass = receiveListenerClass;
	}

}
