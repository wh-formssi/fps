//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.30 at 11:51:13 ���� CST 
//


package com.forms.ffp.adaptor.jaxb.iclfps.pain_011_001_05;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FPSMandateReasonCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FPSMandateReasonCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MD16"/>
 *     &lt;enumeration value="MD17"/>
 *     &lt;enumeration value="MD18"/>
 *     &lt;enumeration value="MS02"/>
 *     &lt;enumeration value="MS03"/>
 *     &lt;enumeration value="NARR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FPSMandateReasonCode")
@XmlEnum
public enum FPSMandateReasonCode {

    @XmlEnumValue("MD16")
    MD_16("MD16"),
    @XmlEnumValue("MD17")
    MD_17("MD17"),
    @XmlEnumValue("MD18")
    MD_18("MD18"),
    @XmlEnumValue("MS02")
    MS_02("MS02"),
    @XmlEnumValue("MS03")
    MS_03("MS03"),
    NARR("NARR");
    private final String value;

    FPSMandateReasonCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FPSMandateReasonCode fromValue(String v) {
        for (FPSMandateReasonCode c: FPSMandateReasonCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
