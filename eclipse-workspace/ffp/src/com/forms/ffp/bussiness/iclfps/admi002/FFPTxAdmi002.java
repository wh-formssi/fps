package com.forms.ffp.bussiness.iclfps.admi002;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.forms.ffp.adaptor.jaxb.iclfps.admi_002_001_01.Document;
import com.forms.ffp.adaptor.jaxb.iclfps.admi_002_001_01.RejectionReason21;
import com.forms.ffp.adaptor.jaxb.iclfps.fps_envelope_01.ISO20022BusinessDataV01;
import com.forms.ffp.bussiness.utils.FFPJnlUtils;
import com.forms.ffp.core.define.FFPConstants;
import com.forms.ffp.core.define.FFPConstantsTxJnl;
import com.forms.ffp.core.utils.FFPEmailUtils;
import com.forms.ffp.persistents.bean.FFPTxBase;
import com.forms.ffp.persistents.bean.FFPTxJnl;
import com.forms.ffp.persistents.bean.FFPTxJnlAction;
import com.forms.ffp.persistents.dao.FFPIDao_TxJnl;
import com.forms.ffp.persistents.service.FFPIDaoService_TxjnlAction;
import com.forms.ffp.webapp.cashmanagement.transactionstatus.service.ITransactionStatusService;

@Component("ICL.admi.002.001.01")
@Scope("prototype")
public class FFPTxAdmi002 extends FFPTxBase
{
	private static Logger _logger = LoggerFactory.getLogger(FFPTxAdmi002.class);

	@Resource(name = "FFPIDao_TxJnl")
	private FFPIDao_TxJnl txJnlDao;

	@Resource(name = "FFPDaoService_TxjnlAction")
	private FFPIDaoService_TxjnlAction txJnlActionService;
	@Resource(name = "TransactionStatusService")
	private ITransactionStatusService transactionStatusService;

	@Override
	public void perform() throws Exception
	{
		if ("ICL.admi.002.001.01".equals(this.serviceName))
		{
			FFPVO_Admi002 admi002 = (FFPVO_Admi002) this.txVo;
			StringBuffer loc_sb = new StringBuffer();
			loc_sb.append("ref=" + admi002.getRef());
			loc_sb.append(",rjctgPtyRsn=" + admi002.getRjctgPtyRsn());
			loc_sb.append(",rjctnDtTm=" + admi002.getRjctnDtTm());
			loc_sb.append(",rsnDesc=" + admi002.getRsnDesc());
			loc_sb.append(",addtlData=" + admi002.getAddtlData());
			_logger.error(loc_sb.toString());
			FFPEmailUtils.sendMaintainEmail("FFPADMI002(" + admi002.getBizMsgIdr() + ")",
					"ORG MSG ID=" + admi002.getRef() + "<br>REJECT CODE=" + admi002.getRjctgPtyRsn() + "<br>REJECT MSG=" + admi002.getRsnDesc());
			if (!"NOREF".equals(admi002.getRef()))
			{
				updateAction(admi002);
			}
		}

	}
	public void updateAction(FFPVO_Admi002 admi002) throws Exception
	{
		if (null == admi002)
			return;
		FFPTxJnlAction orgJnlAction = txJnlActionService.inquiryJnlActionByMsgId(admi002.getRef());
		FFPTxJnl txJnl = txJnlDao.inquiryByJnlNo(orgJnlAction.getJnlNo());

		Date loc_date = new Date();

		FFPTxJnlAction jnlAction = FFPJnlUtils.getInstance().newJnlAction(orgJnlAction.getJnlNo(), admi002.getBizMsgIdr(), FFPConstants.MSG_DIRECTION_INWARD, FFPConstants.RELATION_SYSTEM_HKICL,
				admi002.getMsgDefIdr(), FFPConstantsTxJnl.MSG_STATUS.MSG_STAT_MSYNC.getStatus(), admi002.getRjctgPtyRsn(), admi002.getRsnDesc(), admi002.getCreateDate(), loc_date, loc_date,
				admi002.getRef(), null);

		txJnlActionService.insertUpdateTxJnlAction(jnlAction);
		if (!FFPConstantsTxJnl.TX_STATUS.TX_STAT_COMPL.getStatus().equals(txJnl.getTxStat()) && !FFPConstantsTxJnl.TX_STATUS.TX_STAT_CANCEL.getStatus().equals(txJnl.getTxStat())
				&& !FFPConstantsTxJnl.TX_STATUS.TX_STAT_FPS_REJCT.getStatus().equals(txJnl.getTxStat()))
		{
			txJnl.setTxStat(FFPConstantsTxJnl.TX_STATUS.TX_STAT_FPS_REJCT.getStatus());
			txJnl.setLastUpdateTs(loc_date);
			txJnlDao.updateJnlStat(txJnl);
		}
	}

	@Override
	public boolean validate() throws Exception
	{
		return true;
	}

	public void parseISO20022BizData(ISO20022BusinessDataV01 bizData) throws Exception
	{
		if ("ICL.admi.002.001.01".equals(this.serviceName))
		{
			txVo = new FFPVO_Admi002();
			parseISO20022BizDataHead(bizData);
			FFPVO_Admi002 loc_jb = (FFPVO_Admi002) txVo;
			Document doc = (Document) bizData.getContent().get(1).getValue();
			if (null != doc.getAdmi00200101().getRltdRef().getRef())
				loc_jb.setRef(doc.getAdmi00200101().getRltdRef().getRef());
			RejectionReason21 rsn = doc.getAdmi00200101().getRsn();
			if (null != rsn)
			{
				if (null != rsn.getRjctgPtyRsn())
					loc_jb.setRjctgPtyRsn(rsn.getRjctgPtyRsn());
				if (null != rsn.getRjctnDtTm())
					loc_jb.setRjctnDtTm(rsn.getRjctnDtTm().toGregorianCalendar().getTime());
				loc_jb.setAddtlData(rsn.getAddtlData());
				loc_jb.setRsnDesc(rsn.getRsnDesc());

			}
		}
	}
}
