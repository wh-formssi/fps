//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.30 at 11:51:13 ���� CST 
//


package com.forms.ffp.adaptor.jaxb.iclfps.pain_018_001_01;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FPSMandateLocalInstrument.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FPSMandateLocalInstrument">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DDMU"/>
 *     &lt;enumeration value="DDMC"/>
 *     &lt;enumeration value="DDMP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FPSMandateLocalInstrument")
@XmlEnum
public enum FPSMandateLocalInstrument {

    DDMU,
    DDMC,
    DDMP;

    public String value() {
        return name();
    }

    public static FPSMandateLocalInstrument fromValue(String v) {
        return valueOf(v);
    }

}
