package com.forms.batch.job.unit.participant.message.ffpcto01;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBElement;
import com.forms.ffp.adaptor.define.FFPJaxbConstants;
import com.forms.ffp.adaptor.jaxb.iclfps.fps_envelope_01.BatchInformation;
import com.forms.ffp.adaptor.jaxb.iclfps.fps_envelope_01.FpsMessageEnvelope;
import com.forms.ffp.adaptor.jaxb.iclfps.fps_envelope_01.FpsMessagePayloads;
import com.forms.ffp.adaptor.jaxb.iclfps.fps_envelope_01.ISO20022BusinessDataV01;
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
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.RemittanceInformation111;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.Restricted15Digit2DecimalCurrencyAndAmount;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.ReturnReason5Choice1;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.SettlementInstruction41;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.SettlementMethod1Code1;
import com.forms.ffp.core.define.FFPConstants;
import com.forms.ffp.core.define.FFPConstantsServiceCode;
import com.forms.ffp.core.msg.iclfps.FFPHkiclMessageConverter;
import com.forms.ffp.core.msg.iclfps.FFPMsgBaseHkiclMessage;
import com.forms.ffp.core.utils.FFPStringUtils;
import com.forms.ffp.core.utils.FFPValidateUtils;
import com.forms.ffp.core.utils.FFPXMLUtils;
import com.forms.ffp.persistents.bean.payment.returnrefund.FFPJbP300;

public class FFPMsgCTO01_Pacs004 extends FFPMsgBaseHkiclMessage{

	private List<FFPJbP300> txJb = null;
	
	private Map<String,String> btchMap = null;

	private ObjectFactory _objFactory = new ObjectFactory();
	
	public FFPMsgCTO01_Pacs004(List<FFPJbP300> txJb, Map<String,String> btchMap) {
		super();
		this.txJb = txJb;
		this.btchMap = btchMap;
		this.msgTypeName = FFPJaxbConstants.JAXB_MSG_TYPE_PACS_004;
		this.msgBizSvc = FFPConstantsServiceCode.ICLFPS_SERVICECODE_PAYR01;
	}

	@Override
	public String parseHkiclMessage() throws Exception {
		String message = null;
		FpsMessageEnvelope envelope = new FpsMessageEnvelope();
		BatchInformation BtchInf = new BatchInformation();
		
		if(btchMap != null){
			BtchInf.setBtchId(btchMap.get("BtchId"));
			BtchInf.setFlSeqNo(btchMap.get("FlSeqNo"));
			BtchInf.setNbOfFls(btchMap.get("NbOfFls"));
			envelope.setBtchInf(BtchInf);
			envelope.setNbOfMsgs(btchMap.get("NbOfMsgs"));
		}
		
		List<ISO20022BusinessDataV01> bizData = this.marshalMsgBizDataList(); ///bizData
		FpsMessagePayloads payloads = new FpsMessagePayloads();
		payloads.getBizData().addAll(bizData);
		envelope.setFpsPylds(payloads);

		message = FFPHkiclMessageConverter.makeupRealTimeXml(FFPHkiclMessageConverter.packageXml(envelope));

		message = FFPHkiclMessageConverter.signXml(message);

		return message;
	}

	
	private String createMsgId(String msgID) {
		if(msgID == null){
			this.msgID = this.getMsgID();
		}
		return this.msgID;
	}
		
	@Override
	protected JAXBElement<BusinessApplicationHeaderV01> marshalMsgBizDataHead() {
		BusinessApplicationHeaderV01 appHdr = new BusinessApplicationHeaderV01();
		appHdr.setFr(createParty(this.msgFromID));
		appHdr.setTo(createParty(this.msgToID));
		appHdr.setBizMsgIdr(createMsgId(this.msgID));
		appHdr.setMsgDefIdr(this.msgTypeName);
		appHdr.setBizSvc(FPSBusinessServiceCode.fromValue(this.msgBizSvc));
		appHdr.setCreDt(FFPXMLUtils.toGregorianDt(this.creDt));

		return (new com.forms.ffp.adaptor.jaxb.iclfps.head_001_001_01.ObjectFactory()).createAppHdr(appHdr);
	}

	@Override
	public JAXBElement<?> marshalMsgBizDataDocument() {
		Document loc_doc = createDocument();
		return (new ObjectFactory()).createDocument(loc_doc);
	}

	private Document createDocument() {
		Document doc = this._objFactory.createDocument();
		
		PaymentReturnV07 PmtRtr = this._objFactory.createPaymentReturnV07(); 
		
		for(FFPJbP300 p300 : txJb)
		{
			PaymentTransaction761 sigleTxInf = createPaymentTransaction(p300);
			PmtRtr.getTxInf().add(sigleTxInf);
		}
		
		GroupHeader721 GrpHdr = this._objFactory.createGroupHeader721(); 
		SettlementInstruction41 SttlmInf = new SettlementInstruction41();
		
		GrpHdr.setMsgId(createMsgId(this.msgID));
		GrpHdr.setCreDtTm(FFPXMLUtils.toGregorianDt(this.getCreDt()));
		GrpHdr.setNbOfTxs(this.btchMap.get("NbOfTxs"));
		
		ClearingSystemIdentification3Choice1 ClrSys = this._objFactory.createClearingSystemIdentification3Choice1();
		ClrSys.setPrtry(FPSClearingSystemCode.FPS);
		
		SttlmInf.setClrSys(ClrSys);
		SttlmInf.setSttlmMtd(SettlementMethod1Code1.CLRG);
		
		GrpHdr.setSttlmInf(SttlmInf);
		PmtRtr.setGrpHdr(GrpHdr);
		
		doc.setPmtRtr(PmtRtr);
		
		return doc;
	}
	
	private PaymentTransaction761 createPaymentTransaction(FFPJbP300 p300) {
		PaymentTransaction761 txInf = this._objFactory.createPaymentTransaction761();
		txInf.setRtrId("");// TODO Transaction ID (Sc.A) or FPS Reference Number
		txInf.setOrgnlEndToEndId(p300.getTxJnl().getEndToEndId());
		txInf.setOrgnlTxId(p300.getTxJnl().getTransactionId());
		txInf.setOrgnlClrSysRef("");
		txInf.setRtrdIntrBkSttlmAmt(createCurrencyAndAmount(p300.getRetIntSetCur(), p300.getRetIntSetAmt()));
		/*
		 * TODO DT is get from DB		
		 * FFPXMLUtils.toGregorianDt(new Date())
		 */
		txInf.setIntrBkSttlmDt(FFPXMLUtils.toGregorianDtType1(null));
		txInf.setRtrdInstdAmt(createCurrencyAndAmount(p300.getRetInsCur(), p300.getRetInsAmt()));
		
		txInf.setChrgBr(ChargeBearerType1Code1.SLEV);//???
		
		txInf.setRtrRsnInf(createPaymentReturnReason(p300));
		txInf.setOrgnlTxRef(createOriginalTransactionReference(p300));
		
		return txInf;
	}
	
	private Restricted15Digit2DecimalCurrencyAndAmount createCurrencyAndAmount(String currency, BigDecimal amount) {
		String loc_currency = FFPStringUtils.getStringValue(currency);
		if (FFPValidateUtils.isNullObject(new Object[] { amount }).booleanValue())
		{
			return null;
		}

		Restricted15Digit2DecimalCurrencyAndAmount currencyAndAmount = this._objFactory.createRestricted15Digit2DecimalCurrencyAndAmount();
		currencyAndAmount.setCcy(FPSCurrencyCode.fromValue(loc_currency));
		currencyAndAmount.setValue(amount);

		return currencyAndAmount;
	}
	
	private  PaymentReturnReason11 createPaymentReturnReason(FFPJbP300 p300) {
		PaymentReturnReason11 rtrRsnInf = this._objFactory.createPaymentReturnReason11();
		ReturnReason5Choice1 reason = this._objFactory.createReturnReason5Choice1();
		reason.setPrtry(p300.getReasonCode());
		rtrRsnInf.setRsn(reason);
		rtrRsnInf.getAddtlInf().add(p300.getAdditionalInformation());
		return rtrRsnInf;
	}
	
	private OriginalTransactionReference241 createOriginalTransactionReference(FFPJbP300 p300) {
		OriginalTransactionReference241 orgnlTxRef = this._objFactory.createOriginalTransactionReference241();
		
		orgnlTxRef.setIntrBkSttlmAmt(createCurrencyAndAmount(p300.getOrgnlInterbankSettCcy(),p300.getOrgnlInterbankSettAmt()));
		/*
		 * TODO DT is get from DB		
		 * FFPXMLUtils.toGregorianDt(new Date())
		 */
		orgnlTxRef.setIntrBkSttlmDt(null);
		
		orgnlTxRef.setPmtTpInf(createPaymentTypeInformation(p300));
		
		RemittanceInformation111 ri11 = new RemittanceInformation111();
		ri11.setUstrd(p300.getOrgnlRemtInfo());
		orgnlTxRef.setRmtInf(ri11);
		
		/**
		 * :Dbtr
		 */
		orgnlTxRef.setDbtr(createPartyIdentification(p300.getOrgnlDbtrNm(), p300.getOrgnlDbtrPhNo(), p300.getOrgnlDbtrEmAddr()));
		
		/**
		 * DbtrAcc
		 */
		orgnlTxRef.setDbtrAcct(createCashAccount(p300.getOrgnlDbtrAcctNo(), p300.getOrgnlDbtrAcctNoTp()));
		
		/**
		 * DbtrAgt
		 */
		orgnlTxRef.setDbtrAgt(createBranchAndFinancialInstitutionIdentification1(p300.getOrgnlDbtrAgtId(), p300.getOrgnlDbtrAgtBIC()));
		
		/**
		 * CreAgt
		 */
		orgnlTxRef.setCdtrAgt(createBranchAndFinancialInstitutionIdentification1(p300.getOrgnlCdtrAgtId(), p300.getOrgnlCdtrAgtBIC()));
		
		/**
		 * CrediAcc
		 */
		orgnlTxRef.setCdtr(createPartyIdentification(p300.getOrgnlCdtrNm(), p300.getOrgnlCdtrPhNo(), p300.getOrgnlCdtrEmAddr()));
		
		/**
		 * Creditor
		 */
		orgnlTxRef.setCdtrAcct(createCashAccount(p300.getOrgnlCdtrAcctNo(), p300.getOrgnlCdtrAcctNoTp()));
	
		return orgnlTxRef;
	}
	
	private PaymentTypeInformation251 createPaymentTypeInformation(FFPJbP300 p300) {
		PaymentTypeInformation251 pmtTpInf = this._objFactory.createPaymentTypeInformation251();
		
		CategoryPurpose1Choice1 ctgyPurp = this._objFactory.createCategoryPurpose1Choice1();
		ctgyPurp.setPrtry(FPSCategoryPurposeCode.fromValue(p300.getOrgnlCatgyPurp()));
		pmtTpInf.setCtgyPurp(ctgyPurp);
		
		return pmtTpInf;
	}
	
	private PartyIdentification431 createPartyIdentification(String acctName, String phoneNo, String emailAddr) {
		PartyIdentification431 pi431 = this._objFactory.createPartyIdentification431();
		pi431.setNm(acctName);
		ContactDetails21 details = this._objFactory.createContactDetails21();
		details.setMobNb(phoneNo);
		details.setEmailAdr(emailAddr);
		pi431.setCtctDtls(details);
		
		Party11Choice1 pc = new Party11Choice1();
		OrganisationIdentification81 id = new OrganisationIdentification81();
		GenericOrganisationIdentification11 other = new GenericOrganisationIdentification11();
		other.setId("123456");
		OrganisationIdentificationSchemeName1Choice1 choice =new  OrganisationIdentificationSchemeName1Choice1();
		choice.setCd(FPSCustomerCode.CUST);
		other.setSchmeNm(choice);
		id.setOthr(other);
		pi431.setId(pc);
		
		return pi431;
	}
	
	private CashAccount241 createCashAccount(String accNum, String accNumType)
	{
		CashAccount241 cashAcct = this._objFactory.createCashAccount241();

		AccountSchemeName1Choice1 schmeNm = this._objFactory.createAccountSchemeName1Choice1();
		schmeNm.setPrtry(FPSAccountTypeCode.fromValue(accNumType));

		GenericAccountIdentification11 othr = this._objFactory.createGenericAccountIdentification11();
		othr.setId(accNum);
		
		othr.setSchmeNm(schmeNm);

		AccountIdentification4Choice1 id = this._objFactory.createAccountIdentification4Choice1();
		id.setOthr(othr);

		cashAcct.setId(id);

		return cashAcct;
	}
	
	private BranchAndFinancialInstitutionIdentification51 createBranchAndFinancialInstitutionIdentification1(String mmbId, String mmbBic)
	{
		BranchAndFinancialInstitutionIdentification51 id = this._objFactory.createBranchAndFinancialInstitutionIdentification51();
		ClearingSystemMemberIdentification21 clrSysMmbId = this._objFactory.createClearingSystemMemberIdentification21();
		clrSysMmbId.setMmbId(mmbId);

		FinancialInstitutionIdentification81 finInstnId = this._objFactory.createFinancialInstitutionIdentification81();
		finInstnId.setBICFI(mmbBic);
		finInstnId.setClrSysMmbId(clrSysMmbId);

		id.setFinInstnId(finInstnId);

		return id;
	}

	@Override
	public String getSendType()
	{
		return FFPConstants.SEND_TYPE_REQ;
	}

	@Override
	public String getPriority()
	{
		return null;
	}
}
