package com.forms.beneform4j.webapp.systemmanage.menulocale.service;

import java.util.List;

import com.forms.beneform4j.webapp.systemmanage.menulocale.bean.BfGuideBean;
import com.forms.beneform4j.webapp.systemmanage.menulocale.form.BfGuideForm;

/**
 * Copy Right Information : Forms Syntron <br> 
 * Project : 四方精创 Java EE 开发平台<br> 
 * Description : 菜单国际化操作指引  <br> 
 * Author : XGP <br> 
 * Version : 1.0.0 <br> 
 * Since : 1.0.0 <br> 
 * Date : 2016-12-28 <br> 
 */

public interface IMenuGuideService {

	
	/**
	 * 菜单国际化操作指引接口
	 */
	public List<BfGuideBean> sLoadGuideChildren(int menuId);
	
	/**
	 * 
	 * 菜单国际化操作指引接口
	 * @return
	 */
	public int sSaveGuideMenu(BfGuideForm form);

}
