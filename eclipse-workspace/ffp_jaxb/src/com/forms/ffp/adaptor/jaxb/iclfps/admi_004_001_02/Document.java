//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.30 at 11:51:13 ���� CST 
//


package com.forms.ffp.adaptor.jaxb.iclfps.admi_004_001_02;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Document complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Document">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SysEvtNtfctn" type="{urn:iso:std:iso:20022:tech:xsd:admi.004.001.02}SystemEventNotificationV02"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document", propOrder = {
    "sysEvtNtfctn"
})
public class Document {

    @XmlElement(name = "SysEvtNtfctn", required = true)
    protected SystemEventNotificationV02 sysEvtNtfctn;

    /**
     * Gets the value of the sysEvtNtfctn property.
     * 
     * @return
     *     possible object is
     *     {@link SystemEventNotificationV02 }
     *     
     */
    public SystemEventNotificationV02 getSysEvtNtfctn() {
        return sysEvtNtfctn;
    }

    /**
     * Sets the value of the sysEvtNtfctn property.
     * 
     * @param value
     *     allowed object is
     *     {@link SystemEventNotificationV02 }
     *     
     */
    public void setSysEvtNtfctn(SystemEventNotificationV02 value) {
        this.sysEvtNtfctn = value;
    }

}
