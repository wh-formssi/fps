-- --------------- create DB myfps B.8.1-----------------
CREATE DATABASE IF NOT EXISTS ffp DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
use ffp;
-- create table TB_MSG_JNL-----------------
DROP TABLE IF EXISTS `TB_MSG_JNL`;  
CREATE TABLE `TB_MSG_JNL` (  
  `MSG_JNL` int primary key auto_increment,
  `MSG_BANK_NO` varchar(32) DEFAULT NULL,  
  `MSG_TRAN_ID` varchar(32) DEFAULT NULL,  
  `END_TO_END_ID` varchar(32) DEFAULT NULL,
  `MSG_REASON` varchar(64) DEFAULT NULL,  
  `MSG_TRANS_STATUS` varchar(16) DEFAULT NULL,
  `MSG_INST_DATE`  TIMESTAMP  DEFAULT CURRENT_TIMESTAMP,
  `MSG_ACCE_DATE`  TIMESTAMP  DEFAULT CURRENT_TIMESTAMP
) DEFAULT CHARSET=utf8;  

-- ------ create table TB_MSG_JNL_ACTION--------
DROP TABLE IF EXISTS `TB_MSG_JNL_ACTION`;  
CREATE TABLE `TB_MSG_JNL_ACTION` (  
  `MSG_JNL` int primary key auto_increment,
  `MSG_TRAN_ID` varchar(32) DEFAULT NULL, 
  `MSG_ID` varchar(64) DEFAULT NULL, 
  `ACTION_TYPE`  varchar(16) DEFAULT NULL,
  `END_TO_END_ID` varchar(32) DEFAULT NULL,
  `ACTION_TRANS_STATUS` varchar(16) DEFAULT NULL,
  `MSG_ACCE_DATE`  TIMESTAMP  DEFAULT CURRENT_TIMESTAMP,
  `MSG_INST_DATE`  TIMESTAMP  DEFAULT CURRENT_TIMESTAMP
)  DEFAULT CHARSET=utf8;  

 -- --------------- create table TB_MSG_DATA-------------
DROP TABLE IF EXISTS `TB_MSG_DATA`;  
CREATE TABLE `TB_MSG_DATA` (  
  `MSG_JNL` int primary key auto_increment,
  `MSG_ID` varchar(64) DEFAULT NULL, 
  `MSG_CONTENT`  varchar(10000) DEFAULT NULL,
  `MSG_INST_DATE`  TIMESTAMP  DEFAULT CURRENT_TIMESTAMP
)  DEFAULT CHARSET=utf8;  

-- --------------- create table TB_MSG_HEAD-------------
DROP TABLE IF EXISTS `TB_MSG_HEAD`;  
CREATE TABLE `TB_MSG_HEAD` (  
  `MSG_JNL` int primary key auto_increment, 
  `MSG_ID` varchar(64) DEFAULT NULL, 
  `MSG_BUSI_SERVICE` varchar(64) DEFAULT NULL, 
  `MSG_FR_MMBID`  varchar(64) DEFAULT NULL, 
  `MSG_TO_MMBID`  varchar(64) DEFAULT NULL, 
  `BIZ_MSG_IDR` varchar(64) DEFAULT NULL, 
  `MSG_DEF_IDR` varchar(64) DEFAULT NULL, 
  `MSG_BIZ_SVC` varchar(64) DEFAULT NULL, 
  `MSG_CRE_DT`  varchar(16) DEFAULT NULL, 
  `MSG_INST_DATE`  TIMESTAMP  DEFAULT CURRENT_TIMESTAMP
) DEFAULT CHARSET=utf8;  
-- --------------- create table TB_MSG_BTCHINF-------------
DROP TABLE IF EXISTS `TB_MSG_BTCHINF`;  
CREATE TABLE `TB_MSG_BTCHINF` (  
  `MSG_JNL` int primary key auto_increment, 
  `MSG_ID` varchar(64) DEFAULT NULL, 
  `MSG_BTCH_ID`  varchar(64) DEFAULT NULL, 
  `FL_SEQ_NO`  varchar(16) DEFAULT NULL, 
  `NB_OF_FLS`  varchar(16) DEFAULT NULL, 
  `MSG_INST_DATE`  TIMESTAMP  DEFAULT CURRENT_TIMESTAMP
) DEFAULT CHARSET=utf8;  

-- --------------- create table TB_MSG_DOCUMENT(B.9.4.8cancel no show and B.9.5.2 and later)-------------
DROP TABLE IF EXISTS `TB_MSG_DOCUMENT`;  
CREATE TABLE `TB_MSG_DOCUMENT` (  
  `MSG_JNL` int primary key auto_increment, 
  `MSG_ID` varchar(64) DEFAULT NULL, 
  `GRPHDR_MSG_ID`  varchar(64) DEFAULT NULL, 
  `CRE_DT_TM`  varchar(32) DEFAULT NULL, 
  `NB_OF_TXS` varchar(16) DEFAULT NULL,  
  `MSG_STTLM_MTD` varchar(16) DEFAULT NULL, 
  `GRPHDR_STTLMINF_PRTRY` varchar(16) DEFAULT NULL, 
  `ORGNL_MSG_ID` varchar(64) DEFAULT NULL, 
  `ORGNL_MSG_NM_ID` varchar(64) DEFAULT NULL, 
  `MSG_GRP_STS` varchar(16) DEFAULT NULL, 
  
  `NOTI_PTY_STNID_MMBID`  varchar(32) DEFAULT NULL, 
  
  `MSG_ACCPTD` varchar(16) DEFAULT NULL, 
  `MSG_RCPT_MD` varchar(16) DEFAULT NULL, 
  `MSG_SWTCH_TM` varchar(64) DEFAULT NULL, 
  
  `MSG_REF` varchar(64) DEFAULT NULL, 
  `RJC_PTY_RSN` varchar(64) DEFAULT NULL, 
  `RJC_TN_DT_TM` varchar(64) DEFAULT NULL, 
  `MSG_RSN_DESC` varchar(64) DEFAULT NULL, 
  `MSG_ADDTL_DATA` varchar(64) DEFAULT NULL, 
  
  `MSG_EVT_CD` varchar(16) DEFAULT NULL, 
  `MSG_EVT_DESC` varchar(64) DEFAULT NULL, 
  `MSG_EVT_TM` varchar(16) DEFAULT NULL, 
  `MSG_INST_DATE`  TIMESTAMP  DEFAULT CURRENT_TIMESTAMP
) DEFAULT CHARSET=utf8;  
-- --------------- create table TB_MSG_DOCUMENT_SECOND-------------
DROP TABLE IF EXISTS `TB_MSG_DOCUMENT_SECOND`;  
CREATE TABLE `TB_MSG_DOCUMENT_SECOND` (  
  `MSG_JNL` int primary key auto_increment, 
  `MSG_ID` varchar(64) DEFAULT NULL, 

  `MSG_RTR_ID` varchar(64) DEFAULT NULL, 
  `CLR_SYS_REF` varchar(64) DEFAULT NULL,
  `RTRRSNINF_RSN_PRTRY` varchar(16) DEFAULT NULL,  
  `END_TO_END_ID` varchar(64) DEFAULT NULL, 
  `MSG_TX_ID` varchar(64) DEFAULT NULL, 
  `PMTTPINF_CTGYPURP_PRTRY` varchar(16) DEFAULT NULL,  
  `INTR_BK_STTLM_AMT` varchar(16) DEFAULT NULL, 
  `INTR_BK_STTLM_DT` varchar(16) DEFAULT NULL,  
  `MSG_INSTD_AMT` varchar(16) DEFAULT NULL,  
  `MSG_CHRG_BR` varchar(16) DEFAULT NULL,  
  `MSG_CDTR_NM` varchar(16) DEFAULT NULL, 
  `CDTRACCT_OTHR_ID` varchar(16) DEFAULT NULL, 
  `CDTRACCT_SCHMENM_PRTRY` varchar(16) DEFAULT NULL, 
  `CDTRAGT_FININSTNID_BICFI` varchar(16) DEFAULT NULL,  
  `CDTRAGT_CLRSYSMMBID_MMBID` varchar(16) DEFAULT NULL, 
  `MSG_DBTR_NM` varchar(16) DEFAULT NULL,  
  `DBTR_CTCTDTLS_MOBNB` varchar(32) DEFAULT NULL,  
  `DBTR_CTCTDTLS_EMAIL_ADR` varchar(32) DEFAULT NULL, 
  `DBTRACCT_OTHR_ID` varchar(16) DEFAULT NULL,  
  `DBTRACCT_SCHEMENM_PRTRY` varchar(16) DEFAULT NULL,  
  `DBTRAGT_FININSTNID_BICFI` varchar(16) DEFAULT NULL,  
  `DBTRAGT_CLRSYSMMBID_MMBID` varchar(16) DEFAULT NULL,  
  `MSG_PURP_CD` varchar(16) DEFAULT NULL, 

  
  `MSG_TX_STS` varchar(64) DEFAULT NULL, 
  `ACCPTNC_DT_TM` varchar(16) DEFAULT NULL, 
  `PMTTPINF_LCLINSTRM_PRTRY` varchar(16) DEFAULT NULL,  
  `STTLMTMINDCTN_CDTDT_TM` varchar(16) DEFAULT NULL,  
 
 
  
  `CDTR_OTHR_ID` varchar(16) DEFAULT NULL, 
  `CDTR_SCHMENM_PRTRY` varchar(16) DEFAULT NULL, 
  `CDTR_CTCTDTLS_MOBNO` varchar(16) DEFAULT NULL, 


  `MSG_RMTINF_USTRD` varchar(16) DEFAULT NULL, 

  `MSG_INST_DATE`  TIMESTAMP  DEFAULT CURRENT_TIMESTAMP
) DEFAULT CHARSET=utf8;  
-- --------------- create table TB_MSG_DOCUMENT_LIST_THIRD-------------
DROP TABLE IF EXISTS `TB_MSG_DOCUMENT_LIST_THIRD`;  
CREATE TABLE `TB_MSG_DOCUMENT_LIST_THIRD` (  
  `MSG_JNL` int primary key auto_increment, 
  `MSG_ID` varchar(64) DEFAULT NULL, 
  `MSG_ADDTL_INF` varchar(64) DEFAULT NULL, 
  `MSG_INST_DATE`  TIMESTAMP  DEFAULT CURRENT_TIMESTAMP
) DEFAULT CHARSET=utf8;  