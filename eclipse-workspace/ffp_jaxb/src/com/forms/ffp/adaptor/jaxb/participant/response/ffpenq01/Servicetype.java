//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.18 at 11:11:46 上午 CST 
//


package com.forms.ffp.adaptor.jaxb.participant.response.ffpenq01;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for servicetype.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="servicetype">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DR"/>
 *     &lt;enumeration value="CR"/>
 *     &lt;enumeration value="OR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "servicetype",namespace = "http://www.formssi.com/response/ffpenq01")
@XmlEnum
public enum Servicetype {

    DR,
    CR,
    OR;

    public String value() {
        return name();
    }

    public static Servicetype fromValue(String v) {
        return valueOf(v);
    }

}
