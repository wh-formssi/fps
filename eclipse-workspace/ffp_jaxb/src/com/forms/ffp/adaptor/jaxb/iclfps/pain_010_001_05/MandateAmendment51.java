//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.30 at 11:51:13 ���� CST 
//


package com.forms.ffp.adaptor.jaxb.iclfps.pain_010_001_05;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MandateAmendment5__1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MandateAmendment5__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AmdmntRsn" type="{urn:iso:std:iso:20022:tech:xsd:pain.010.001.05}MandateAmendmentReason1__1"/>
 *         &lt;element name="Mndt" type="{urn:iso:std:iso:20022:tech:xsd:pain.010.001.05}Mandate8__1"/>
 *         &lt;element name="OrgnlMndt" type="{urn:iso:std:iso:20022:tech:xsd:pain.010.001.05}OriginalMandate4Choice__1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MandateAmendment5__1", propOrder = {
    "amdmntRsn",
    "mndt",
    "orgnlMndt"
})
public class MandateAmendment51 {

    @XmlElement(name = "AmdmntRsn", required = true)
    protected MandateAmendmentReason11 amdmntRsn;
    @XmlElement(name = "Mndt", required = true)
    protected Mandate81 mndt;
    @XmlElement(name = "OrgnlMndt", required = true)
    protected OriginalMandate4Choice1 orgnlMndt;

    /**
     * Gets the value of the amdmntRsn property.
     * 
     * @return
     *     possible object is
     *     {@link MandateAmendmentReason11 }
     *     
     */
    public MandateAmendmentReason11 getAmdmntRsn() {
        return amdmntRsn;
    }

    /**
     * Sets the value of the amdmntRsn property.
     * 
     * @param value
     *     allowed object is
     *     {@link MandateAmendmentReason11 }
     *     
     */
    public void setAmdmntRsn(MandateAmendmentReason11 value) {
        this.amdmntRsn = value;
    }

    /**
     * Gets the value of the mndt property.
     * 
     * @return
     *     possible object is
     *     {@link Mandate81 }
     *     
     */
    public Mandate81 getMndt() {
        return mndt;
    }

    /**
     * Sets the value of the mndt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mandate81 }
     *     
     */
    public void setMndt(Mandate81 value) {
        this.mndt = value;
    }

    /**
     * Gets the value of the orgnlMndt property.
     * 
     * @return
     *     possible object is
     *     {@link OriginalMandate4Choice1 }
     *     
     */
    public OriginalMandate4Choice1 getOrgnlMndt() {
        return orgnlMndt;
    }

    /**
     * Sets the value of the orgnlMndt property.
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalMandate4Choice1 }
     *     
     */
    public void setOrgnlMndt(OriginalMandate4Choice1 value) {
        this.orgnlMndt = value;
    }

}
