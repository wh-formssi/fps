//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.30 at 11:51:13 ���� CST 
//


package com.forms.ffp.adaptor.jaxb.iclfps.pain_011_001_05;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Party11Choice__1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Party11Choice__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="OrgId" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}OrganisationIdentification8__1"/>
 *           &lt;element name="PrvtId" type="{urn:iso:std:iso:20022:tech:xsd:pain.011.001.05}PersonIdentification5__1"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Party11Choice__1", propOrder = {
    "orgId",
    "prvtId"
})
public class Party11Choice1 {

    @XmlElement(name = "OrgId")
    protected OrganisationIdentification81 orgId;
    @XmlElement(name = "PrvtId")
    protected PersonIdentification51 prvtId;

    /**
     * Gets the value of the orgId property.
     * 
     * @return
     *     possible object is
     *     {@link OrganisationIdentification81 }
     *     
     */
    public OrganisationIdentification81 getOrgId() {
        return orgId;
    }

    /**
     * Sets the value of the orgId property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganisationIdentification81 }
     *     
     */
    public void setOrgId(OrganisationIdentification81 value) {
        this.orgId = value;
    }

    /**
     * Gets the value of the prvtId property.
     * 
     * @return
     *     possible object is
     *     {@link PersonIdentification51 }
     *     
     */
    public PersonIdentification51 getPrvtId() {
        return prvtId;
    }

    /**
     * Sets the value of the prvtId property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonIdentification51 }
     *     
     */
    public void setPrvtId(PersonIdentification51 value) {
        this.prvtId = value;
    }

}