package com.forms.datapipe.headfoot;

import com.forms.datapipe.exception.DataPipeException;
import com.forms.datapipe.Output;

public class FooterHandler4Multi extends FooterHandler
{
	
	/* (non-Javadoc)
	 * @see com.forms.datapipe.headfoot.FooterHandler#getFileName(com.forms.datapipe.Output)
	 */
	protected String getFileName(Output ip_output) throws DataPipeException
	{
		return HeadFootUtil.getFileName4Mult(ip_output);
	}

	/* (non-Javadoc)
	 * @see com.forms.datapipe.headfoot.FooterHandler#getRecLen(com.forms.datapipe.Output)
	 */
	protected int getRecLen(Output ip_output) throws DataPipeException
	{
		return HeadFootUtil.getRecLen4Multi(ip_output);
	}
}