//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.30 at 11:51:13 ���� CST 
//


package com.forms.ffp.adaptor.jaxb.iclfps.pacs_004_001_07;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Charges2__1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Charges2__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Amt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.07}Restricted15Digit2DecimalCurrencyAndAmount"/>
 *         &lt;element name="Agt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.07}BranchAndFinancialInstitutionIdentification5__1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Charges2__1", propOrder = {
    "amt",
    "agt"
})
public class Charges21 {

    @XmlElement(name = "Amt", required = true)
    protected Restricted15Digit2DecimalCurrencyAndAmount amt;
    @XmlElement(name = "Agt", required = true)
    protected BranchAndFinancialInstitutionIdentification51 agt;

    /**
     * Gets the value of the amt property.
     * 
     * @return
     *     possible object is
     *     {@link Restricted15Digit2DecimalCurrencyAndAmount }
     *     
     */
    public Restricted15Digit2DecimalCurrencyAndAmount getAmt() {
        return amt;
    }

    /**
     * Sets the value of the amt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Restricted15Digit2DecimalCurrencyAndAmount }
     *     
     */
    public void setAmt(Restricted15Digit2DecimalCurrencyAndAmount value) {
        this.amt = value;
    }

    /**
     * Gets the value of the agt property.
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification51 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification51 getAgt() {
        return agt;
    }

    /**
     * Sets the value of the agt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification51 }
     *     
     */
    public void setAgt(BranchAndFinancialInstitutionIdentification51 value) {
        this.agt = value;
    }

}
