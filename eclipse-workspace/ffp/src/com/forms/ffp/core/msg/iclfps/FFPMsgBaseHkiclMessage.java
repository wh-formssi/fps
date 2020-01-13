package com.forms.ffp.core.msg.iclfps;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBElement;

import com.forms.ffp.adaptor.jaxb.iclfps.fps_envelope_01.FpsMessageEnvelope;
import com.forms.ffp.adaptor.jaxb.iclfps.fps_envelope_01.FpsMessagePayloads;
import com.forms.ffp.adaptor.jaxb.iclfps.fps_envelope_01.ISO20022BusinessDataV01;
import com.forms.ffp.adaptor.jaxb.iclfps.head_001_001_01.BranchAndFinancialInstitutionIdentification51;
import com.forms.ffp.adaptor.jaxb.iclfps.head_001_001_01.BusinessApplicationHeaderV01;
import com.forms.ffp.adaptor.jaxb.iclfps.head_001_001_01.ClearingSystemMemberIdentification21;
import com.forms.ffp.adaptor.jaxb.iclfps.head_001_001_01.FPSBusinessServiceCode;
import com.forms.ffp.adaptor.jaxb.iclfps.head_001_001_01.FinancialInstitutionIdentification81;
import com.forms.ffp.adaptor.jaxb.iclfps.head_001_001_01.Party9Choice1;
import com.forms.ffp.core.config.runtime.FFPRuntimeConstants;
import com.forms.ffp.core.utils.FFPIDUtils;
import com.forms.ffp.core.utils.FFPXMLUtils;

public abstract class FFPMsgBaseHkiclMessage
{
	protected String sendType;

	protected String priority;

	protected int payloadCount = 1;

	protected String msgID;

	protected String msgFromID;

	protected String msgToID;

	protected String msgTypeName;

	protected String msgBizSvc;

	protected Date creDt;
	
	public FFPMsgBaseHkiclMessage()
	{
		//msgFromID = FFPRuntimeConstants.LOCAL_FPS_PARTICIPANT_ID;
		//msgToID = FFPRuntimeConstants.ICL_FPS_ID;
		
		msgToID = FFPRuntimeConstants.LOCAL_FPS_PARTICIPANT_ID;
		msgFromID = FFPRuntimeConstants.ICL_FPS_ID;
		creDt = new Date();
	}
	
	public FFPMsgBaseHkiclMessage(String msgTypeName, String msgBizSvc)
	{
		this.msgTypeName = msgTypeName;
		this.msgBizSvc = msgBizSvc;
		msgFromID = FFPRuntimeConstants.LOCAL_FPS_PARTICIPANT_ID;
		msgToID = FFPRuntimeConstants.ICL_FPS_ID;
		creDt = new Date();
	}

	public String parseHkiclMessage() throws Exception
	{
		String message = null;
		FpsMessageEnvelope envelope = new FpsMessageEnvelope();
		envelope.setNbOfMsgs(String.valueOf(payloadCount));
		
		List<ISO20022BusinessDataV01> bizData = this.marshalMsgBizDataList(); ///bizData
		FpsMessagePayloads payloads = new FpsMessagePayloads();
		payloads.getBizData().addAll(bizData);
		envelope.setFpsPylds(payloads);

		message = FFPHkiclMessageConverter.makeupRealTimeXml(FFPHkiclMessageConverter.packageXml(envelope));

		message = FFPHkiclMessageConverter.signXml(message);

		return message;
	}
	
	public List<ISO20022BusinessDataV01> marshalMsgBizDataList()
	{
		List<ISO20022BusinessDataV01> bizDataList = new ArrayList<ISO20022BusinessDataV01>();
		ISO20022BusinessDataV01 bizData = new ISO20022BusinessDataV01();
		bizData.getContent().add(marshalMsgBizDataHead());
		bizData.getContent().add(marshalMsgBizDataDocument());
		bizDataList.add(bizData);
		return bizDataList;
	}
	
	protected ISO20022BusinessDataV01 marshalMsgBizData()
	{
		ISO20022BusinessDataV01 bizData = new ISO20022BusinessDataV01();
		bizData.getContent().add(marshalMsgBizDataHead());
		bizData.getContent().add(marshalMsgBizDataDocument());
		return bizData;
	}

	protected JAXBElement<BusinessApplicationHeaderV01> marshalMsgBizDataHead()
	{
		BusinessApplicationHeaderV01 appHdr = new BusinessApplicationHeaderV01();
		appHdr.setFr(createParty(this.msgFromID));
		appHdr.setTo(createParty(this.msgToID));
		appHdr.setBizMsgIdr(this.getMsgID());
		appHdr.setMsgDefIdr(this.msgTypeName);
		appHdr.setBizSvc(FPSBusinessServiceCode.fromValue(this.msgBizSvc));
		appHdr.setCreDt(FFPXMLUtils.toGregorianDt(this.creDt));
		
		return (new com.forms.ffp.adaptor.jaxb.iclfps.head_001_001_01.ObjectFactory()).createAppHdr(appHdr);
	}

	public JAXBElement<?> marshalMsgBizDataDocument()
	{
		return null;
	}
	
	protected Party9Choice1 createParty(String mmbId)
	{
		Party9Choice1 party = new Party9Choice1();
		BranchAndFinancialInstitutionIdentification51 fiId = new BranchAndFinancialInstitutionIdentification51();
		FinancialInstitutionIdentification81 finInstnId = new FinancialInstitutionIdentification81();
		ClearingSystemMemberIdentification21 clrSysMmbId = new ClearingSystemMemberIdentification21();
		clrSysMmbId.setMmbId(mmbId);
		finInstnId.setClrSysMmbId(clrSysMmbId);
		fiId.setFinInstnId(finInstnId);
		party.setFIId(fiId);
		return party;
	}

	public String getSendType()
	{
		return this.sendType;
	}

	public String getPriority()
	{
		return this.priority;
	}

	public String getMsgID()
	{
		if(this.msgID == null)
		{
			msgID = FFPIDUtils.getMessageId();
		}
		return this.msgID;
	}

	public void setMsgID(String msgID)
	{
		this.msgID = msgID;
	}

	public String getMsgFromID()
	{
		return msgFromID;
	}

	public void setMsgFromID(String msgFromID)
	{
		this.msgFromID = msgFromID;
	}

	public String getMsgToID()
	{
		return msgToID;
	}

	public void setMsgToID(String msgToID)
	{
		this.msgToID = msgToID;
	}

	public String getMsgTypeName()
	{
		return msgTypeName;
	}

	public void setMsgTypeName(String msgTypeName)
	{
		this.msgTypeName = msgTypeName;
	}

	public String getMsgBizSvc()
	{
		return msgBizSvc;
	}

	public void setMsgBizSvc(String msgBizSvc)
	{
		this.msgBizSvc = msgBizSvc;
	}

	public Date getCreDt()
	{
		return creDt;
	}

	public void setCreDt(Date creDt)
	{
		this.creDt = creDt;
	}

}
