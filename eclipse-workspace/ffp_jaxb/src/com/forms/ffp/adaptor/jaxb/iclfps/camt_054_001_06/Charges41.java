//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.30 at 11:51:13 ���� CST 
//


package com.forms.ffp.adaptor.jaxb.iclfps.camt_054_001_06;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Charges4__1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Charges4__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Rcrd" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.06}ChargesRecord2__1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Charges4__1", propOrder = {
    "rcrd"
})
public class Charges41 {

    @XmlElement(name = "Rcrd")
    protected ChargesRecord21 rcrd;

    /**
     * Gets the value of the rcrd property.
     * 
     * @return
     *     possible object is
     *     {@link ChargesRecord21 }
     *     
     */
    public ChargesRecord21 getRcrd() {
        return rcrd;
    }

    /**
     * Sets the value of the rcrd property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargesRecord21 }
     *     
     */
    public void setRcrd(ChargesRecord21 value) {
        this.rcrd = value;
    }

}