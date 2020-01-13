package com.forms.ffp.bussiness.iclfps.pacs003;

import java.util.Date;

import javax.xml.bind.JAXBElement;

import com.forms.ffp.adaptor.define.FFPJaxbConstants;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_002_001_08.Document;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_002_001_08.FIToFIPaymentStatusReportV08;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_002_001_08.FPSTransactionStatusCode;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_002_001_08.GroupHeader531;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_002_001_08.ObjectFactory;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_002_001_08.OriginalGroupHeader71;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_002_001_08.PaymentTransaction801;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_002_001_08.StatusReason6Choice1;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_002_001_08.StatusReasonInformation92;
import com.forms.ffp.core.define.FFPConstants;
import com.forms.ffp.core.msg.iclfps.FFPMsgBaseHkiclMessage;
import com.forms.ffp.core.utils.FFPXMLUtils;

public class FFPMsgPacs003_Pacs002 extends FFPMsgBaseHkiclMessage
{
	private FFPVO_Pacs003 pacs003;
	
	private FFPVO_Pacs003_DrctDbtTxInf pacs003_txInf;

	private FFPVO_Pacs003_DDI02REPLY ddi02Reply;

	// Setion E
	public FFPMsgPacs003_Pacs002(FFPVO_Pacs003 ip_pacs003)
	{
		super();
		this.pacs003 = ip_pacs003;
		this.pacs003_txInf = ip_pacs003.getDrctDbtTxInf();
		this.ddi02Reply = ip_pacs003.getDdi02Reply();
		this.sendType = FFPConstants.SEND_TYPE_ACK;
		this.msgTypeName = FFPJaxbConstants.JAXB_MSG_TYPE_PACS_002;
		this.msgBizSvc = pacs003.getBizSvc();
		this.priority = pacs003.getIclfpsWrapper().getPriority();
	}

	public JAXBElement<?> marshalMsgBizDataDocument()
	{
		Document loc_doc = createDocument();
		return (new ObjectFactory()).createDocument(loc_doc);
	}

	private Document createDocument()
	{
		ObjectFactory _objectfactory = new ObjectFactory();
		
		Document doc = _objectfactory.createDocument();
		FIToFIPaymentStatusReportV08 v08 = _objectfactory.createFIToFIPaymentStatusReportV08();
		doc.setFIToFIPmtStsRpt(v08);
		
		GroupHeader531 r531 = _objectfactory.createGroupHeader531();
		r531.setMsgId(this.getMsgID());
		r531.setCreDtTm(FFPXMLUtils.toGregorianDt(new Date()));
		v08.setGrpHdr(r531);
		
		OriginalGroupHeader71 oregro = _objectfactory.createOriginalGroupHeader71();
		oregro.setOrgnlMsgId(pacs003.getMsgId());
		oregro.setOrgnlMsgNmId(FFPJaxbConstants.JAXB_MSG_TYPE_PACS_008);
		v08.setOrgnlGrpInfAndSts(oregro);
		
		PaymentTransaction801 pt = _objectfactory.createPaymentTransaction801();
		pt.setOrgnlEndToEndId(pacs003_txInf.getPmtIdEndToEndId());
		pt.setOrgnlTxId(pacs003_txInf.getPmtIdTxId());

		if ("R".equals(this.ddi02Reply.getRsltCd().toUpperCase()))
		{
			pt.setTxSts(FPSTransactionStatusCode.RJCT);
			StatusReasonInformation92 n92 = _objectfactory.createStatusReasonInformation92();
			StatusReason6Choice1 src1 = _objectfactory.createStatusReason6Choice1();
			src1.setPrtry(ddi02Reply.getRejCd());
			n92.setRsn(src1);
			if(ddi02Reply.getRejMsg() != null)
			{
				n92.getAddtlInf().add(ddi02Reply.getRejMsg());
			}
		} else if ("A".equals(this.ddi02Reply.getRsltCd().toUpperCase()))
		{
			pt.setTxSts(FPSTransactionStatusCode.ACCP);
		}
		pt.setClrSysRef(pacs003.getClrSys());
		
		v08.getTxInfAndSts().add(pt);
		
		return doc;
	}
}
