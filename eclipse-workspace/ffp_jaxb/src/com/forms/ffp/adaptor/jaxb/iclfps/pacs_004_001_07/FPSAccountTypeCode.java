//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.30 at 11:51:13 ���� CST 
//


package com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FPSAccountTypeCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FPSAccountTypeCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;pattern value="[A-Z0-9]{4}"/>
 *     &lt;enumeration value="BBAN"/>
 *     &lt;enumeration value="AIIN"/>
 *     &lt;enumeration value="SVID"/>
 *     &lt;enumeration value="EMAL"/>
 *     &lt;enumeration value="CUST"/>
 *     &lt;enumeration value="MOBN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FPSAccountTypeCode")
@XmlEnum
public enum FPSAccountTypeCode {

    BBAN,
    AIIN,
    SVID,
    EMAL,
    CUST,
    MOBN;

    public String value() {
        return name();
    }

    public static FPSAccountTypeCode fromValue(String v) {
        return valueOf(v);
    }

}
