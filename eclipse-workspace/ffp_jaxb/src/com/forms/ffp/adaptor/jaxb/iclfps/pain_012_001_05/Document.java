//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.30 at 11:51:13 ���� CST 
//


package com.forms.ffp.adaptor.jaxb.iclfps.pain_012_001_05;

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
 *         &lt;element name="MndtAccptncRpt" type="{urn:iso:std:iso:20022:tech:xsd:pain.012.001.05}MandateAcceptanceReportV05"/>
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
    "mndtAccptncRpt"
})
public class Document {

    @XmlElement(name = "MndtAccptncRpt", required = true)
    protected MandateAcceptanceReportV05 mndtAccptncRpt;

    /**
     * Gets the value of the mndtAccptncRpt property.
     * 
     * @return
     *     possible object is
     *     {@link MandateAcceptanceReportV05 }
     *     
     */
    public MandateAcceptanceReportV05 getMndtAccptncRpt() {
        return mndtAccptncRpt;
    }

    /**
     * Sets the value of the mndtAccptncRpt property.
     * 
     * @param value
     *     allowed object is
     *     {@link MandateAcceptanceReportV05 }
     *     
     */
    public void setMndtAccptncRpt(MandateAcceptanceReportV05 value) {
        this.mndtAccptncRpt = value;
    }

}
