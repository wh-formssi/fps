package com.forms.ffp.webapp.cashmanagement.transaction.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.forms.beneform4j.core.util.page.IPage;
import com.forms.ffp.persistents.bean.FFPTxJnlAction;
import com.forms.ffp.persistents.bean.addressing.FFPJbA100;
import com.forms.ffp.persistents.bean.payment.credittransfer.FFPJbP100;
import com.forms.ffp.persistents.bean.payment.credittransfer.FFPJbP110;
import com.forms.ffp.persistents.bean.payment.directdebit.FFPJbP200;
import com.forms.ffp.persistents.bean.payment.directdebit.FFPJbP210;
import com.forms.ffp.persistents.bean.payment.returnrefund.FFPJbP300;
import com.forms.ffp.persistents.dao.FFPIDao_TxJnl;
import com.forms.ffp.persistents.dao.FFPIDao_TxJnlAction;
import com.forms.ffp.persistents.service.FFPIDaoService_Txjnl;
import com.forms.ffp.webapp.cashmanagement.transaction.bean.TransactionBean;
import com.forms.ffp.webapp.cashmanagement.transaction.dao.ITransactionRecordDao;
import com.forms.ffp.webapp.cashmanagement.transaction.form.TransactionSearchForm;
import com.forms.ffp.webapp.common.bean.DataLayoutBean;

@Service("TransactionService")
@Scope("prototype")
public class TransactionService implements ITransactionService
{

	@Resource(name = "ITransactionRecordDao")
	private ITransactionRecordDao dao;

	@Resource(name = "FFPIDao_TxJnl")
	private FFPIDao_TxJnl txJnlDao;
	@Resource(name = "FFPDaoService_Txjnl")
	private FFPIDaoService_Txjnl txJnlService;

	@Resource(name = "FFPIDao_TxJnlAction")
	private FFPIDao_TxJnlAction txJnlActionDao;
	private String label = "ffp.cashmanagement.transaction.";

	@Override
	public List<TransactionBean> sList(TransactionSearchForm form, IPage page)
	{
		 List<TransactionBean> dList = dao.dList(form, page);
		 return dList;
	}

	@Override
	public Map<String, Object> sDetail(String jnlNo)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		try
		{
			Object loc_obj = txJnlService.inquiryByJnlNo(jnlNo);

			if (loc_obj == null)
			{
				return null;
			}

			if (loc_obj instanceof FFPJbP100)
			{
				FFPJbP100 loc_jb = (FFPJbP100) loc_obj;
				List<DataLayoutBean> P100List = new ArrayList<DataLayoutBean>();
				P100List.add(new DataLayoutBean("ffp.cashmanagement.transaction.jnlNo", loc_jb.getTxJnl().getJnlNo()));
				P100List.add(new DataLayoutBean("ffp.cashmanagement.transaction.debtorName", loc_jb.getDebtorName()));
				P100List.add(new DataLayoutBean("ffp.cashmanagement.transaction.debtorAcctNo", loc_jb.getDebtorAccountNumber()));
				P100List.add(new DataLayoutBean("ffp.cashmanagement.transaction.debtorAcctNoType", loc_jb.getDebtorAccountNumberType()));
				P100List.add(new DataLayoutBean("ffp.cashmanagement.transaction.creditorName", loc_jb.getCreditorName()));
				P100List.add(new DataLayoutBean("ffp.cashmanagement.transaction.creditorAcctNo", loc_jb.getCreditorAccountNumber()));
				P100List.add(new DataLayoutBean("ffp.cashmanagement.transaction.creditorAcctNoType", loc_jb.getCreditorAccountNumberType()));
				P100List.add(new DataLayoutBean("ffp.cashmanagement.transaction.settlementCur", loc_jb.getSettlementCurrency()));
				if (loc_jb.getSettlementAmount() != null)
				{

					P100List.add(new DataLayoutBean("ffp.cashmanagement.transaction.settlementAmt", loc_jb.getSettlementAmount().toString()));
				}
				if (loc_jb.getSettlementDate() != null)
				{

					P100List.add(new DataLayoutBean("ffp.cashmanagement.transaction.settlementDate", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(loc_jb.getSettlementDate())));
				}

				map.put("ffp.cashmanagement.transaction.bussiData", P100List);

				if (loc_jb.getTxJnl() != null)
				{
					List<DataLayoutBean> beanList = new ArrayList<DataLayoutBean>();
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.jnlNo", loc_jb.getTxJnl().getJnlNo()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.srcRefNm", loc_jb.getTxJnl().getSrcRefNm()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.txStat", label+loc_jb.getTxJnl().getTxStat()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.txCode", label+loc_jb.getTxJnl().getTxCode()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.txSrc", loc_jb.getTxJnl().getTxSrc()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.txMode", loc_jb.getTxJnl().getTxMode()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.transactionId", loc_jb.getTxJnl().getTransactionId()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.endToEndId", loc_jb.getTxJnl().getEndToEndId()));
					if (loc_jb.getTxJnl().getCreateTs() != null)
					{
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.createDate", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(loc_jb.getTxJnl().getCreateTs())));
					}
					map.put("ffp.cashmanagement.transaction.txJnl", beanList);
				}
				if (loc_jb.getJnlActionList() != null && loc_jb.getJnlActionList().size() != 0)
				{

					List<List<DataLayoutBean>> actionBeanlist = new ArrayList<List<DataLayoutBean>>();
					List<FFPTxJnlAction> jnlActionList = loc_jb.getJnlActionList();
					for (FFPTxJnlAction jnlAction : jnlActionList)
					{
						List<DataLayoutBean> beanList = new ArrayList<DataLayoutBean>();
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgId", jnlAction.getMsgId()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgDirection", label+jnlAction.getMsgDirection()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgSystemId", jnlAction.getMsgSystemId()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgType", jnlAction.getMsgType()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgStatus", label+jnlAction.getMsgStatus()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgCode", jnlAction.getMsgCode()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgResult", jnlAction.getMsgResult()));
						if (jnlAction.getMsgCreatTs() != null)
						{

							beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgCreateTs", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(jnlAction.getMsgCreatTs())));
						}
						if (jnlAction.getMsgProceTs() != null)
						{

							beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgProce_ts", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(jnlAction.getMsgProceTs())));
						}
						if (jnlAction.getMsgComplTs() != null)
						{

							beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgComplTs", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(jnlAction.getMsgComplTs())));
						}
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.refMsgId", jnlAction.getRefMsgId()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.isAutocheck", jnlAction.getIsAutoCheck()));
						
						actionBeanlist.add(beanList);
					}
					map.put("ffp.cashmanagement.transaction.actionList", actionBeanlist);

				}
			} else if (loc_obj instanceof FFPJbP110)
			{
				FFPJbP110 loc_jb = (FFPJbP110) loc_obj;
				List<DataLayoutBean> P110List = new ArrayList<DataLayoutBean>();
				P110List.add(new DataLayoutBean("ffp.cashmanagement.transaction.jnlNo", loc_jb.getTxJnl().getJnlNo()));
				P110List.add(new DataLayoutBean("ffp.cashmanagement.transaction.debtorName", loc_jb.getDebtorName()));
				P110List.add(new DataLayoutBean("ffp.cashmanagement.transaction.debtorAcctNo", loc_jb.getDebtorAccountNumber()));
				P110List.add(new DataLayoutBean("ffp.cashmanagement.transaction.debtorAcctNoType", loc_jb.getDebtorAccountNumberType()));
				P110List.add(new DataLayoutBean("ffp.cashmanagement.transaction.creditorName", loc_jb.getCreditorName()));
				P110List.add(new DataLayoutBean("ffp.cashmanagement.transaction.creditorAcctNo", loc_jb.getCreditorAccountNumber()));
				P110List.add(new DataLayoutBean("ffp.cashmanagement.transaction.creditorAcctNoType", loc_jb.getCreditorAccountNumberType()));
				P110List.add(new DataLayoutBean("ffp.cashmanagement.transaction.settlementCur", loc_jb.getSettlementCurrency()));
				if (loc_jb.getSettlementAmount() != null)
				{

					P110List.add(new DataLayoutBean("ffp.cashmanagement.transaction.settlementAmt", loc_jb.getSettlementAmount().toString()));
				}
				if (loc_jb.getSettlementDate() != null)
				{

					P110List.add(new DataLayoutBean("ffp.cashmanagement.transaction.settlementDate", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(loc_jb.getSettlementDate())));
				}
				map.put("ffp.cashmanagement.transaction.bussiData", P110List);

				if (loc_jb.getTxJnl() != null)
				{
					List<DataLayoutBean> beanList = new ArrayList<DataLayoutBean>();
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.jnlNo", loc_jb.getTxJnl().getJnlNo()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.srcRefNm", loc_jb.getTxJnl().getSrcRefNm()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.txStat", label+loc_jb.getTxJnl().getTxStat()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.txCode", label+loc_jb.getTxJnl().getTxCode()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.txSrc", loc_jb.getTxJnl().getTxSrc()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.txMode", loc_jb.getTxJnl().getTxMode()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.transactionId", loc_jb.getTxJnl().getTransactionId()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.endToEndId", loc_jb.getTxJnl().getEndToEndId()));
					if (loc_jb.getTxJnl().getCreateTs() != null)
					{
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.createDate", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(loc_jb.getTxJnl().getCreateTs())));
					}
					map.put("ffp.cashmanagement.transaction.txJnl", beanList);
				}
				if (loc_jb.getJnlActionList() != null && loc_jb.getJnlActionList().size() != 0)
				{

					List<List<DataLayoutBean>> actionBeanlist = new ArrayList<List<DataLayoutBean>>();
					List<FFPTxJnlAction> jnlActionList = loc_jb.getJnlActionList();
					for (FFPTxJnlAction jnlAction : jnlActionList)
					{
						List<DataLayoutBean> beanList = new ArrayList<DataLayoutBean>();
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgId", jnlAction.getMsgId()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgDirection", label+jnlAction.getMsgDirection()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgSystemId", jnlAction.getMsgSystemId()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgType", jnlAction.getMsgType()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgStatus", label+jnlAction.getMsgStatus()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgCode", jnlAction.getMsgCode()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgResult", jnlAction.getMsgResult()));
						if (jnlAction.getMsgCreatTs() != null)
						{

							beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgCreateTs", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(jnlAction.getMsgCreatTs())));
						}
						if (jnlAction.getMsgProceTs() != null)
						{

							beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgProce_ts", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(jnlAction.getMsgProceTs())));
						}
						if (jnlAction.getMsgComplTs() != null)
						{

							beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgComplTs", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(jnlAction.getMsgComplTs())));
						}
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.refMsgId", jnlAction.getRefMsgId()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.isAutocheck", jnlAction.getIsAutoCheck()));
						
						actionBeanlist.add(beanList);
					}
					map.put("ffp.cashmanagement.transaction.actionList", actionBeanlist);

				}
			} else if (loc_obj instanceof FFPJbP200)
			{
				FFPJbP200 loc_jb = (FFPJbP200) loc_obj;
				List<DataLayoutBean> P200List = new ArrayList<DataLayoutBean>();
				P200List.add(new DataLayoutBean("ffp.cashmanagement.transaction.jnlNo", loc_jb.getTxJnl().getJnlNo()));
				P200List.add(new DataLayoutBean("ffp.cashmanagement.transaction.debtorName", loc_jb.getDebtorName()));
				P200List.add(new DataLayoutBean("ffp.cashmanagement.transaction.debtorAcctNo", loc_jb.getDebtorAccountNumber()));
				P200List.add(new DataLayoutBean("ffp.cashmanagement.transaction.debtorAcctNoType", loc_jb.getDebtorAccountNumberType()));
				P200List.add(new DataLayoutBean("ffp.cashmanagement.transaction.creditorName", loc_jb.getCreditorName()));
				P200List.add(new DataLayoutBean("ffp.cashmanagement.transaction.creditorAcctNo", loc_jb.getCreditorAccountNumber()));
				P200List.add(new DataLayoutBean("ffp.cashmanagement.transaction.creditorAcctNoType", loc_jb.getCreditorAccountNumberType()));
				P200List.add(new DataLayoutBean("ffp.cashmanagement.transaction.settlementCur", loc_jb.getSettlementCurrency()));
				if (loc_jb.getSettlementAmount() != null)
				{

					P200List.add(new DataLayoutBean("ffp.cashmanagement.transaction.settlementAmt", loc_jb.getSettlementAmount().toString()));
				}
				if (loc_jb.getSettlementDate() != null)
				{

					P200List.add(new DataLayoutBean("ffp.cashmanagement.transaction.settlementDate", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(loc_jb.getSettlementDate())));
				}
				map.put("ffp.cashmanagement.transaction.bussiData", P200List);
				if (loc_jb.getTxJnl() != null)
				{
					List<DataLayoutBean> beanList = new ArrayList<DataLayoutBean>();
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.jnlNo", loc_jb.getTxJnl().getJnlNo()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.srcRefNm", loc_jb.getTxJnl().getSrcRefNm()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.txStat", label+loc_jb.getTxJnl().getTxStat()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.txCode", label+loc_jb.getTxJnl().getTxCode()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.txSrc", loc_jb.getTxJnl().getTxSrc()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.txMode", loc_jb.getTxJnl().getTxMode()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.transactionId", loc_jb.getTxJnl().getTransactionId()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.endToEndId", loc_jb.getTxJnl().getEndToEndId()));
					if (loc_jb.getTxJnl().getCreateTs() != null)
					{
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.createDate", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(loc_jb.getTxJnl().getCreateTs())));
					}
					map.put("ffp.cashmanagement.transaction.txJnl", beanList);
				}
				if (loc_jb.getJnlActionList() != null && loc_jb.getJnlActionList().size() != 0)
				{

					List<List<DataLayoutBean>> actionBeanlist = new ArrayList<List<DataLayoutBean>>();
					List<FFPTxJnlAction> jnlActionList = loc_jb.getJnlActionList();
					for (FFPTxJnlAction jnlAction : jnlActionList)
					{
						List<DataLayoutBean> beanList = new ArrayList<DataLayoutBean>();
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgId", jnlAction.getMsgId()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgDirection", label+jnlAction.getMsgDirection()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgSystemId", jnlAction.getMsgSystemId()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgType", jnlAction.getMsgType()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgStatus", label+jnlAction.getMsgStatus()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgCode", jnlAction.getMsgCode()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgResult", jnlAction.getMsgResult()));
						if (jnlAction.getMsgCreatTs() != null)
						{

							beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgCreateTs", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(jnlAction.getMsgCreatTs())));
						}
						if (jnlAction.getMsgProceTs() != null)
						{

							beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgProce_ts", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(jnlAction.getMsgProceTs())));
						}
						if (jnlAction.getMsgComplTs() != null)
						{

							beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgComplTs", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(jnlAction.getMsgComplTs())));
						}
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.refMsgId", jnlAction.getRefMsgId()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.isAutocheck", jnlAction.getIsAutoCheck()));
						
						actionBeanlist.add(beanList);
					}
					map.put("ffp.cashmanagement.transaction.actionList", actionBeanlist);

				}
			} else if (loc_obj instanceof FFPJbP210)
			{
				FFPJbP210 loc_jb = (FFPJbP210) loc_obj;
				List<DataLayoutBean> P210List = new ArrayList<DataLayoutBean>();
				P210List.add(new DataLayoutBean("ffp.cashmanagement.transaction.jnlNo", loc_jb.getTxJnl().getJnlNo()));
				P210List.add(new DataLayoutBean("ffp.cashmanagement.transaction.debtorName", loc_jb.getDebtorName()));
				P210List.add(new DataLayoutBean("ffp.cashmanagement.transaction.debtorAcctNo", loc_jb.getDebtorAccountNumber()));
				P210List.add(new DataLayoutBean("ffp.cashmanagement.transaction.debtorAcctNoType", loc_jb.getDebtorAccountNumberType()));
				P210List.add(new DataLayoutBean("ffp.cashmanagement.transaction.creditorName", loc_jb.getCreditorName()));
				P210List.add(new DataLayoutBean("ffp.cashmanagement.transaction.creditorAcctNo", loc_jb.getCreditorAccountNumber()));
				P210List.add(new DataLayoutBean("ffp.cashmanagement.transaction.creditorAcctNoType", loc_jb.getCreditorAccountNumberType()));
				P210List.add(new DataLayoutBean("ffp.cashmanagement.transaction.settlementCur", loc_jb.getSettlementCurrency()));
				if (loc_jb.getSettlementAmount() != null)
				{

					P210List.add(new DataLayoutBean("ffp.cashmanagement.transaction.settlementAmt", loc_jb.getSettlementAmount().toString()));
				}
				if (loc_jb.getSettlementDate() != null)
				{

					P210List.add(new DataLayoutBean("ffp.cashmanagement.transaction.settlementDate", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(loc_jb.getSettlementDate())));
				}
				map.put("ffp.cashmanagement.transaction.bussiData", P210List);

				if (loc_jb.getTxJnl() != null)
				{
					List<DataLayoutBean> beanList = new ArrayList<DataLayoutBean>();
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.jnlNo", loc_jb.getTxJnl().getJnlNo()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.srcRefNm", loc_jb.getTxJnl().getSrcRefNm()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.txStat", label+loc_jb.getTxJnl().getTxStat()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.txCode", label+loc_jb.getTxJnl().getTxCode()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.txSrc", loc_jb.getTxJnl().getTxSrc()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.txMode", loc_jb.getTxJnl().getTxMode()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.transactionId", loc_jb.getTxJnl().getTransactionId()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.endToEndId", loc_jb.getTxJnl().getEndToEndId()));
					if (loc_jb.getTxJnl().getCreateTs() != null)
					{
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.createDate", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(loc_jb.getTxJnl().getCreateTs())));
					}
					map.put("ffp.cashmanagement.transaction.txJnl", beanList);
				}
				if (loc_jb.getJnlActionList() != null && loc_jb.getJnlActionList().size() != 0)
				{

					List<List<DataLayoutBean>> actionBeanlist = new ArrayList<List<DataLayoutBean>>();
					List<FFPTxJnlAction> jnlActionList = loc_jb.getJnlActionList();
					for (FFPTxJnlAction jnlAction : jnlActionList)
					{
						List<DataLayoutBean> beanList = new ArrayList<DataLayoutBean>();
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgId", jnlAction.getMsgId()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgDirection", label+jnlAction.getMsgDirection()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgSystemId", jnlAction.getMsgSystemId()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgType", jnlAction.getMsgType()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgStatus", label+jnlAction.getMsgStatus()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgCode", jnlAction.getMsgCode()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgResult", jnlAction.getMsgResult()));
						if (jnlAction.getMsgCreatTs() != null)
						{

							beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgCreateTs", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(jnlAction.getMsgCreatTs())));
						}
						if (jnlAction.getMsgProceTs() != null)
						{

							beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgProce_ts", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(jnlAction.getMsgProceTs())));
						}
						if (jnlAction.getMsgComplTs() != null)
						{

							beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgComplTs", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(jnlAction.getMsgComplTs())));
						}
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.refMsgId", jnlAction.getRefMsgId()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.isAutocheck", jnlAction.getIsAutoCheck()));
						
						actionBeanlist.add(beanList);
					}
					map.put("ffp.cashmanagement.transaction.actionList", actionBeanlist);

				}
			} else if (loc_obj instanceof FFPJbP300)
			{

				FFPJbP300 loc_jb = (FFPJbP300) loc_obj;
				List<DataLayoutBean> P300List = new ArrayList<DataLayoutBean>();
				P300List.add(new DataLayoutBean("ffp.cashmanagement.transaction.jnlNo", loc_jb.getTxJnl().getJnlNo()));
				
				map.put("ffp.cashmanagement.transaction.bussiData", P300List);

				if (loc_jb.getTxJnl() != null)
				{
					List<DataLayoutBean> beanList = new ArrayList<DataLayoutBean>();
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.jnlNo", loc_jb.getTxJnl().getJnlNo()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.srcRefNm", loc_jb.getTxJnl().getSrcRefNm()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.txStat", label+loc_jb.getTxJnl().getTxStat()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.txCode", label+loc_jb.getTxJnl().getTxCode()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.txSrc", loc_jb.getTxJnl().getTxSrc()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.txMode", loc_jb.getTxJnl().getTxMode()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.transactionId", loc_jb.getTxJnl().getTransactionId()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.endToEndId", loc_jb.getTxJnl().getEndToEndId()));
					if (loc_jb.getTxJnl().getCreateTs() != null)
					{
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.createDate", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(loc_jb.getTxJnl().getCreateTs())));
					}
					map.put("ffp.cashmanagement.transaction.txJnl", beanList);
				}
				if (loc_jb.getJnlActionList() != null && loc_jb.getJnlActionList().size() != 0)
				{

					List<List<DataLayoutBean>> actionBeanlist = new ArrayList<List<DataLayoutBean>>();
					List<FFPTxJnlAction> jnlActionList = loc_jb.getJnlActionList();
					for (FFPTxJnlAction jnlAction : jnlActionList)
					{
						List<DataLayoutBean> beanList = new ArrayList<DataLayoutBean>();
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgId", jnlAction.getMsgId()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgDirection", label+jnlAction.getMsgDirection()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgSystemId", jnlAction.getMsgSystemId()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgType", jnlAction.getMsgType()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgStatus", label+jnlAction.getMsgStatus()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgCode", jnlAction.getMsgCode()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgResult", jnlAction.getMsgResult()));
						if (jnlAction.getMsgCreatTs() != null)
						{

							beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgCreateTs", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(jnlAction.getMsgCreatTs())));
						}
						if (jnlAction.getMsgProceTs() != null)
						{

							beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgProce_ts", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(jnlAction.getMsgProceTs())));
						}
						if (jnlAction.getMsgComplTs() != null)
						{

							beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgComplTs", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(jnlAction.getMsgComplTs())));
						}
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.refMsgId", jnlAction.getRefMsgId()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.isAutocheck", jnlAction.getIsAutoCheck()));
						
						actionBeanlist.add(beanList);
					}
					map.put("ffp.cashmanagement.transaction.actionList", actionBeanlist);

				}

			}else if((loc_obj instanceof FFPJbA100)){


				FFPJbA100 loc_jb = (FFPJbA100) loc_obj;
				List<DataLayoutBean> A100List = new ArrayList<DataLayoutBean>();
				A100List.add(new DataLayoutBean("ffp.cashmanagement.transaction.jnlNo", loc_jb.getTxJnl().getJnlNo()));
				
				map.put("ffp.cashmanagement.transaction.bussiData", A100List);

				if (loc_jb.getTxJnl() != null)
				{
					List<DataLayoutBean> beanList = new ArrayList<DataLayoutBean>();
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.jnlNo", loc_jb.getTxJnl().getJnlNo()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.srcRefNm", loc_jb.getTxJnl().getSrcRefNm()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.txStat", label+loc_jb.getTxJnl().getTxStat()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.txCode", label+loc_jb.getTxJnl().getTxCode()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.txSrc", loc_jb.getTxJnl().getTxSrc()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.txMode", loc_jb.getTxJnl().getTxMode()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.transactionId", loc_jb.getTxJnl().getTransactionId()));
					beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.endToEndId", loc_jb.getTxJnl().getEndToEndId()));
					if (loc_jb.getTxJnl().getCreateTs() != null)
					{
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.createDate", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(loc_jb.getTxJnl().getCreateTs())));
					}
					map.put("ffp.cashmanagement.transaction.txJnl", beanList);
				}
				if (loc_jb.getJnlActionList() != null && loc_jb.getJnlActionList().size() != 0)
				{

					List<List<DataLayoutBean>> actionBeanlist = new ArrayList<List<DataLayoutBean>>();
					List<FFPTxJnlAction> jnlActionList = loc_jb.getJnlActionList();
					for (FFPTxJnlAction jnlAction : jnlActionList)
					{
						List<DataLayoutBean> beanList = new ArrayList<DataLayoutBean>();
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgId", jnlAction.getMsgId()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgDirection", label+jnlAction.getMsgDirection()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgSystemId", jnlAction.getMsgSystemId()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgType", jnlAction.getMsgType()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgStatus", label+jnlAction.getMsgStatus()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgCode", jnlAction.getMsgCode()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgResult", jnlAction.getMsgResult()));
						if (jnlAction.getMsgCreatTs() != null)
						{

							beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgCreateTs", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(jnlAction.getMsgCreatTs())));
						}
						if (jnlAction.getMsgProceTs() != null)
						{

							beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgProce_ts", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(jnlAction.getMsgProceTs())));
						}
						if (jnlAction.getMsgComplTs() != null)
						{

							beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.msgComplTs", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(jnlAction.getMsgComplTs())));
						}
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.refMsgId", jnlAction.getRefMsgId()));
						beanList.add(new DataLayoutBean("ffp.cashmanagement.transaction.isAutocheck", jnlAction.getIsAutoCheck()));
						
						actionBeanlist.add(beanList);
					}
					map.put("ffp.cashmanagement.transaction.actionList", actionBeanlist);

				}

			
			}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return map;
	}
}
