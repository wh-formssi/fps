package com.forms.ffp.webapp.cashmanagement.return_refund.service;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.springframework.web.util.HtmlUtils;

import com.forms.ffp.adaptor.define.FFPJaxbConstants;
import com.forms.ffp.adaptor.jaxb.iclfps.head_001_001_01.BusinessApplicationHeaderV01;
import com.forms.ffp.adaptor.jaxb.iclfps.head_001_001_01.FPSBusinessServiceCode;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.AccountIdentification4Choice1;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.AccountSchemeName1Choice1;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.BranchAndFinancialInstitutionIdentification51;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.CashAccount241;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.CategoryPurpose1Choice1;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.ChargeBearerType1Code1;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.ClearingSystemIdentification3Choice1;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.ClearingSystemMemberIdentification21;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.ContactDetails21;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.Document;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.FPSAccountTypeCode;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.FPSCategoryPurposeCode;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.FPSClearingSystemCode;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.FPSCurrencyCode;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.FPSCustomerCode;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.FinancialInstitutionIdentification81;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.GenericAccountIdentification11;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.GenericOrganisationIdentification11;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.GenericPersonIdentification11;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.GroupHeader721;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.ObjectFactory;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.OrganisationIdentification81;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.OrganisationIdentificationSchemeName1Choice1;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.OriginalTransactionReference241;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.Party11Choice1;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.PartyIdentification431;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.PaymentReturnReason11;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.PaymentReturnV07;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.PaymentTransaction761;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.PaymentTypeInformation251;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.PersonIdentification51;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.PersonIdentificationSchemeName1Choice1;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.RemittanceInformation111;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.Restricted15Digit2DecimalCurrencyAndAmount;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.ReturnReason5Choice1;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.SettlementInstruction41;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.SettlementMethod1Code1;
import com.forms.ffp.core.define.FFPConstants;
import com.forms.ffp.core.define.FFPConstantsServiceCode;
import com.forms.ffp.core.msg.iclfps.FFPMsgBaseHkiclMessage;
import com.forms.ffp.core.utils.FFPStringUtils;
import com.forms.ffp.core.utils.FFPXMLUtils;
import com.forms.ffp.persistents.bean.payment.returnrefund.FFPJbP300;

public class ReturnRefund_pacs004 extends FFPMsgBaseHkiclMessage {

	private FFPJbP300 p300;

	ObjectFactory _objFactory = new ObjectFactory();

	public FFPJbP300 getP300() {
		return p300;
	}

	public void setP300(FFPJbP300 p300) {
		this.p300 = p300;
	}

	public ReturnRefund_pacs004(FFPJbP300 p300) {
		super();
		this.p300 = p300;
		this.msgTypeName = FFPJaxbConstants.JAXB_MSG_TYPE_PACS_004;
		this.msgID = getMsgID();
		msgBizSvc = FFPConstantsServiceCode.ICLFPS_SERVICECODE_PAYR01;
		this.sendType = FFPConstants.SEND_TYPE_REQ;
		this.priority = FFPConstants.MQ_LEVEL_PRIORITY_HIGH;
	}

	protected JAXBElement<BusinessApplicationHeaderV01> marshalMsgBizDataHead() {
		BusinessApplicationHeaderV01 appHdr = new BusinessApplicationHeaderV01();
		appHdr.setFr(createParty(this.msgFromID));
		appHdr.setTo(createParty(this.msgToID));
		appHdr.setBizMsgIdr(this.getMsgID());
		appHdr.setMsgDefIdr(this.msgTypeName);
		appHdr.setBizSvc(FPSBusinessServiceCode.fromValue(this.msgBizSvc));
		appHdr.setCreDt(FFPXMLUtils.toGregorianDt(this.creDt));

		return (new com.forms.ffp.adaptor.jaxb.iclfps.head_001_001_01.ObjectFactory()).createAppHdr(appHdr);
	}

	public JAXBElement<?> marshalMsgBizDataDocument() {
		Document doc = createDocument();
		return (new ObjectFactory()).createDocument(doc);
	}

	/*
	 * create document
	 * 
	 */
	private Document createDocument() {

		Document doc = this._objFactory.createDocument();
		PaymentReturnV07 pr07 = new PaymentReturnV07();
		pr07.setGrpHdr(getGroupHeader721());
		getPT761(pr07);
		doc.setPmtRtr(pr07);
		return doc;
	}

	/**
	 * get document's head
	 * 
	 * @return
	 */
	public GroupHeader721 getGroupHeader721() {
		GroupHeader721 gh721 = new GroupHeader721();
		gh721.setMsgId(this.msgID);
		/**
		 * real time only one message
		 */
		gh721.setNbOfTxs("1");
		gh721.setCreDtTm(FFPXMLUtils.toGregorianDt(this.getCreDt()));
		SettlementInstruction41 n41 = new SettlementInstruction41();
		n41.setSttlmMtd(SettlementMethod1Code1.CLRG);
		ClearingSystemIdentification3Choice1 cs = new ClearingSystemIdentification3Choice1();
		cs.setPrtry(FPSClearingSystemCode.FPS);
		n41.setClrSys(cs);
		gh721.setSttlmInf(n41);
		return gh721;
	}

	private void getPT761(PaymentReturnV07 pr07) {
		List<PaymentTransaction761> list = pr07.getTxInf();
		/*
		 * realTime have only one TxInf
		 */
		PaymentTransaction761 n761 = new PaymentTransaction761();
		n761.setRtrId(p300.getReturnId());
		// n761.setOrgnlInstrId("");
		n761.setOrgnlEndToEndId(p300.getOrgnlEndToEndId());
		n761.setOrgnlTxId(p300.getOrgnlTxId());

		n761.setOrgnlClrSysRef(p300.getOrgnlClrSysRef());
		n761.setRtrdIntrBkSttlmAmt(getRDDCA(p300.getOrgnlInterbankSettAmt(), p300.getOrgnlInterbankSettCcy()));
		n761.setIntrBkSttlmDt(FFPXMLUtils.toGregorianDt(this.getCreDt()));

		if (null != p300.getRetInsAmt())
			n761.setRtrdInstdAmt(getRDDCA(p300.getRetInsAmt(), p300.getRetInsCur()));
		n761.setChrgBr(ChargeBearerType1Code1.fromValue(p300.getChrgBr()));

		// RtrRsnInf
		if (null != p300.getReasonCode())
			n761.setRtrRsnInf(getPR11());

		// :OrgnlTxRef
		n761.setOrgnlTxRef(getOTR());
		list.add(n761);
	}

	// :OrgnlTxRef
	public OriginalTransactionReference241 getOTR() {

		OriginalTransactionReference241 otr = new OriginalTransactionReference241();

		if (null != p300.getOrgnlInterbankSettAmt()){
			otr.setIntrBkSttlmAmt(getRDDCA(p300.getOrgnlInterbankSettAmt(), p300.getOrgnlInterbankSettCcy()));
			otr.setIntrBkSttlmDt(FFPXMLUtils.toGregorianDt(p300.getOrgnlInterbankSettDate()));
		}
			

		if (null != p300.getOrgnlCatgyPurp()) {
			PaymentTypeInformation251 pti = new PaymentTypeInformation251();
			CategoryPurpose1Choice1 cpc = new CategoryPurpose1Choice1();
			cpc.setPrtry(FPSCategoryPurposeCode.fromValue(p300.getOrgnlCatgyPurp()));
			pti.setCtgyPurp(cpc);
			otr.setPmtTpInf(pti);
		}

		if (null != p300.getOrgnlRemtInfo()) {
			RemittanceInformation111 ri11 = new RemittanceInformation111();
			ri11.setUstrd(p300.getOrgnlRemtInfo());
			otr.setRmtInf(ri11);
		}

		/**
		 * :Dbtr
		 */
		otr.setDbtr(createPartyIdentification1(p300.getOrgnlDbtrNm(), p300.getOrgnlDbtrOrgIdAnyBIC(),
											p300.getOrgnlDbtrOrgIdOthrId(), p300.getOrgnlDbtrOrgIdOthrIdSchmeNm(), p300.getOrgnlDbtrOrgIdOthrIssr(),
											p300.getOrgnlDbtrPrvtIdOthrId(), p300.getOrgnlDbtrPrvtIdOthrIdSchmeNm(), p300.getOrgnlDbtrPrvtIdOthrIssr(),
											p300.getOrgnlDbtrPhNo(), p300.getOrgnlDbtrEmAddr()));

		/**
		 * DbtrAcc
		 */
		if (null != p300.getOrgnlDbtrAcctNo())
			otr.setDbtrAcct(getAcct(p300.getOrgnlDbtrAcctNo(), p300.getOrgnlDbtrAcctNoTp()));

		/**
		 * DbtrAgt
		 */
		if (null != p300.getOrgnlDbtrAgtId())
			otr.setDbtrAgt(getAgt(p300.getOrgnlDbtrAgtBIC(), p300.getOrgnlDbtrAgtId()));

		/**
		 * Creditor
		 */
		otr.setCdtr(createPartyIdentification1(p300.getOrgnlCdtrNm(), p300.getOrgnlCdtrOrgIdAnyBIC(),
											p300.getOrgnlCdtrOrgIdOthrId(), p300.getOrgnlCdtrOrgIdOthrIdSchmeNm(), p300.getOrgnlCdtrOrgIdOthrIssr(),
											p300.getOrgnlCdtrPrvtIdOthrId(), p300.getOrgnlCdtrPrvtIdOthrIdSchmeNm(), p300.getOrgnlCdtrPrvtIdOthrIssr(),
											p300.getOrgnlCdtrPhNo(), p300.getOrgnlCdtrEmAddr()));
		
		/**
		 * CrediAcc
		 */
		if (null != p300.getOrgnlCdtrAcctNo())
			otr.setCdtrAcct(getAcct(p300.getOrgnlCdtrAcctNo(), p300.getOrgnlCdtrAcctNoTp()));

		/**
		 * CreAgt
		 */
		if (null != p300.getOrgnlCdtrAgtId())
			otr.setCdtrAgt(getAgt(p300.getOrgnlCdtrAgtBIC(), p300.getOrgnlCdtrAgtId()));

		return otr;
	}

	private BranchAndFinancialInstitutionIdentification51 getAgt(String bic, String agentId) {
		BranchAndFinancialInstitutionIdentification51 bii = new BranchAndFinancialInstitutionIdentification51();
		FinancialInstitutionIdentification81 fin = new FinancialInstitutionIdentification81();
		ClearingSystemMemberIdentification21 clear = new ClearingSystemMemberIdentification21();
		clear.setMmbId(agentId);
		fin.setClrSysMmbId(clear);
		fin.setBICFI(bic);
		bii.setFinInstnId(fin);
		return bii;
	}

	/**
	 * AccountNumber AccountNumberType
	 * 
	 * @param id
	 * @param type
	 * @return CashAccount241
	 */
	private CashAccount241 getAcct(String id, String type) {
		CashAccount241 account = new CashAccount241();
		AccountIdentification4Choice1 acc = new AccountIdentification4Choice1();
		GenericAccountIdentification11 gacId = new GenericAccountIdentification11();
		gacId.setId(id);
		AccountSchemeName1Choice1 Nm = new AccountSchemeName1Choice1();
		Nm.setPrtry(FPSAccountTypeCode.fromValue(type));
		gacId.setSchmeNm(Nm);
		acc.setOthr(gacId);
		account.setId(acc);
		return account;
	}

	/**
	 * Information
	 */
	private PartyIdentification431 createPartyIdentification1(String acctName, String OrgIdAnyBIC,
												String OrgIdOthrId, String OrgIdOthrIdSchmeNm, String OrgIdOthrIssr,
												String PrvtIdOthrId, String PrvtIdOthrIdSchmeNm, String PrvtIdOthrIssr,
												String phoneNo, String emailAddr)
	{
		PartyIdentification431 pi = new PartyIdentification431();
		pi.setNm(acctName != null ? HtmlUtils.htmlUnescape(acctName) : null);
		if(!FFPStringUtils.isEmptyOrNull(PrvtIdOthrId))
		{
			Party11Choice1 id = this._objFactory.createParty11Choice1();
			PersonIdentification51 prvtId = this._objFactory.createPersonIdentification51();
			GenericPersonIdentification11 othr = this._objFactory.createGenericPersonIdentification11();
			PersonIdentificationSchemeName1Choice1 schmeNm = this._objFactory.createPersonIdentificationSchemeName1Choice1();
			schmeNm.setCd(FPSCustomerCode.fromValue(PrvtIdOthrIdSchmeNm));
			othr.setId(PrvtIdOthrId);
			othr.setSchmeNm(schmeNm);
			prvtId.setOthr(othr);
			id.setPrvtId(prvtId);
			pi.setId(id);
		}
		else if(!FFPStringUtils.isEmptyOrNull(OrgIdOthrId))
		{
			Party11Choice1 id = this._objFactory.createParty11Choice1();
			OrganisationIdentification81 orgId = this._objFactory.createOrganisationIdentification81();
			GenericOrganisationIdentification11 othr = this._objFactory.createGenericOrganisationIdentification11();
			OrganisationIdentificationSchemeName1Choice1 schmeNm = this._objFactory.createOrganisationIdentificationSchemeName1Choice1();
			schmeNm.setCd(FPSCustomerCode.fromValue(OrgIdOthrIdSchmeNm));
			othr.setSchmeNm(schmeNm);
			othr.setId(OrgIdOthrId);
			othr.setIssr(OrgIdOthrIssr);
			orgId.setOthr(othr);
			orgId.setAnyBIC(OrgIdAnyBIC);
			id.setOrgId(orgId);
			pi.setId(id);
		}
		
		if(phoneNo != null || emailAddr != null)
		{
			ContactDetails21 details = this._objFactory.createContactDetails21();
			details.setMobNb(phoneNo);
			details.setEmailAdr(emailAddr);
			pi.setCtctDtls(details);
		}
		
		return pi;
	}

	public Restricted15Digit2DecimalCurrencyAndAmount getRDDCA(BigDecimal amt, String ccy) {
		Restricted15Digit2DecimalCurrencyAndAmount rddca = new Restricted15Digit2DecimalCurrencyAndAmount();
		rddca.setCcy(FPSCurrencyCode.fromValue(ccy));
		rddca.setValue(amt);
		return rddca;
	}

	// RtrRsnInf
	public PaymentReturnReason11 getPR11() {
		PaymentReturnReason11 pr11 = new PaymentReturnReason11();
		ReturnReason5Choice1 rsn = new ReturnReason5Choice1();
		rsn.setPrtry(p300.getReasonCode());// 返回码
		pr11.setRsn(rsn);
		pr11.getAddtlInf().add("/REASON/" + p300.getAdditionalInformation());
		return pr11;
	}

}
