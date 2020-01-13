package com.forms.batch.job.unit.iclfps.payment.message;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.forms.ffp.adaptor.define.FFPJaxbConstants;
import com.forms.ffp.adaptor.jaxb.participant.request.BODY;
import com.forms.ffp.adaptor.jaxb.participant.request.ffprri01.FFPRRI01;
import com.forms.ffp.adaptor.jaxb.participant.request.ffprri01.RTRRSNINF;
import com.forms.ffp.adaptor.jaxb.participant.request.head.HEAD;
import com.forms.ffp.adaptor.jaxb.participant.response.ROOT;
import com.forms.ffp.core.define.FFPConstants;
import com.forms.ffp.core.msg.participant.FFPMsgBaseParticipantMessage;
import com.forms.ffp.core.msg.participant.FFPParticipantMessageConverter;
import com.forms.ffp.core.utils.FFPDateUtils;
import com.forms.ffp.core.utils.FFPIDUtils;
import com.forms.ffp.core.utils.FFPStringUtils;
import com.forms.ffp.persistents.bean.payment.returnrefund.FFPJbP300;

public class FFPBatchMsg_RRI01 extends FFPMsgBaseParticipantMessage
{
	private FFPJbP300 p300Jb = null;
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public FFPBatchMsg_RRI01(FFPJbP300 p300Jb)
	{
		super();
		this.msgType = FFPJaxbConstants.JAXB_MSG_TYPE_FFPRRI01;
		this.p300Jb = p300Jb;
		this.requestID = FFPConstants.MSG_CODE_FFP;
		this.responseID = FFPConstants.MSG_CODE_AGENT;
	}
	
	public HEAD marshalMsgReqHead()
	{
		HEAD head = new HEAD();
		
		head.setRequestID(this.requestID);
		head.setResponseID(this.responseID);
		head.setRequestRefno(FFPStringUtils.isEmptyOrNull(this.reqRefNo) ? FFPIDUtils.getRefno() : reqRefNo);
		head.setTransactionDate(FFPDateUtils.getDateStr(new Date(), FFPDateUtils.INT_DATE_FORMAT));
		head.setTransactionTime(FFPDateUtils.getTimeStr(FFPDateUtils.getTime(new Date()), FFPDateUtils.INT_TIME_FORMAT));
		head.setAccountingDate(FFPDateUtils.getDateStr(new Date(), FFPDateUtils.INT_DATE_FORMAT));
		head.setMessageType(this.msgType);
		return head;
	}
	
	public BODY marshalMsgReqBody()
	{
		BODY body = null;
		FFPRRI01 rri01 = new FFPRRI01();
		rri01.setSrcRefNm(p300Jb.getTxJnl().getSrcRefNm());
		rri01.setPymtCatPrps(p300Jb.getOrgnlCatgyPurp());
		rri01.setRtrdSettlDate(p300Jb.getSettlementDate() != null ? sdf.format(p300Jb.getSettlementDate()) : null);
		rri01.setRtrdSettlAmt(p300Jb.getRetIntSetAmt());
		rri01.setRtrdSettlCcy(p300Jb.getRetIntSetCur());
		rri01.setRtrdInstrAmt(p300Jb.getRetInsAmt());
		rri01.setRtrdInstrCcy(p300Jb.getRetInsCur());
		rri01.setRtrdChrgrsAmt(p300Jb.getChargersAmount());
		rri01.setRtrdChrgrsCcy(p300Jb.getChargersCurrency());
		
		//Original debtor is the creditor for refund
		rri01.setCdtrNm(p300Jb.getOrgnlDbtrNm());
		rri01.setCdtrAcNo(p300Jb.getOrgnlDbtrAcctNo());
		rri01.setCdtrAcTp(p300Jb.getOrgnlDbtrAcctNoTp());
		//email, phone number
		RTRRSNINF rtnInfo = new RTRRSNINF();
		rri01.setRtrRsnInf(rtnInfo);
		rtnInfo.setPrtryCd(p300Jb.getReasonCode());
		rtnInfo.setAddtlInf(p300Jb.getAdditionalInformation());
		body = rri01;
		return body;
	}
	
	public void unmarshalResponseMsg(String ip_responseMsg) throws Exception
	{
		try
		{
			ROOT root = FFPParticipantMessageConverter.parseXml2ReponseObject(ip_responseMsg);
			com.forms.ffp.adaptor.jaxb.participant.response.head.HEAD head = root.getHEAD();
			com.forms.ffp.adaptor.jaxb.participant.response.BODY body = root.getBODY();
			com.forms.ffp.adaptor.jaxb.participant.response.ffprri01.FFPRRI01 rri01 = (com.forms.ffp.adaptor.jaxb.participant.response.ffprri01.FFPRRI01)body;
			
			if(this.reqRefNo.equals(head.getRequestRefno()) && p300Jb.getTxJnl().getSrcRefNm().equals(rri01.getSrcRefNm()))
			{
				//parse response head
				this.requestID = head.getRequestID();
				this.responseID = head.getResponseID();
				this.resRefNo = head.getResponseRefno();
				this.reqRefNo = head.getRequestRefno();
				this.responseSts = head.getResponseStatus();
				this.responseMsgCode = head.getResponseMessageCode();
				this.responseMsg = head.getResponseMessage();
				this.rsltCd = rri01.getRsltCd();
				this.rejCd = rri01.getRejCd();
				this.rejMsg = rri01.getRejMsg();
			}
			else
			{
				throw new Exception(String.format("Invalid response message from Agent[RequestRefNum = %s] to FFP[OrigRequestRefNum = %s]", head.getRequestRefno(), this.reqRefNo));
			}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		return;
	}
}
