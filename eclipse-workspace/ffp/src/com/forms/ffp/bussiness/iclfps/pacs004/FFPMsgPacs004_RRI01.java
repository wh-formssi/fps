package com.forms.ffp.bussiness.iclfps.pacs004;

import com.forms.ffp.adaptor.define.FFPJaxbConstants;
import com.forms.ffp.adaptor.jaxb.participant.request.BODY;
import com.forms.ffp.adaptor.jaxb.participant.request.ffprri01.FFPRRI01;
import com.forms.ffp.adaptor.jaxb.participant.request.ffprri01.RTRRSNINF;
import com.forms.ffp.core.define.FFPConstants;
import com.forms.ffp.core.msg.participant.FFPMsgBaseParticipantMessage;
import com.forms.ffp.core.msg.participant.FFPParticipantMessageConverter;
import com.forms.ffp.persistents.bean.payment.returnrefund.FFPJbP300;

public class FFPMsgPacs004_RRI01 extends FFPMsgBaseParticipantMessage
{

	private FFPVO_Pacs004_TxInf txinf = null;

	public FFPMsgPacs004_RRI01(FFPVO_Pacs004_TxInf txinf)
	{
		super();
		this.txinf = txinf;
		this.reqRefNo = this.getReqRefNo();
		this.requestID = FFPConstants.MSG_CODE_FFP;
		this.responseID = FFPConstants.MSG_CODE_AGENT;
		msgType = FFPJaxbConstants.JAXB_MSG_TYPE_FFPRRI01;
	}

	public BODY marshalMsgReqBody()
	{
		FFPRRI01 rri = new FFPRRI01();
		FFPJbP300 p300 = txinf.getP300();
		rri.setSrcRefNm(p300.getTxJnl().getSrcRefNm());
		rri.setPymtCatPrps(p300.getOrgnlCatgyPurp());

		// settlementAmout
		rri.setRtrdSettlAmt(p300.getRetIntSetAmt());
		rri.setRtrdSettlCcy(p300.getRetIntSetCur());
		rri.setRtrdSettlDate(p300.getSettlementDate().toString());

		rri.setRtrdInstrAmt(p300.getRetInsAmt());
		rri.setRtrdInstrCcy(p300.getRetInsCur());

		// information
		RTRRSNINF inf = new RTRRSNINF();
		inf.setPrtryCd(p300.getReasonCode());
		inf.setAddtlInf(p300.getAdditionalInformation());
		rri.setRtrRsnInf(inf);

		// creditor
		rri.setCdtrNm(p300.getOrgnlDbtrNm());
		rri.setCdtrAcNo(p300.getOrgnlDbtrAcctNo());
		rri.setCdtrAcTp(p300.getOrgnlDbtrAcctNoTp());
		rri.setCdtrContEmailAddr(p300.getOrgnlDbtrPhNo());
		rri.setCdtrContPhone(p300.getOrgnlDbtrEmAddr());

		rri.setRtrdChrgrsAmt(p300.getChargersAmount());
		rri.setRtrdChrgrsCcy(p300.getChargersCurrency());

		rri.setPymtCatPrps(p300.getOrgnlCatgyPurp());

		// txinf.setPytPurp(p300.getPytPurp());
		// txinf.setRemInfo(p300.getRemInfo());

		// rri.setOrgnlTxRef(txinf);
		return rri;
	}

	public void unmarshalResponseMsg(String respMessage) throws Exception
	{
		com.forms.ffp.adaptor.jaxb.participant.response.ROOT root = FFPParticipantMessageConverter.parseXml2ReponseObject(respMessage);
		com.forms.ffp.adaptor.jaxb.participant.response.BODY body = root.getBODY();
		com.forms.ffp.adaptor.jaxb.participant.response.ffprri01.FFPRRI01 rri01 = (com.forms.ffp.adaptor.jaxb.participant.response.ffprri01.FFPRRI01) body;

		if (this.txinf.getP300().getTxJnl().getSrcRefNm().equals(rri01.getSrcRefNm()))
		{
			this.resRefNo = root.getHEAD().getResponseRefno();
			FFPVO_Pacs004_RRI01REPLY reply = new FFPVO_Pacs004_RRI01REPLY();
			reply.setSrcRefNm(rri01.getSrcRefNm());
			reply.setRsltCd(rri01.getRsltCd());
			reply.setRejCd(rri01.getRejCd());
			reply.setRejMsg(rri01.getRejMsg());
			txinf.setReply(reply);
		}
		return;
	}
}
