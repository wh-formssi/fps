package com.forms.beneform4j.web.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Copy Right Information : Forms Syntron <br>
 * Project : 四方精创 Java EE 开发平台 <br>
 * Description : 树型查询TreeJsonBody注解<br>
 * Author : LinJisong <br>
 * Version : 1.0.0 <br>
 * Since : 1.0.0 <br>
 * Date : 2016-4-18<br>
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ResponseBody
public @interface TreeJsonBody {

    /**
     * 同JsonBody中的fields
     * 
     * @return
     */
    String[] value() default {};

    /**
     * 同JsonBody中的jsonFields，优先级比fields要高
     * 
     * @return
     */
    JsonField[] jsonFields() default {};

    /**
     * 只有一个节点时是否返回数组，默认为true
     * 
     * @return
     */
    boolean returnArrayWhenOnlyOneNode() default true;

}
