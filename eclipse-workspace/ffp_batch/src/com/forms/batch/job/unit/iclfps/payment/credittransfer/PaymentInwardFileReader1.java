package com.forms.batch.job.unit.iclfps.payment.credittransfer;
import java.io.File;
import java.io.FilenameFilter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import com.forms.ffp.adaptor.define.FFPJaxbConstants;
import com.forms.ffp.adaptor.jaxb.iclfps.camt_054_001_06.AccountNotification121;
import com.forms.ffp.adaptor.jaxb.iclfps.camt_054_001_06.BankToCustomerDebitCreditNotificationV06;
import com.forms.ffp.adaptor.jaxb.iclfps.camt_054_001_06.ChargesRecord21;
import com.forms.ffp.adaptor.jaxb.iclfps.camt_054_001_06.Document;
import com.forms.ffp.adaptor.jaxb.iclfps.camt_054_001_06.EntryTransaction81;
import com.forms.ffp.adaptor.jaxb.iclfps.camt_054_001_06.TransactionAgents31;
import com.forms.ffp.adaptor.jaxb.iclfps.fps_envelope_01.BatchInformation;
import com.forms.ffp.adaptor.jaxb.iclfps.fps_envelope_01.FpsMessageEnvelope;
import com.forms.ffp.adaptor.jaxb.iclfps.fps_envelope_01.ISO20022BusinessDataV01;
import com.forms.ffp.adaptor.jaxb.iclfps.head_001_001_01.BusinessApplicationHeaderV01;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.OriginalTransactionReference241;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07.PaymentTransaction761;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_008_001_06.BranchAndFinancialInstitutionIdentification51;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_008_001_06.CashAccount241;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_008_001_06.CreditTransferTransaction251;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_008_001_06.GenericOrganisationIdentification11;
import com.forms.ffp.adaptor.jaxb.iclfps.pacs_008_001_06.GenericPersonIdentification11;
import com.forms.ffp.bussiness.iclfps.camt054.FFPVOCamt054;
import com.forms.ffp.bussiness.iclfps.pacs004.FFPVO_Pacs004;
import com.forms.ffp.bussiness.iclfps.pacs004.FFPVO_Pacs004_TxInf;
import com.forms.ffp.bussiness.iclfps.pacs008.FFPVO_Pacs008;
import com.forms.ffp.bussiness.iclfps.pacs008.FFPVO_Pacs008_CdtTrfTxInf;
import com.forms.ffp.core.define.FFPStatus;
import com.forms.ffp.core.msg.iclfps.FFPHkiclMessageConverter;
import com.forms.ffp.persistents.bean.FFPTxJnl;
import com.forms.ffp.persistents.bean.dt.FFPDtFpsPaymentNotification;
import com.forms.ffp.persistents.bean.payment.returnrefund.FFPJbP300;
import com.forms.framework.BatchBaseJob;
import com.forms.framework.exception.BatchJobException;
import com.forms.framework.persistence.EntityManager;
import com.forms.framework.util.PatternUtil;

public class PaymentInwardFileReader1 extends BatchBaseJob 
{
  private int BATCH_SIZE = 1000;
  private String filePath = null;
  private String fileNamePattern = null;


  
  public void init() throws BatchJobException 
  {
    try 
    {
    	filePath = this.batchData + this.actionElement.element("parameters").elementText("local-file-path");
		fileNamePattern = this.actionElement.element("parameters").elementText("filename-pattern");
      
		PatternUtil patternUtil = new PatternUtil(this.batchAcDate);
		Map<String, String> replaceMap = new HashMap<String, String>();
      
		replaceMap.put("clearingcode", this.clearingCode);
		fileNamePattern = patternUtil.patternReplace(replaceMap, fileNamePattern);
      
		batchLogger.info(this.fileNamePattern);
    }
    catch (Exception ip_e) 
    {
      throw new BatchJobException(ip_e);
    } 
  }


  
  public boolean execute() throws BatchJobException 
  {
    Date loc_startTime = Calendar.getInstance().getTime();
    batchLogger.info("read inward batch started at" + loc_startTime);
	batchLogger.info(String.format("Read inward batch date : %s", this.batchAcDate));
	batchLogger.info(String.format("Read inward batch file path : %s", filePath));
    
    try 
    {
      File workingPath = new File(this.filePath);
      
      File[] readfiles = workingPath.listFiles(new FilenameFilter()
          {
            
            public boolean accept(File dir, String name)
            {
              return name.matches(fileNamePattern);
            }
          });
      
      if (readfiles != null) 
      {
        String loc_processedSql = "SELECT FILE_NAME FROM TB_BH_PROCESSED_FILE ORDER BY FILE_NAME";
        List<Object[]> loc_tmpList = EntityManager.queryArrayList(loc_processedSql);
        String[] processedFileList = new String[loc_tmpList.size()];
        if (loc_tmpList != null)
        {
        	for(int i = 0; i < loc_tmpList.size(); i ++)
				processedFileList[i] = (String)(loc_tmpList.get(i)[0]);
        }
        List<File> loc_fileList = new ArrayList<File>(); byte b; int j; File[] arrayOfFile;
        for (j = arrayOfFile = readfiles.length, b = 0; b < j; ) { File loc_tmpFile = arrayOfFile[b];
          
          String loc_filename = loc_tmpFile.getName();
          if (Arrays.binarySearch(processedFileList, loc_filename) >= 0) {
            
            this.batchLogger.warn(String.valueOf(loc_filename) + " processed!!!");
          }
          else {
            
            loc_fileList.add(loc_tmpFile);
          } 
          b++; }
        
        if (loc_fileList.size() > 0) {

          
          String loc_deleteSql = "WHERE FILE_NAME IN(";
          for (int index = 0; index < loc_fileList.size(); index++) {
            
            loc_deleteSql = String.valueOf(loc_deleteSql) + "'" + ((File)loc_fileList.get(index)).getName() + "'";
            if (index < loc_fileList.size() - 1) {
              loc_deleteSql = String.valueOf(loc_deleteSql) + ",";
            } else {
              loc_deleteSql = String.valueOf(loc_deleteSql) + ")";
            } 
          }  EntityManager.update("DELETE FROM TB_BH_INWARD_FPSPYCI " + loc_deleteSql);
          EntityManager.update("DELETE FROM TB_BH_INWARD_RETURN_FPSPYCI " + loc_deleteSql);
          EntityManager.update("DELETE FROM TB_BH_INWARD_NOT_FPSPYCI " + loc_deleteSql);
          
          Map<String, List<ISO20022BusinessDataV01>> map = readFile(loc_fileList);
          processor(map);
          
          String loc_sql = "INSERT INTO TB_BH_PROCESSED_FILE(FILE_NAME, PROCESSED_TS) VALUES (?,?)";
          
          for (File tmp : loc_fileList) {
            
            EntityManager.update(loc_sql, new Object[] { tmp.getName(), loc_startTime });
            tmp.delete();
          } 
        } 
      } 
      
      Date loc_endTime = Calendar.getInstance().getTime();
      this.batchLogger.info("read inward batch end at" + loc_endTime);
      this.batchLogger.info("read inward batch file use " + ((loc_endTime.getTime() - loc_startTime.getTime()) / 1000L));
      return true;
    }
    catch (Exception ip_e) {
      
      throw new BatchJobException(ip_e);
    } 
  }

  
  private void processor(Map<String, List<ISO20022BusinessDataV01>> busiDataMap) throws Exception {
    this.batchLogger.info("Started processor inward batch file");

    
    Iterator<String> fileKeyInfoItr = busiDataMap.keySet().iterator();







    
    try {
      while (fileKeyInfoItr.hasNext()) {
        
        String fileKeyInfo = (String)fileKeyInfoItr.next();
        
        String fileName = fileKeyInfo.substring(0, fileKeyInfo.lastIndexOf("-"));
        String batchId = fileKeyInfo.substring(fileKeyInfo.lastIndexOf("-") + 1);
        List<ISO20022BusinessDataV01> busiData = (List)busiDataMap.get(fileKeyInfo);
        
        for (ISO20022BusinessDataV01 data : busiData) {
          
          BusinessApplicationHeaderV01 head = (BusinessApplicationHeaderV01)((JAXBElement)data.getContent().get(0)).getValue();
          String messageType = head.getMsgDefIdr();
          String busiSvrType = head.getBizSvc().value();
          
          if (FFPJaxbConstants.JAXB_MSG_TYPE_PACS_008.compareTo(messageType) == 0) {
            
            this.batchLogger.info(String.format("Process inward credit transfer transaction data of file[File Name:%s]", new Object[] { fileName }));
            Document doc008 = 
              (Document)((JAXBElement)data.getContent().get(1)).getValue();



            
            FFPVO_Pacs008 pacs008 = parse008(doc008);

            
            persistentFileData(pacs008, fileName, batchId, busiSvrType);
            continue;
          } 
          if (FFPJaxbConstants.JAXB_MSG_TYPE_PACS_004.compareTo(messageType) == 0) {
            
            this.batchLogger.info(String.format("Process inward return or refund transaction data of file[File Name:%s]", new Object[] { fileName }));
            Document doc004 = 
              (Document)((JAXBElement)data.getContent().get(1)).getValue();

            
            FFPVO_Pacs004 pacs004 = parse004(doc004);

            
            persistentRtnFileData(pacs004, fileName, batchId, busiSvrType);
            continue;
          } 
          if (FFPJaxbConstants.JAXB_MSG_TYPE_CAMT_054.compareTo(messageType) == 0) {
            
            this.batchLogger.info(String.format("Process inward payement notification data of file[File Name:%s]", new Object[] { fileName }));
            Document doc054 = 
              (Document)((JAXBElement)data.getContent().get(1)).getValue();

            
            FFPVOCamt054 camt054 = parse054(doc054);

            
            persitentNotFileData(camt054, fileName, batchId, busiSvrType);
          } 
        } 
      } 

      
      this.batchLogger.info("Ended processor inward batch file");
    }
    catch (Exception ex) {
      
      ex.printStackTrace();
      this.batchLogger.error("Process inward file error", ex);
      throw new BatchJobException(ex);
    } 
  }

  
  private void persitentNotFileData(FFPVOCamt054 camt054, String fileName, String batchId, String busiSvrType) throws Exception {
    String sql = "INSERT INTO TB_BH_INWARD_NOT_FPSPYCI(ID, BATCH_ID, STATUS, FILE_NAME, MSG_ID, MSG_CREATE_TS, NOT_ID, NOT_CREATE_TS, NOT_ACCT_ID, NOT_ACCT_TYPE, NOT_ENTRY_AMT, NOT_ENTRY_CUR, NOT_ENTRY_CDT_DBT_IND, NOT_ENTRY_STATUS, NOT_BANK_TX_CODE, NOT_ENTRY_DTL_END_TO_END_ID, NOT_ENTRY_DTL_TX_ID, NOT_ENTRY_DTL_MANT_ID, NOT_ENTRY_DTL_CLS_REF, NOT_ENTRY_DTL_AMT, NOT_ENTRY_DTL_CUR, NOT_ENTRY_DTL_CDT_DBT_IND, NOT_ENTRY_DTL_CHG_AMT, NOT_ENTRY_DTL_CHG_CUR, NOT_ENTRY_DTL_CHG_BEAR, NOT_ENTRY_DTL_CHG_AGT_BIC, NOT_ENTRY_DTL_CHG_AGT_ID, RLTD_PTIES_DBTR_NAME, RLTD_PTIES_DBTR_ORGID_BIC, RLTD_PTIES_DBTR_ORGID_OTH_ID, RLTD_PTIES_DBTR_ORGID_OTH_SCHME, RLTD_PTIES_DBTR_ORGID_OTH_ISS, RLTD_PTIES_DBTR_PRVTID_OTH_ID, RLTD_PTIES_DBTR_PRVTID_OTH_SCHME, RLTD_PTIES_DBTR_PRVTID_OTH_ISS, RLTD_PTIES_DBTR_CONT_MOBILE, RLTD_PTIES_DBTR_CONT_EMAIL, RLTD_PTIES_DBTR_ACCT_ID, RLTD_PTIES_DBTR_ACCT_SCHME, RLTD_PTIES_CDTR_NAME, RLTD_PTIES_CDTR_ORGID_BIC, RLTD_PTIES_CDTR_ORGID_OTH_ID, RLTD_PTIES_CDTR_ORGID_OTH_SCHME, RLTD_PTIES_CDTR_ORGID_OTH_ISS, RLTD_PTIES_CDTR_PRVTID_OTH_ID, RLTD_PTIES_CDTR_PRVTID_OTH_SCHME, RLTD_PTIES_CDTR_PRVTID_OTH_ISS, RLTD_PTIES_CDTR_CONT_MOBILE, RLTD_PTIES_CDTR_CONT_EMAIL, RLTD_PTIES_CDTR_ACCT_ID, RLTD_PTIES_CDTR_ACCT_SCHME, RLTD_DBTR_AGT_BIC, RLTD_DBTR_AGT_ID, RLTD_CDTR_AGT_BIC, RLTD_CDTR_AGT_ID, PURP_CODE, PURP_OTHER, REMI_INFO, RLTD_INTER_SETTLE_DATE, RLTD_TX_DATE_TIME, RETURN_INFO_CODE, RETURN_INFO_RSN, BIZ_SVC_TYPE, MSG_INST_DATE) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";














    
    try {
      String msgId = camt054.getMsgId();
      Date cratTs = camt054.getMsgCreateTs();
      
      List<FFPDtFpsPaymentNotification> camt054NotInf = camt054.getNotifList();
      if (camt054NotInf != null && camt054NotInf.size() > 0) {
        int count;
        
        Object[] res = EntityManager.queryArray("SELECT ID FROM TB_BH_INWARD_NOT_FPSPYCI ORDER BY ID DESC");
        if (res == null) { count = 0; }
        else { count = ((Integer)res[0]).intValue(); }
        
        int batFlag = 0;
        Object[][] batchObj = new Object[this.BATCH_SIZE][1];
        for (FFPDtFpsPaymentNotification not : camt054NotInf) {
          
          batFlag++;
          List<Object> paramList = new ArrayList<Object>();
          paramList.add(Integer.valueOf(++count));
          paramList.add(batchId);
          paramList.add(FFPStatus.TEMP_NOT_STATUS.INWARD_INITATE.getCode());
          paramList.add(fileName);
          paramList.add(msgId);
          paramList.add(cratTs);
          paramList.add(not.getNtfctnId());
          paramList.add(not.getNtfctnCreateTs());
          paramList.add(not.getNtfctnAcctId());
          paramList.add(not.getNtfctnAcctType());
          paramList.add(not.getNtryAmt());
          paramList.add(not.getNtryAmtCcy());
          paramList.add(not.getNtryCdtDbtInd());
          paramList.add(not.getNtryStatus());
          paramList.add(not.getNtryBankTransCode());
          paramList.add(not.getNtryDetailEndToEndId());
          paramList.add(not.getNtryDetailTxId());
          paramList.add(not.getNtryDetailMandateId());
          paramList.add(not.getNtryDetailClrSysRef());
          paramList.add(not.getNtryDetailAmt());
          paramList.add(not.getNtryDetailAmtCcy());
          paramList.add(not.getNtryDetailCdtDbtInd());
          paramList.add(not.getNtryDetailChrgsAmt());
          paramList.add(not.getNtryDetailChrgsAmtCcy());
          paramList.add(not.getNtryDetailChrgsBr());
          paramList.add(not.getNtryDetailChrgsAgtBic());
          paramList.add(not.getNtryDetailChrgsAgtMmbId());
          paramList.add(not.getRltdPtiesDbtrName());
          paramList.add(not.getRltdPtiesDbtrOrgIdBIC());
          paramList.add(not.getRltdPtiesDbtrOrgIdOthrId());
          paramList.add(not.getRltdPtiesDbtrOrgIdOthrSchme());
          paramList.add(not.getRltdPtiesDbtrOrgIdOthrIssr());
          paramList.add(not.getRltdPtiesDbtrPrvtIdOthrId());
          paramList.add(not.getRltdPtiesDbtrPrvtIdOthrSchme());
          paramList.add(not.getRltdPtiesDbtrPrvtIdOthrIssr());
          paramList.add(not.getRltdPtiesDbtrContactMobile());
          paramList.add(not.getRltdPtiesDbtrContactEmail());
          paramList.add(not.getRltdPtiesDbtrAcctId());
          paramList.add(not.getRltdPtiesDbtrAcctScheme());
          paramList.add(not.getRltdPtiesCdtrName());
          paramList.add(not.getRltdPtiesCdtrOrgIdBIC());
          paramList.add(not.getRltdPtiesCdtrOrgIdOthrId());
          paramList.add(not.getRltdPtiesCdtrOrgIdOthrSchme());
          paramList.add(not.getRltdPtiesCdtrOrgIdOthrIssr());
          paramList.add(not.getRltdPtiesCdtrPrvtIdOthrId());
          paramList.add(not.getRltdPtiesCdtrPrvtIdOthrSchme());
          paramList.add(not.getRltdPtiesCdtrPrvtIdOthrIssr());
          paramList.add(not.getRltdPtiesCdtrContactMobile());
          paramList.add(not.getRltdPtiesCdtrContactEmail());
          paramList.add(not.getRltdPtiesCdtrAcctId());
          paramList.add(not.getRltdPtiesCdtrAcctScheme());
          paramList.add(not.getRelatedAgentsDbtrBIC());
          paramList.add(not.getRelatedAgentsDbtrMmbId());
          paramList.add(not.getRelatedAgentsCdtrBIC());
          paramList.add(not.getRelatedAgentsCdtrMmbId());
          paramList.add(not.getPurpCode());
          paramList.add(not.getPurpOther());
          paramList.add(not.getRemitInfUstrd());
          paramList.add(not.getRelatedDatesIntrSettlDate());
          paramList.add(not.getRelatedDatesTransTs());
          paramList.add(not.getReturnInfRsn());
          paramList.add(not.getReturnInfMsg());
          paramList.add(busiSvrType);
          paramList.add(new Date());
          
          batchObj[batFlag - 1] = paramList.toArray();
          if (batFlag % this.BATCH_SIZE == 0) {
            
            EntityManager.batch(sql, batchObj);
            batchObj = new Object[this.BATCH_SIZE][1];
            batFlag = 0;
          } 
        } 
        
        if (batFlag > 0)
        {
          Object[][] remObj = new Object[batFlag][1];
          System.arraycopy(batchObj, 0, remObj, 0, batFlag);
          EntityManager.batch(sql, remObj);
        }
      
      } 
    } catch (Exception ex) {
      
      this.batchLogger.error(String.format("Temporarily persistent notification batch file[%s] data error", new Object[] { fileName }), ex);
      throw ex;
    } 
  }


  
  private void persistentRtnFileData(FFPVO_Pacs004 pacs004, String fileName, String batchId, String busiSvrType) throws Exception {
    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
    
    String sql = "INSERT INTO TB_BH_INWARD_RETURN_FPSPYCI(ID, RETURN_ID, BATCH_ID, STATUS, FILE_NAME, SETTLEMENT_METHOD, CLEARING_SYSTEM, RETURN_SETTLEMENT_CUR, RETURN_SETTLEMENT_AMT, RETURN_SETTLEMENT_DATE, RETURN_INSTRUCTED_CUR, RETURN_INSTRUCTED_AMT, RETURN_CHG_AGT_ID, RETURN_CHG_AGT_BIC, RETURN_CHG_CUR, RETURN_CHG_AMT, RETURN_CODE, RETURN_REASON, BIZ_SVC_TYPE, ORIG_INSTRUCTION_ID, ORIG_END_TO_END_ID, ORIG_TRANSACTION_ID, ORIG_FPS_REF, ORIG_SETTLEMENT_AMT, ORIG_SETTLEMENT_CUR, ORIG_SETTLEMENT_DATE, ORIG_CATEGORY_PURPOSE, ORIG_MANDATE_INFO, ORIG_REM_INFO, ORIG_DEBTOR_NAME, ORIG_DEBTOR_ACCTNO, ORIG_DEBTOR_ACCTNO_TYPE, ORIG_DEBTOR_AGT_ID, ORIG_DEBTOR_AGT_BIC, ORIG_CREDITOR_NAME, ORIG_CREDITOR_ACCTNO, ORIG_CREDITOR_ACCTNO_TYPE, ORIG_CREDITOR_AGT_ID, ORIG_CREDITOR_AGT_BIC, MSG_INST_DATE, LAST_MODI_DATE) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";







    
    try {
      String setMethod = pacs004.getSttlmMtd();
      String clrSys = pacs004.getClrSys();
      List<FFPVO_Pacs004_TxInf> pacs004TxInf = pacs004.getTxinf();
      if (pacs004TxInf != null && pacs004TxInf.size() > 0) {
        int count;
        
        Object[] res = EntityManager.queryArray("SELECT ID FROM TB_BH_INWARD_RETURN_FPSPYCI ORDER BY ID DESC");
        if (res == null) { count = 0; }
        else { count = ((Integer)res[0]).intValue(); }
        
        int batFlag = 0;
        Object[][] batchObj = new Object[this.BATCH_SIZE][1];
        for (FFPVO_Pacs004_TxInf txInf : pacs004TxInf) {
          
          batFlag++;
          List<Object> paramList = new ArrayList<Object>();
          FFPJbP300 p300 = txInf.getP300();
          FFPTxJnl txJnl = p300.getTxJnl();
          
          paramList.add(Integer.valueOf(++count));
          paramList.add(p300.getReturnId());
          paramList.add(batchId);
          paramList.add(FFPStatus.TEMP_RETURN_REFUND_STATUS.INWARD_INITATE.getCode());
          paramList.add(fileName);
          paramList.add(setMethod);
          paramList.add(clrSys);
          paramList.add(p300.getRetIntSetCur());
          paramList.add(p300.getRetIntSetAmt());
          paramList.add(sdf.parse(p300.getSettlementDate().toString()));
          paramList.add(p300.getRetInsCur());
          paramList.add(p300.getRetInsAmt());
          paramList.add(p300.getChgAgtID());
          paramList.add(p300.getChgAgtBIC());
          paramList.add(p300.getChargersCurrency());
          paramList.add(p300.getChargersAmount());
          paramList.add(p300.getReasonCode());
          
          StringBuilder reason = new StringBuilder();
          reason.append(p300.getAdditionalInformation());








          
          paramList.add((reason.toString().trim().length() > 0) ? reason.toString().trim() : null);
          
          paramList.add(busiSvrType);
          paramList.add("");
          paramList.add(txJnl.getEndToEndId());
          paramList.add(txJnl.getTransactionId());
          paramList.add(txJnl.getFpsRefNm());
          paramList.add(p300.getOrgnlInterbankSettAmt());
          paramList.add(p300.getOrgnlInterbankSettCcy());
          paramList.add(p300.getOrgnlInterbankSettDate());
          paramList.add(p300.getOrgnlCatgyPurp());
          paramList.add(p300.getOrgnlMandateInfo());
          paramList.add(p300.getOrgnlRemtInfo());
          paramList.add(p300.getOrgnlDbtrNm());
          paramList.add(p300.getOrgnlDbtrAcctNo());
          paramList.add(p300.getOrgnlDbtrAcctNoTp());
          paramList.add(p300.getOrgnlDbtrAgtId());
          paramList.add(p300.getOrgnlDbtrAgtBIC());
          paramList.add(p300.getOrgnlCdtrNm());
          paramList.add(p300.getOrgnlCdtrAcctNo());
          paramList.add(p300.getOrgnlCdtrAcctNoTp());
          paramList.add(p300.getOrgnlCdtrAgtId());
          paramList.add(p300.getOrgnlCdtrAgtBIC());
          paramList.add(new Date((new Date()).getTime()));
          paramList.add(new Timestamp((new Date()).getTime()));
          
          batchObj[batFlag - 1] = paramList.toArray();
          if (batFlag % this.BATCH_SIZE == 0) {
            
            EntityManager.batch(sql, batchObj);
            batchObj = new Object[this.BATCH_SIZE][1];
            batFlag = 0;
          } 
        } 

        
        if (batFlag > 0)
        {
          Object[][] remObj = new Object[batFlag][1];
          System.arraycopy(batchObj, 0, remObj, 0, batFlag);
          EntityManager.batch(sql, remObj);
        }
      
      } 
    } catch (Exception ex) {
      
      this.batchLogger.error(String.format("Temporarily persistent return or refund batch file[%s] data error", new Object[] { fileName }), ex);
      throw ex;
    } 
  }


  
  public void persistentFileData(FFPVO_Pacs008 pacs008, String fileName, String batchId, String busiSvrType) throws Exception {
    String sql = "INSERT INTO TB_BH_INWARD_FPSPYCI(ID, BATCH_ID, STATUS, FILE_NAME, TRANSACTION_ID, END_TO_END_ID, FPS_REF, INSTRUCTION_ID, CATEGORY_PURPOSE, ACCT_VERF, SETTLEMENT_CUR, SETTLEMENT_AMT, SETTLEMENT_DATE, INSTRUCTED_CUR, INSTRUCTED_AMT, CHG_AGT_ID, CHG_AGT_BIC, CHG_CUR, CHG_AMT, DEBTOR_NAME, DEBTOR_ORGID_ANYBIC, DEBTOR_ORGID_OTHRID, DEBTOR_ORGID_OTHRID_SCHMENM, DEBTOR_ORGID_OTHR_ISSR, DEBTOR_PRVTID_OTHRID, DEBTOR_PRVTID_OTHRID_SCHMENM, DEBTOR_PRVTID_OTHR_ISSR, DEBTOR_CONT_PHONE, DEBTOR_CONT_EMADDR, DEBTOR_ACCTNO, DEBTOR_ACCTNO_TYPE, DEBTOR_AGT_ID, DEBTOR_AGT_BIC, CREDITOR_NAME, CREDITOR_ORGID_ANYBIC, CREDITOR_ORGID_OTHRID, CREDITOR_ORGID_OTHRID_SCHMENM, CREDITOR_ORGID_OTHR_ISSR, CREDITOR_PRVTID_OTHRID, CREDITOR_PRVTID_OTHRID_SCHMENM, CREDITOR_PRVTID_OTHR_ISSR, CREDITOR_CONT_PHONE, CREDITOR_CONT_EMADDR, CREDITOR_ACCTNO, CREDITOR_ACCTNO_TYPE, CREDITOR_AGT_ID, CREDITOR_AGT_BIC, PURPOSE_TYPE, PURPOSE_CODE, PURPOSE_OTHER, REMIT_INFO, MSG_INST_DATE, LAST_MODI_DATE, BIZ_SVC_TYPE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";







    
    try {
      List<FFPVO_Pacs008_CdtTrfTxInf> txInfList = pacs008.getCdtTrfTxInfList();
      if (txInfList != null && txInfList.size() > 0) {
        int count;
        
        Object[] res = EntityManager.queryArray("SELECT ID FROM TB_BH_INWARD_FPSPYCI ORDER BY ID DESC");
        if (res == null) { count = 0; }
        else { count = ((Integer)res[0]).intValue(); }
        
        int batFlag = 0;
        Object[][] batchObj = new Object[this.BATCH_SIZE][1];
        for (FFPVO_Pacs008_CdtTrfTxInf txInf : txInfList) {
          
          batFlag++;
          List<Object> paramList = new ArrayList<Object>();
          paramList.add(Integer.valueOf(++count));
          paramList.add(batchId);
          paramList.add(FFPStatus.TEMP_CREDIT_STATUS.INWARD_INITATE.getCode());
          paramList.add(fileName);
          paramList.add(txInf.getTxId());
          paramList.add(txInf.getEndToEndId());
          paramList.add(txInf.getClrSysRef());
          paramList.add(txInf.getInstrId());
          paramList.add(txInf.getCtgyPurp());
          paramList.add(txInf.getLclInstrm());
          paramList.add(txInf.getIntrBkSttlmAmtCcy());
          paramList.add((txInf.getIntrBkSttlmAmt() != null) ? String.format("%.2f", new Object[] { Double.valueOf(txInf.getIntrBkSttlmAmt()) }).toString() : txInf.getIntrBkSttlmAmt());
          paramList.add(txInf.getIntrBkSttlmDt());
          paramList.add(txInf.getInstdAmtCcy());
          paramList.add((txInf.getInstdAmt() != null) ? String.format("%.2f", new Object[] { Double.valueOf(txInf.getInstdAmt()) }).toString() : txInf.getInstdAmt());




          
          paramList.add(txInf.getChrgAgentId());
          paramList.add(txInf.getChrgAgentBic());
          paramList.add(txInf.getChrgCcy());
          paramList.add(txInf.getChrgAmount());







          
          paramList.add(txInf.getDbtrNm());
          paramList.add(txInf.getDbtrOrgIdAnyBIC());
          paramList.add(txInf.getDbtrOrgIdOthrId());
          paramList.add(txInf.getDbtrOrgIdOthrIdSchmeNm());
          paramList.add(txInf.getDbtrOrgIdOthrIssr());
          paramList.add(txInf.getDbtrPrvtIdOthrId());
          paramList.add(txInf.getDbtrPrvtIdOthrIdSchmeNm());
          paramList.add(txInf.getDbtrPrvtIdOthrIssr());
          paramList.add(txInf.getDbtrMobNb());
          paramList.add(txInf.getDbtrEmailAdr());
          paramList.add(txInf.getDbtrAcctId());
          paramList.add(txInf.getDbtrAccSchmeNm());
          paramList.add(txInf.getDbtrAgClrSysMmbId());
          paramList.add(txInf.getDbtrAgBICFI());
          paramList.add(txInf.getCdtrNm());
          paramList.add(txInf.getCdtrOrgIdAnyBIC());
          paramList.add(txInf.getCdtrOrgIdOthrId());
          paramList.add(txInf.getCdtrOrgIdOthrIdSchmeNm());
          paramList.add(txInf.getCdtrOrgIdOthrIssr());
          paramList.add(txInf.getCdtrPrvtIdOthrId());
          paramList.add(txInf.getCdtrPrvtIdOthrIdSchmeNm());
          paramList.add(txInf.getCdtrPrvtIdOthrIssr());
          paramList.add(txInf.getCdtrMobNb());
          paramList.add(txInf.getCdtrEmailAdr());
          paramList.add(txInf.getCdtrAcctId());
          paramList.add(txInf.getCdtrAcctSchmeNm());
          paramList.add(txInf.getCdtrAgtClrSysMmbId());
          paramList.add(txInf.getCdtrAgtBICFI());
          paramList.add(null);
          paramList.add(txInf.getPurpCd());
          paramList.add(txInf.getPurpPrtry());










          
          paramList.add(txInf.getRmtInf());
          
          paramList.add(new Date((new Date()).getTime()));
          paramList.add(new Timestamp((new Date()).getTime()));
          paramList.add(busiSvrType);
          
          batchObj[batFlag - 1] = paramList.toArray();
          if (batFlag % this.BATCH_SIZE == 0) {
            
            EntityManager.batch(sql, batchObj);
            batchObj = new Object[this.BATCH_SIZE][1];
            batFlag = 0;
          } 
        } 

        
        if (batFlag > 0)
        {
          Object[][] remObj = new Object[batFlag][1];
          System.arraycopy(batchObj, 0, remObj, 0, batFlag);
          EntityManager.batch(sql, remObj);
        }
      
      } 
    } catch (Exception ex) {
      
      this.batchLogger.error(String.format("Temporarily persistent batch file[%s] data error", new Object[] { fileName }), ex);
      throw ex;
    } 
  }

  
  private FFPVO_Pacs008 parse008(Document pacs008) throws Exception {
    FFPVO_Pacs008 pacs008MsgVo = new FFPVO_Pacs008();
    pacs008MsgVo.setMsgId(pacs008.getFIToFICstmrCdtTrf().getGrpHdr().getMsgId());
    pacs008MsgVo.setCreDtTm(pacs008.getFIToFICstmrCdtTrf().getGrpHdr().getCreDtTm().toGregorianCalendar().getTime());
    String numberOfTx = pacs008.getFIToFICstmrCdtTrf().getGrpHdr().getNbOfTxs();
    pacs008MsgVo.setNbOfTxs(numberOfTx);
    pacs008MsgVo.setSttlmMtd(pacs008.getFIToFICstmrCdtTrf().getGrpHdr().getSttlmInf().getSttlmMtd().value());
    pacs008MsgVo.setClrSys(pacs008.getFIToFICstmrCdtTrf().getGrpHdr().getSttlmInf().getClrSys().getPrtry().value());
    List<CreditTransferTransaction251> list = pacs008.getFIToFICstmrCdtTrf().getCdtTrfTxInf();
    List<FFPVO_Pacs008_CdtTrfTxInf> pacs008TxInf = new ArrayList<FFPVO_Pacs008_CdtTrfTxInf>();
    pacs008MsgVo.setCdtTrfTxInfList(pacs008TxInf);










    
    for (CreditTransferTransaction251 ct251 : list) {
      
      FFPVO_Pacs008_CdtTrfTxInf cdtTxInfo = new FFPVO_Pacs008_CdtTrfTxInf();
      pacs008TxInf.add(cdtTxInfo);
      cdtTxInfo.setInstrId(ct251.getPmtId().getInstrId());
      cdtTxInfo.setEndToEndId(ct251.getPmtId().getEndToEndId());
      cdtTxInfo.setTxId(ct251.getPmtId().getTxId());
      cdtTxInfo.setClrSysRef(ct251.getPmtId().getClrSysRef());
      
      if (ct251.getPmtTpInf() != null && ct251.getPmtTpInf().getLclInstrm() != null) {
        
        cdtTxInfo.setLclInstrm(ct251.getPmtTpInf().getLclInstrm().getPrtry().value());
        if (ct251.getPmtTpInf().getCtgyPurp() != null)
        {
          cdtTxInfo.setCtgyPurp(ct251.getPmtTpInf().getCtgyPurp().getPrtry().value());
        }
      } 
      
      cdtTxInfo.setIntrBkSttlmAmt(String.valueOf(ct251.getIntrBkSttlmAmt().getValue()));
      cdtTxInfo.setIntrBkSttlmAmtCcy(ct251.getIntrBkSttlmAmt().getCcy().value());
      
      if (ct251.getIntrBkSttlmDt() != null)
      {
        cdtTxInfo.setIntrBkSttlmDt(ct251.getIntrBkSttlmDt().toGregorianCalendar().getTime());
      }
      if (ct251.getSttlmTmIndctn() != null) ct251.getSttlmTmIndctn().getCdtDtTm();


      
      if (ct251.getInstdAmt() != null) {
        
        cdtTxInfo.setInstdAmt(String.valueOf(ct251.getInstdAmt().getValue()));
        cdtTxInfo.setInstdAmtCcy(ct251.getInstdAmt().getCcy().value());
      } 

      
      cdtTxInfo.setChrgBr(ct251.getChrgBr().value());
      
      if (ct251.getChrgsInf() != null) {


        
        if (ct251.getChrgsInf().getAmt() != null) {
          
          cdtTxInfo.setChrgAmount(ct251.getChrgsInf().getAmt().getValue());
          cdtTxInfo.setChrgCcy(ct251.getChrgsInf().getAmt().getCcy().value());
        } 
        cdtTxInfo.setChrgAgentBic(ct251.getChrgsInf().getAgt().getFinInstnId().getBICFI());
        cdtTxInfo.setChrgAgentId((ct251.getChrgsInf().getAgt().getFinInstnId() != null) ? ct251.getChrgsInf().getAgt().getFinInstnId().getClrSysMmbId().getMmbId() : null);
      } 



      
      cdtTxInfo.setDbtrNm(ct251.getDbtr().getNm());
      if (ct251.getDbtr().getId() != null) {
        
        if (ct251.getDbtr().getId().getOrgId() != null) {
          
          cdtTxInfo.setDbtrOrgIdAnyBIC(ct251.getDbtr().getId().getOrgId().getAnyBIC());
          GenericOrganisationIdentification11 other = ct251.getDbtr().getId().getOrgId().getOthr();
          if (other != null) {







            
            cdtTxInfo.setDbtrOrgIdOthrId(other.getId());
            cdtTxInfo.setDbtrOrgIdOthrIdSchmeNm((other.getSchmeNm() != null) ? other.getSchmeNm().getCd().value() : null);
            cdtTxInfo.setDbtrOrgIdOthrIssr((other.getIssr() != null) ? other.getIssr() : null);
          } 
        } 
        
        if (ct251.getDbtr().getId().getPrvtId() != null) {
          
          GenericPersonIdentification11 prvtOther = ct251.getDbtr().getId().getPrvtId().getOthr();
          if (prvtOther != null) {







            
            cdtTxInfo.setDbtrPrvtIdOthrId(prvtOther.getId());
            cdtTxInfo.setDbtrPrvtIdOthrIdSchmeNm((prvtOther.getSchmeNm() != null) ? prvtOther.getSchmeNm().getCd().value() : null);
            cdtTxInfo.setDbtrPrvtIdOthrIssr(prvtOther.getIssr());
          } 
        } 
      } 
      
      cdtTxInfo.setDbtrMobNb((ct251.getDbtr().getCtctDtls() != null) ? ct251.getDbtr().getCtctDtls().getMobNb() : null);
      cdtTxInfo.setDbtrEmailAdr((ct251.getDbtr().getCtctDtls() != null) ? ct251.getDbtr().getCtctDtls().getEmailAdr() : null);

      
      CashAccount241 dbtAcc = ct251.getDbtrAcct();
      BranchAndFinancialInstitutionIdentification51 dbtAgt = ct251.getDbtrAgt();
      if (dbtAcc != null) {
        
        cdtTxInfo.setDbtrAcctId(dbtAcc.getId().getOthr().getId());
        cdtTxInfo.setDbtrAccSchmeNm((dbtAcc.getId().getOthr().getSchmeNm() != null) ? dbtAcc.getId().getOthr().getSchmeNm().getPrtry().value() : null);
      } 
      
      if (dbtAgt != null) {
        
        cdtTxInfo.setDbtrAgBICFI(dbtAgt.getFinInstnId().getBICFI());
        cdtTxInfo.setDbtrAgClrSysMmbId((dbtAgt.getFinInstnId().getClrSysMmbId() != null) ? dbtAgt.getFinInstnId().getClrSysMmbId().getMmbId() : null);
      } 

      
      BranchAndFinancialInstitutionIdentification51 cdtrAgt = ct251.getCdtrAgt();
      if (cdtrAgt != null) {
        
        cdtTxInfo.setCdtrAgtBICFI(cdtrAgt.getFinInstnId().getBICFI());
        cdtTxInfo.setCdtrAgtClrSysMmbId((cdtrAgt.getFinInstnId().getClrSysMmbId() != null) ? cdtrAgt.getFinInstnId().getClrSysMmbId().getMmbId() : null);
      } 
      
      cdtTxInfo.setCdtrNm(ct251.getCdtr().getNm());
      if (ct251.getCdtr().getId() != null) {
        
        if (ct251.getCdtr().getId().getOrgId() != null) {
          
          cdtTxInfo.setCdtrOrgIdAnyBIC(ct251.getCdtr().getId().getOrgId().getAnyBIC());
          GenericOrganisationIdentification11 other = ct251.getCdtr().getId().getOrgId().getOthr();
          if (other != null) {







            
            cdtTxInfo.setCdtrOrgIdOthrId(other.getId());
            cdtTxInfo.setCdtrOrgIdOthrIdSchmeNm((other.getSchmeNm() != null) ? other.getSchmeNm().getCd().value() : null);
            cdtTxInfo.setCdtrOrgIdOthrIssr(other.getIssr());
          } 
        } 
        
        if (ct251.getCdtr().getId().getPrvtId() != null) {
          
          GenericPersonIdentification11 prvtOther = ct251.getCdtr().getId().getPrvtId().getOthr();
          if (prvtOther != null) {







            
            cdtTxInfo.setCdtrPrvtIdOthrId(prvtOther.getId());
            cdtTxInfo.setCdtrPrvtIdOthrIdSchmeNm((prvtOther.getSchmeNm() != null) ? prvtOther.getSchmeNm().getCd().value() : null);
            cdtTxInfo.setCdtrPrvtIdOthrIssr(prvtOther.getIssr());
          } 
        } 
      } 
      
      cdtTxInfo.setCdtrMobNb((ct251.getCdtr().getCtctDtls() != null) ? ct251.getCdtr().getCtctDtls().getMobNb() : null);
      cdtTxInfo.setCdtrEmailAdr((ct251.getCdtr().getCtctDtls() != null) ? ct251.getCdtr().getCtctDtls().getEmailAdr() : null);

      
      CashAccount241 cbtrAcc = ct251.getCdtrAcct();
      if (cbtrAcc != null) {
        
        cdtTxInfo.setCdtrAcctId(cbtrAcc.getId().getOthr().getId());
        cdtTxInfo.setCdtrAcctSchmeNm((cbtrAcc.getId().getOthr().getSchmeNm() != null) ? cbtrAcc.getId().getOthr().getSchmeNm().getPrtry().value() : null);
      } 

      
      if (ct251.getPurp() != null) {
        
        cdtTxInfo.setPurpCd(ct251.getPurp().getCd());
        cdtTxInfo.setPurpPrtry(ct251.getPurp().getPrtry());
      } 

      
      if (ct251.getRmtInf() != null && ct251.getRmtInf().getUstrd() != null)
      {
        
        cdtTxInfo.setRmtInf(ct251.getRmtInf().getUstrd());
      }
    } 
    
    return pacs008MsgVo;
  }



  
  private Map<String, List<ISO20022BusinessDataV01>> readFile(List<File> fileList) throws Exception {
    this.batchLogger.info("Started read inward batch file");
    Map<String, List<ISO20022BusinessDataV01>> validBusData = new HashMap<String, List<ISO20022BusinessDataV01>>();
    if (fileList != null) {

      
      Map<String, FpsMessageEnvelope> validFiles = validateInwardFiles(fileList);
      
      Iterator<String> fileNameIt = validFiles.keySet().iterator();
      while (fileNameIt.hasNext()) {
        
        String fileName = (String)fileNameIt.next();
        FpsMessageEnvelope xmlFileData = (FpsMessageEnvelope)validFiles.get(fileName);
        String batchId = xmlFileData.getBtchInf().getBtchId();
        String fileName_batchId = String.format("%s-%s", new Object[] { fileName, batchId });
        
        String msgCount = xmlFileData.getNbOfMsgs();
        
        if (Integer.valueOf(msgCount).intValue() < 1) {
          
          this.batchLogger.info(String.format("The file[%s] hasn't contain transaction datas", new Object[] { fileName }));
          
          continue;
        } 
        List<ISO20022BusinessDataV01> bisDataList = xmlFileData.getFpsPylds().getBizData();
        if (msgCount.compareTo(String.valueOf(bisDataList.size())) != 0) {
          
          this.batchLogger.info(String.format("The file contains invalid message counts:FileName[%s]-NoOfMsgs[%s]-ActualMsgsCount[%s]", new Object[] {
                  fileName, msgCount, String.valueOf(bisDataList.size())
                }));
          continue;
        } 
        validBusData.put(fileName_batchId, bisDataList);
      } 

      
      this.batchLogger.info("Ended read inward batch file");
    } 
    return validBusData;
  }


  
  public Map<String, FpsMessageEnvelope> validateInwardFiles(List<File> fileList) throws Exception {
    if (fileList.size() == 0) return new HashMap(); 
    Map<String, FpsMessageEnvelope> validFileData = new HashMap<String, FpsMessageEnvelope>();
    Map<String, FpsMessageEnvelope> mapFile = new HashMap<String, FpsMessageEnvelope>();
    List<String> keyCount = new ArrayList<String>();
    
    for (File xmlFile : fileList) {

      
      try {
        FpsMessageEnvelope result = FFPHkiclMessageConverter.parseObject(xmlFile);
        
        BatchInformation batchInfo = result.getBtchInf();
        String batchID = batchInfo.getBtchId();
        String numberOfFile = batchInfo.getNbOfFls();
        
        String keyFileIdStr = String.format("BatchId[%s]-NumberOfFile[%s]-fileName[%s]", new Object[] { batchID, numberOfFile, xmlFile.getName() });
        String keyCountStr = String.format("BatchId[%s]-NumberOfFile[%s]", new Object[] { batchID, numberOfFile });
        this.batchLogger.info(String.format("File info:%s", new Object[] { keyFileIdStr }));
        if (Integer.valueOf(numberOfFile).intValue() > 1) {
          
          mapFile.put(keyFileIdStr, result);
          keyCount.add(keyCountStr);
          
          continue;
        } 
        
        validFileData.put(xmlFile.getName(), result);
      
      }
      catch (Exception ex) {
        
        this.batchLogger.error(String.format("Error on parsing file[fileName:%s]", new Object[] { xmlFile.getName() }), ex);
        throw ex;
      } 
    } 

    
    Comparator<String> comp = new Comparator<String>() {
        public int compare(String arg0, String arg1)
        {
          return arg0.compareTo(arg1);
        }
      };

    
    Collections.sort(keyCount, comp);

    
    Map<String, Integer> countMap = new HashMap<String, Integer>();
    for (String str : keyCount) {
      
      if (countMap.containsKey(str)) { countMap.put(str, Integer.valueOf(((Integer)countMap.get(str)).intValue() + 1)); continue; }
       countMap.put(str, Integer.valueOf(1));
    } 

    
    List<String> validKey = new ArrayList<String>();
    Iterator<String> iteStr = countMap.keySet().iterator();
    while (iteStr.hasNext()) {
      
      String countKey = (String)iteStr.next();
      Integer countValue = (Integer)countMap.get(countKey);
      
      if (countKey.substring(countKey.lastIndexOf("[") + 1, countKey.lastIndexOf("]")).compareTo(String.valueOf(countValue)) != 0) {

        
        this.batchLogger.info(String.format("The files contain %s not matched with actual number of files!", new Object[] { countKey }));
        
        continue;
      } 
      validKey.add(countKey);
    } 


    
    Iterator<String> iter = mapFile.keySet().iterator();
    while (iter.hasNext()) {
      
      String key = (String)iter.next();
      if (validKey.contains(key.substring(0, key.lastIndexOf("-"))))
      {
        validFileData.put(key.substring(key.lastIndexOf("[") + 1, key.lastIndexOf("]")), (FpsMessageEnvelope)mapFile.get(key));
      }
    } 















    
    return validFileData;
  }

  
  private FFPVO_Pacs004 parse004(Document pacs004) {
    FFPVO_Pacs004 pacs004MsgVo = new FFPVO_Pacs004();
    pacs004MsgVo.setMsgId(pacs004.getPmtRtr().getGrpHdr().getMsgId());
    pacs004MsgVo.setCreDtTm(pacs004.getPmtRtr().getGrpHdr().getCreDtTm().toString());
    String numberOfTx = pacs004.getPmtRtr().getGrpHdr().getNbOfTxs();
    pacs004MsgVo.setNbOfTxs(numberOfTx);
    pacs004MsgVo.setSttlmMtd(pacs004.getPmtRtr().getGrpHdr().getSttlmInf().getSttlmMtd().value());
    pacs004MsgVo.setClrSys(pacs004.getPmtRtr().getGrpHdr().getSttlmInf().getClrSys().getPrtry().value());
    
    List<FFPVO_Pacs004_TxInf> pacs004TxInf = new ArrayList<FFPVO_Pacs004_TxInf>();
    pacs004MsgVo.setTxinf(pacs004TxInf);
    List<PaymentTransaction761> list = pacs004.getPmtRtr().getTxInf();
    
    for (PaymentTransaction761 tx761 : list) {
      
      FFPVO_Pacs004_TxInf returnInfo = new FFPVO_Pacs004_TxInf();
      FFPJbP300 p300 = new FFPJbP300();
      FFPTxJnl txJnl = new FFPTxJnl();
      
      p300.setReturnId(tx761.getRtrId());
      
      txJnl.setEndToEndId(tx761.getOrgnlEndToEndId());
      txJnl.setTransactionId(tx761.getOrgnlTxId());
      txJnl.setFpsRefNm(tx761.getOrgnlClrSysRef());
      p300.setTxJnl(txJnl);
      
      p300.setRetIntSetAmt(new BigDecimal(String.valueOf(tx761.getRtrdIntrBkSttlmAmt().getValue())));
      p300.setRetIntSetCur(tx761.getRtrdIntrBkSttlmAmt().getCcy().value());
      p300.setSettlementDate((tx761.getIntrBkSttlmDt() != null) ? tx761.getIntrBkSttlmDt().toGregorianCalendar().getTime() : null);








      
      if (tx761.getRtrdInstdAmt() != null) {
        
        p300.setRetInsAmt(new BigDecimal(String.valueOf(tx761.getRtrdInstdAmt().getValue())));
        p300.setRetInsCur(tx761.getRtrdInstdAmt().getCcy().value());
      } 





      
      if (tx761.getChrgsInf() != null) {
        
        if (tx761.getChrgsInf().getAmt() != null) {
          
          p300.setChargersAmount(new BigDecimal(String.valueOf(tx761.getChrgsInf().getAmt().getValue())));
          p300.setChargersCurrency(tx761.getChrgsInf().getAmt().getCcy().value());
        } 

        
        p300.setChgAgtBIC(tx761.getChrgsInf().getAgt().getFinInstnId().getBICFI());
        p300.setChgAgtID((tx761.getChrgsInf().getAgt().getFinInstnId() != null) ? tx761.getChrgsInf().getAgt().getFinInstnId().getClrSysMmbId().getMmbId() : null);
      } 


      
      if (tx761.getRtrRsnInf() != null) {
        
        p300.setReasonCode((tx761.getRtrRsnInf().getRsn() != null) ? tx761.getRtrRsnInf().getRsn().getPrtry() : null);
        
        StringBuffer reason = new StringBuffer();
        List<String> reasonList = tx761.getRtrRsnInf().getAddtlInf();
        if (reasonList != null)
        {
          for (int i = 1; i <= reasonList.size(); i++) {
            
            reason.append((String)reasonList.get(i - 1));
            if (i < reasonList.size()) reason.append(","); 
          } 
        }
        p300.setAdditionalInformation((reason.toString().trim().length() > 0) ? reason.toString().trim() : null);
      } 


      
      OriginalTransactionReference241 orglTxRef = tx761.getOrgnlTxRef();
      if (orglTxRef != null) {
        
        p300.setOrgnlInterbankSettAmt(new BigDecimal(String.valueOf(orglTxRef.getIntrBkSttlmAmt().getValue())));
        p300.setOrgnlInterbankSettCcy(orglTxRef.getIntrBkSttlmAmt().getCcy().value());
        p300.setOrgnlInterbankSettDate((orglTxRef.getIntrBkSttlmDt() != null) ? orglTxRef.getIntrBkSttlmDt().toGregorianCalendar().getTime() : null);
        p300.setOrgnlCatgyPurp(orglTxRef.getPmtTpInf().getCtgyPurp().getPrtry().value());
        p300.setOrgnlMandateInfo((orglTxRef.getMndtRltdInf() != null) ? orglTxRef.getMndtRltdInf().getMndtId() : null);
        p300.setOrgnlRemtInfo((orglTxRef.getRmtInf() != null) ? orglTxRef.getRmtInf().getUstrd() : null);
        
        p300.setOrgnlDbtrNm(orglTxRef.getDbtr().getNm());
        p300.setOrgnlDbtrAcctNo(orglTxRef.getDbtrAcct().getId().getOthr().getId());
        p300.setOrgnlDbtrAcctNoTp(orglTxRef.getDbtrAcct().getId().getOthr().getSchmeNm().getPrtry().value());
        p300.setOrgnlDbtrAgtBIC(orglTxRef.getDbtrAgt().getFinInstnId().getBICFI());
        p300.setOrgnlDbtrAgtId(orglTxRef.getDbtrAgt().getFinInstnId().getClrSysMmbId().getMmbId());
        
        p300.setOrgnlCdtrNm(orglTxRef.getCdtr().getNm());
        p300.setOrgnlCdtrAcctNo(orglTxRef.getCdtrAcct().getId().getOthr().getId());
        p300.setOrgnlCdtrAcctNoTp(orglTxRef.getCdtrAcct().getId().getOthr().getSchmeNm().getPrtry().value());
        p300.setOrgnlCdtrAgtBIC(orglTxRef.getCdtrAgt().getFinInstnId().getBICFI());
        p300.setOrgnlCdtrAgtId(orglTxRef.getCdtrAgt().getFinInstnId().getClrSysMmbId().getMmbId());
      } 
















      
      returnInfo.setP300(p300);
      pacs004TxInf.add(returnInfo);
    } 
    
    return pacs004MsgVo;
  }

  
  private FFPVOCamt054 parse054(Document doc054) {
    FFPVOCamt054 camt054MsgVo = new FFPVOCamt054();
    
    BankToCustomerDebitCreditNotificationV06 noti = doc054.getBkToCstmrDbtCdtNtfctn();
    
    camt054MsgVo.setMsgId(noti.getGrpHdr().getMsgId());
    camt054MsgVo.setMsgCreateTs(noti.getGrpHdr().getCreDtTm().toGregorianCalendar().getTime());
    
    if (noti.getNtfctn() != null)
    {
      for (AccountNotification121 acctNoti : noti.getNtfctn()) {
        
        FFPDtFpsPaymentNotification ntfctn = new FFPDtFpsPaymentNotification();
        ntfctn.setMsgId(noti.getGrpHdr().getMsgId());
        ntfctn.setMsgCreateTs(noti.getGrpHdr().getCreDtTm().toGregorianCalendar().getTime());
        
        ntfctn.setNtfctnId(acctNoti.getId());
        ntfctn.setNtfctnCreateTs(acctNoti.getCreDtTm().toGregorianCalendar().getTime());
        ntfctn.setNtfctnAcctId(acctNoti.getAcct().getId().getOthr().getId());
        ntfctn.setNtfctnAcctType(acctNoti.getAcct().getTp().getCd().value());
        
        ntfctn.setNtryAmt(acctNoti.getNtry().getAmt().getValue());
        ntfctn.setNtryAmtCcy(acctNoti.getNtry().getAmt().getCcy().value());
        ntfctn.setNtryCdtDbtInd(acctNoti.getNtry().getCdtDbtInd().value());
        ntfctn.setNtryStatus(acctNoti.getNtry().getSts().value());
        ntfctn.setNtryBankTransCode(acctNoti.getNtry().getBkTxCd().getPrtry().getCd().value());
        
        EntryTransaction81 transDetail = acctNoti.getNtry().getNtryDtls().getTxDtls();
        ntfctn.setNtryDetailEndToEndId(transDetail.getRefs().getEndToEndId());
        ntfctn.setNtryDetailTxId(transDetail.getRefs().getTxId());
        ntfctn.setNtryDetailMandateId(transDetail.getRefs().getMndtId());
        ntfctn.setNtryDetailClrSysRef(transDetail.getRefs().getClrSysRef());
        
        ntfctn.setNtryDetailAmt(transDetail.getAmt().getValue());
        ntfctn.setNtryDetailAmtCcy(transDetail.getAmt().getCcy().value());
        ntfctn.setNtryDetailCdtDbtInd(transDetail.getCdtDbtInd().value());
        
        if (transDetail.getChrgs() != null) {
          
          ChargesRecord21 chargesRecord = transDetail.getChrgs().getRcrd();
          ntfctn.setNtryDetailChrgsAmt(chargesRecord.getAmt().getValue());
          ntfctn.setNtryDetailChrgsAmtCcy(chargesRecord.getAmt().getCcy().value());
          ntfctn.setNtryDetailChrgsBr(chargesRecord.getBr().value());
          if (chargesRecord.getAgt() != null) {
            
            ntfctn.setNtryDetailChrgsAgtBic(chargesRecord.getAgt().getFinInstnId().getBICFI());
            ntfctn.setNtryDetailChrgsAgtMmbId(chargesRecord.getAgt().getFinInstnId().getClrSysMmbId().getMmbId());
          } 
        } 
        
        if (transDetail.getRltdPties() != null) {

          
          ntfctn.setRltdPtiesDbtrName(transDetail.getRltdPties().getDbtr().getNm());
          if (transDetail.getRltdPties().getDbtr().getId() != null)
          {
            if (transDetail.getRltdPties().getDbtr().getId().getOrgId() != null) {
              
              ntfctn.setRltdPtiesDbtrOrgIdBIC(transDetail.getRltdPties().getDbtr().getId().getOrgId().getAnyBIC());
              if (transDetail.getRltdPties().getDbtr().getId().getOrgId().getOthr() != null)
              {
                ntfctn.setRltdPtiesDbtrOrgIdOthrId(transDetail.getRltdPties().getDbtr().getId().getOrgId().getOthr().getId());
                ntfctn.setRltdPtiesDbtrOrgIdOthrSchme(transDetail.getRltdPties().getDbtr().getId().getOrgId().getOthr().getSchmeNm().getCd().value());
                ntfctn.setRltdPtiesDbtrOrgIdOthrIssr(transDetail.getRltdPties().getDbtr().getId().getOrgId().getOthr().getIssr());
              }
            
            } else if (transDetail.getRltdPties().getDbtr().getId().getPrvtId() != null) {
              
              ntfctn.setRltdPtiesDbtrPrvtIdOthrId(transDetail.getRltdPties().getDbtr().getId().getPrvtId().getOthr().getId());
              ntfctn.setRltdPtiesDbtrPrvtIdOthrSchme(transDetail.getRltdPties().getDbtr().getId().getPrvtId().getOthr().getSchmeNm().getCd().value());
              ntfctn.setRltdPtiesDbtrPrvtIdOthrIssr(transDetail.getRltdPties().getDbtr().getId().getPrvtId().getOthr().getIssr());
            } 
          }
          
          if (transDetail.getRltdPties().getDbtr().getCtctDtls() != null) {
            
            ntfctn.setRltdPtiesDbtrContactMobile(transDetail.getRltdPties().getDbtr().getCtctDtls().getMobNb());
            ntfctn.setRltdPtiesDbtrContactEmail(transDetail.getRltdPties().getDbtr().getCtctDtls().getEmailAdr());
          } 
          
          if (transDetail.getRltdPties().getDbtrAcct() != null) {
            
            ntfctn.setRltdPtiesDbtrAcctId(transDetail.getRltdPties().getDbtrAcct().getId().getOthr().getId());
            ntfctn.setRltdPtiesDbtrAcctScheme(transDetail.getRltdPties().getDbtrAcct().getId().getOthr().getSchmeNm().getPrtry().value());
          } 

          
          ntfctn.setRltdPtiesCdtrName(transDetail.getRltdPties().getCdtr().getNm());
          if (transDetail.getRltdPties().getCdtr().getId() != null)
          {
            if (transDetail.getRltdPties().getCdtr().getId().getOrgId() != null) {
              
              ntfctn.setRltdPtiesCdtrOrgIdBIC(transDetail.getRltdPties().getCdtr().getId().getOrgId().getAnyBIC());
              if (transDetail.getRltdPties().getCdtr().getId().getOrgId().getOthr() != null)
              {
                ntfctn.setRltdPtiesCdtrOrgIdOthrId(transDetail.getRltdPties().getCdtr().getId().getOrgId().getOthr().getId());
                ntfctn.setRltdPtiesCdtrOrgIdOthrSchme(transDetail.getRltdPties().getCdtr().getId().getOrgId().getOthr().getSchmeNm().getCd().value());
                ntfctn.setRltdPtiesCdtrOrgIdOthrIssr(transDetail.getRltdPties().getCdtr().getId().getOrgId().getOthr().getIssr());
              }
            
            } else if (transDetail.getRltdPties().getCdtr().getId().getPrvtId() != null) {
              
              ntfctn.setRltdPtiesCdtrPrvtIdOthrId(transDetail.getRltdPties().getCdtr().getId().getPrvtId().getOthr().getId());
              ntfctn.setRltdPtiesCdtrPrvtIdOthrSchme(transDetail.getRltdPties().getCdtr().getId().getPrvtId().getOthr().getSchmeNm().getCd().value());
              ntfctn.setRltdPtiesCdtrPrvtIdOthrIssr(transDetail.getRltdPties().getCdtr().getId().getPrvtId().getOthr().getIssr());
            } 
          }
          
          if (transDetail.getRltdPties().getCdtr().getCtctDtls() != null) {
            
            ntfctn.setRltdPtiesCdtrContactMobile(transDetail.getRltdPties().getCdtr().getCtctDtls().getMobNb());
            ntfctn.setRltdPtiesCdtrContactEmail(transDetail.getRltdPties().getCdtr().getCtctDtls().getEmailAdr());
          } 
          
          if (transDetail.getRltdPties().getCdtrAcct() != null) {
            
            ntfctn.setRltdPtiesCdtrAcctId(transDetail.getRltdPties().getCdtrAcct().getId().getOthr().getId());
            ntfctn.setRltdPtiesCdtrAcctScheme(transDetail.getRltdPties().getCdtrAcct().getId().getOthr().getSchmeNm().getPrtry().value());
          } 
        } 
        
        TransactionAgents31 transAgent = transDetail.getRltdAgts();
        ntfctn.setRelatedAgentsDbtrBIC(transAgent.getDbtrAgt().getFinInstnId().getBICFI());
        ntfctn.setRelatedAgentsDbtrMmbId(transAgent.getDbtrAgt().getFinInstnId().getClrSysMmbId().getMmbId());
        ntfctn.setRelatedAgentsCdtrBIC(transAgent.getCdtrAgt().getFinInstnId().getBICFI());
        ntfctn.setRelatedAgentsCdtrMmbId(transAgent.getCdtrAgt().getFinInstnId().getClrSysMmbId().getMmbId());
        
        if (transDetail.getPurp() != null) {
          
          ntfctn.setPurpCode(transDetail.getPurp().getCd());
          ntfctn.setPurpOther(transDetail.getPurp().getPrtry());
        } 
        
        if (transDetail.getRmtInf() != null)
        {
          ntfctn.setRemitInfUstrd(transDetail.getRmtInf().getUstrd());
        }
        
        if (transDetail.getRltdDts().getIntrBkSttlmDt() != null)
          ntfctn.setRelatedDatesIntrSettlDate(transDetail.getRltdDts().getIntrBkSttlmDt().toGregorianCalendar().getTime()); 
        if (transDetail.getRltdDts().getTxDtTm() != null) {
          ntfctn.setRelatedDatesTransTs(transDetail.getRltdDts().getTxDtTm().toGregorianCalendar().getTime());
        }
        if (transDetail.getRtrInf() != null) {
          
          ntfctn.setReturnInfRsn(transDetail.getRtrInf().getRsn().getPrtry());
          StringBuffer loc_sb = new StringBuffer();
          for (int loc_i = 0; loc_i < transDetail.getRtrInf().getAddtlInf().size(); loc_i++)
          {
            loc_sb.append((loc_i == 0) ? (String)transDetail.getRtrInf().getAddtlInf().get(loc_i) : ("<BR>" + (String)transDetail.getRtrInf().getAddtlInf().get(loc_i)));
          }
          ntfctn.setReturnInfMsg(loc_sb.toString());
        } 
        
        camt054MsgVo.getNotifList().add(ntfctn);
      } 
    }
    return camt054MsgVo;
  }
}
