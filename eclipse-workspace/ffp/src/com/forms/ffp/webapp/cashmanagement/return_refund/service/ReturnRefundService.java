package com.forms.ffp.webapp.cashmanagement.return_refund.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.forms.beneform4j.core.util.page.IPage;
import com.forms.ffp.core.define.FFPConstantsTxJnl;
import com.forms.ffp.webapp.cashmanagement.return_refund.bean.ReturnRefundBean;
import com.forms.ffp.webapp.cashmanagement.return_refund.bean.ReturnRefundDetailBean;
import com.forms.ffp.webapp.cashmanagement.return_refund.dao.ReturnRefundDao;
import com.forms.ffp.webapp.cashmanagement.return_refund.form.DoReturnRefundForm;
import com.forms.ffp.webapp.cashmanagement.return_refund.form.ReturnRefundSearchForm;

@Service("ReturnRefundService")
public class ReturnRefundService implements ReturnRefundIService {

	@Resource(name = "ReturnRefundDao")
	private ReturnRefundDao dao;

	 @Resource(name="ReturnRefund_Pacs004Service")
	 private ReturnRefund_Pacs004Service p004;
	//

	@Override
	public List<ReturnRefundBean> inquerySomeRRMsg(ReturnRefundSearchForm form,IPage page) {
		return dao.inqueryReturnMsg(form,page);
	}

	@Override
	public String doReturnRefund(DoReturnRefundForm form) {
		switch (form.getRetCode()) {
		case "AC01":
			form.setRetReason("Incorrect Account Number");
			break;
		case "AC04":
			form.setRetReason("Closed Account Number");
			break;
		case "AM09":
			form.setRetReason("Wrong Amount");
			break;
		case "BE01":
			form.setRetReason("Inconsistent with End Customer");
			break;
		case "CURR":
			form.setRetReason("Incorrect Currency");
			break;
		case "MD06":
			form.setRetReason("Refund Request by End Customer");
			break;
		case "TM01":
			form.setRetReason("Timeout or After Processing Cut-off Time");
			break;
		default:
			form.setRetReason(form.getRetCode());
			form.setRetCode("NARR");
			break;
		}
		
		 try{
		 p004.performMsg(form);
		 }catch(Exception e){
		 e.printStackTrace();
		 return "NO";
		 }
		 return "OK";
	}

	@Override
	public ReturnRefundDetailBean inqueryDetail(String txCode, String jnlNo) {
		// TODO Auto-generated method stub
		return dao.inqueryReturnDetailMsg(txCode, jnlNo).get(0);

	}

}
