//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.30 at 11:51:13 ���� CST 
//


package com.forms.ffp.adaptor.jaxb.iclfps.admi_004_001_02;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Event2__1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Event2__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EvtCd" type="{urn:iso:std:iso:20022:tech:xsd:admi.004.001.02}Exact4UpperCaseAlphaNumericText"/>
 *         &lt;element name="EvtParam" type="{urn:iso:std:iso:20022:tech:xsd:admi.004.001.02}RestrictedFINZMax35Text" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="EvtDesc" type="{urn:iso:std:iso:20022:tech:xsd:admi.004.001.02}RestrictedFINZMax1000Text"/>
 *         &lt;element name="EvtTm" type="{urn:iso:std:iso:20022:tech:xsd:admi.004.001.02}FPSISODateTimeType1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Event2__1", propOrder = {
    "evtCd",
    "evtParam",
    "evtDesc",
    "evtTm"
})
public class Event21 {

    @XmlElement(name = "EvtCd", required = true)
    protected String evtCd;
    @XmlElement(name = "EvtParam")
    protected List<String> evtParam;
    @XmlElement(name = "EvtDesc", required = true)
    protected String evtDesc;
    @XmlElement(name = "EvtTm", required = true)
    protected XMLGregorianCalendar evtTm;

    /**
     * Gets the value of the evtCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvtCd() {
        return evtCd;
    }

    /**
     * Sets the value of the evtCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvtCd(String value) {
        this.evtCd = value;
    }

    /**
     * Gets the value of the evtParam property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the evtParam property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEvtParam().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getEvtParam() {
        if (evtParam == null) {
            evtParam = new ArrayList<String>();
        }
        return this.evtParam;
    }

    /**
     * Gets the value of the evtDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvtDesc() {
        return evtDesc;
    }

    /**
     * Sets the value of the evtDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvtDesc(String value) {
        this.evtDesc = value;
    }

    /**
     * Gets the value of the evtTm property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEvtTm() {
        return evtTm;
    }

    /**
     * Sets the value of the evtTm property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEvtTm(XMLGregorianCalendar value) {
        this.evtTm = value;
    }

}