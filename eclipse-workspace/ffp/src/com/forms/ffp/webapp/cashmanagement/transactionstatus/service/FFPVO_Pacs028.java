package com.forms.ffp.webapp.cashmanagement.transactionstatus.service;

import com.forms.ffp.bussiness.FFPVOBase;
import com.forms.ffp.persistents.bean.tx.inquiry.I110.FFPJbI110;

public class FFPVO_Pacs028 extends FFPVOBase
{
	private String jnlNo;
	private String txStat;
	private String txCode;
	private String clrSysRef;
	private String dbtrAgtMmbId;
	private String cdtrAgtMmbId;
	private String transactionId;
	private String endToEndId;
	private String txRejCode;
	private String txRejReason;

	private String msgId;
	private String orgnlMsgId;
	private String orgnlMsgNmId;

	public FFPVO_Pacs028()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public FFPVO_Pacs028(FFPJbI110 form)
	{
		this.jnlNo = form.getJnlNo();
		this.txStat = form.getTxStat();
		this.txCode = form.getTxCode();
		this.clrSysRef = form.getClrSysRef();
		this.dbtrAgtMmbId = form.getDbtrAgtMmbId();
		this.cdtrAgtMmbId = form.getCdtrAgtMmbId();
		this.transactionId = form.getTransactionId();
		this.endToEndId = form.getEndToEndId();
		this.txRejCode = form.getTxCode();
		this.txRejReason = form.getTxRejCode();
		this.msgId = form.getMsgId();
		this.orgnlMsgId = form.getOrgnlMsgId();
		this.orgnlMsgNmId = form.getOrgnlMsgId();

	}

	public String getJnlNo()
	{
		return jnlNo;
	}

	public void setJnlNo(String jnlNo)
	{
		this.jnlNo = jnlNo;
	}

	public String getTxStat()
	{
		return txStat;
	}

	public void setTxStat(String txStat)
	{
		this.txStat = txStat;
	}

	public String getTxCode()
	{
		return txCode;
	}

	public void setTxCode(String txCode)
	{
		this.txCode = txCode;
	}

	public String getClrSysRef()
	{
		return clrSysRef;
	}

	public void setClrSysRef(String clrSysRef)
	{
		this.clrSysRef = clrSysRef;
	}

	public String getDbtrAgtMmbId()
	{
		return dbtrAgtMmbId;
	}

	public void setDbtrAgtMmbId(String dbtrAgtMmbId)
	{
		this.dbtrAgtMmbId = dbtrAgtMmbId;
	}

	public String getCdtrAgtMmbId()
	{
		return cdtrAgtMmbId;
	}

	public void setCdtrAgtMmbId(String cdtrAgtMmbId)
	{
		this.cdtrAgtMmbId = cdtrAgtMmbId;
	}

	public String getTransactionId()
	{
		return transactionId;
	}

	public void setTransactionId(String transactionId)
	{
		this.transactionId = transactionId;
	}

	public String getEndToEndId()
	{
		return endToEndId;
	}

	public void setEndToEndId(String endToEndId)
	{
		this.endToEndId = endToEndId;
	}

	public String getTxRejCode()
	{
		return txRejCode;
	}

	public void setTxRejCode(String txRejCode)
	{
		this.txRejCode = txRejCode;
	}

	public String getTxRejReason()
	{
		return txRejReason;
	}

	public void setTxRejReason(String txRejReason)
	{
		this.txRejReason = txRejReason;
	}

	public String getMsgId()
	{
		return msgId;
	}

	public void setMsgId(String msgId)
	{
		this.msgId = msgId;
	}

	public String getOrgnlMsgId()
	{
		return orgnlMsgId;
	}

	public void setOrgnlMsgId(String orgnlMsgId)
	{
		this.orgnlMsgId = orgnlMsgId;
	}

	public String getOrgnlMsgNmId()
	{
		return orgnlMsgNmId;
	}

	public void setOrgnlMsgNmId(String orgnlMsgNmId)
	{
		this.orgnlMsgNmId = orgnlMsgNmId;
	}
}
