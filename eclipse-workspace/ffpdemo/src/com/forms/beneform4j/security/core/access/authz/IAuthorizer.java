package com.forms.beneform4j.security.core.access.authz;

import com.forms.beneform4j.core.service.request.IRequestInfo;
import com.forms.beneform4j.security.core.access.info.IAuthorizationInfo;

/**
 * Copy Right Information : Forms Syntron <br>
 * Project : 四方精创 Java EE 开发平台 <br>
 * Description : 授权器接口<br>
 * Author : LinJisong <br>
 * Version : 1.0.0 <br>
 * Since : 1.0.0 <br>
 * Date : 2016-4-8<br>
 */
public interface IAuthorizer {

    /**
     * 授权
     * 
     * @param requestInfo 请求信息
     * @return 授权信息
     */
    public IAuthorizationInfo isPermitted(IRequestInfo requestInfo);
}
