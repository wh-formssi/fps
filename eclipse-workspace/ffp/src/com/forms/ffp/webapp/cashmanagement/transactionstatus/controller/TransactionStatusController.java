package com.forms.ffp.webapp.cashmanagement.transactionstatus.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.forms.beneform4j.core.util.page.IPage;
import com.forms.beneform4j.web.annotation.PageJsonBody;
import com.forms.ffp.core.utils.FFPStringUtils;
import com.forms.ffp.persistents.bean.tx.inquiry.I110.FFPJbI110;
import com.forms.ffp.webapp.cashmanagement.transactionstatus.service.ITransactionStatusService;

@Scope("request")
@Controller
@RequestMapping("ffp/cashmanagement/transactionstatus/")
public class TransactionStatusController
{
	@Resource(name = "TransactionStatusService")
	private ITransactionStatusService transactionStatusService;

	@RequestMapping("list")
	@PageJsonBody
	public List<FFPJbI110> list(FFPJbI110 form, IPage page) throws Exception
	{
		if (!validate(form))
		{
			List<FFPJbI110> result = transactionStatusService.insertAndSend(form);
			if (result != null)
			{

				return result;
			}

		}
		return new ArrayList<FFPJbI110>();

	}

	public boolean validate(FFPJbI110 form)
	{
		boolean flag = false;
		if (FFPStringUtils.isEmptyOrNull(form.getCdtrAgtMmbId()) || FFPStringUtils.isEmptyOrNull(form.getDbtrAgtMmbId())
				|| (FFPStringUtils.isEmptyOrNull(form.getTransactionId()) && FFPStringUtils.isEmptyOrNull(form.getClrSysRef())))
		{
			flag = true;
		}
		return flag;

	}
}
