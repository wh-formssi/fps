//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.30 at 11:51:13 ���� CST 
//


package com.forms.ffp.adaptor.jaxb.iclfps.pacs_003_001_07;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FPSAccountTypeCode__1.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FPSAccountTypeCode__1">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;pattern value="[A-Z0-9]{4}"/>
 *     &lt;enumeration value="BBAN"/>
 *     &lt;enumeration value="AIIN"/>
 *     &lt;enumeration value="CUST"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FPSAccountTypeCode__1")
@XmlEnum
public enum FPSAccountTypeCode1 {

    BBAN,
    AIIN,
    CUST;

    public String value() {
        return name();
    }

    public static FPSAccountTypeCode1 fromValue(String v) {
        return valueOf(v);
    }

}
