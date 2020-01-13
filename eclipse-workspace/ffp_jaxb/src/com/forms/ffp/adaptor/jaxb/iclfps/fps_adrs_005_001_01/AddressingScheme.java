//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.30 at 11:51:13 ���� CST 
//


package com.forms.ffp.adaptor.jaxb.iclfps.fps_adrs_005_001_01;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddressingScheme complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddressingScheme">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AdrRptId" type="{urn:hkicl:fps:xsd:fps.adrs.005.001.01}Max35Text"/>
 *         &lt;element name="Id" type="{urn:hkicl:fps:xsd:fps.adrs.005.001.01}Max34Text"/>
 *         &lt;element name="Tp" type="{urn:hkicl:fps:xsd:fps.adrs.005.001.01}ProxyIDType"/>
 *         &lt;element name="CusId" type="{urn:hkicl:fps:xsd:fps.adrs.005.001.01}Max34Text"/>
 *         &lt;element name="Sts" type="{urn:hkicl:fps:xsd:fps.adrs.005.001.01}Status"/>
 *         &lt;element name="Dflt" type="{urn:hkicl:fps:xsd:fps.adrs.005.001.01}YesNoIndicator" minOccurs="0"/>
 *         &lt;element name="StsUpdTm" type="{urn:hkicl:fps:xsd:fps.adrs.005.001.01}DateTimeType1"/>
 *         &lt;element name="InstgAgt" type="{urn:hkicl:fps:xsd:fps.adrs.005.001.01}Agent"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressingScheme", propOrder = {
    "adrRptId",
    "id",
    "tp",
    "cusId",
    "sts",
    "dflt",
    "stsUpdTm",
    "instgAgt"
})
public class AddressingScheme {

    @XmlElement(name = "AdrRptId", required = true)
    protected String adrRptId;
    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "Tp", required = true)
    protected ProxyIDType tp;
    @XmlElement(name = "CusId", required = true)
    protected String cusId;
    @XmlElement(name = "Sts", required = true)
    protected Status sts;
    @XmlElement(name = "Dflt")
    protected YesNoIndicator dflt;
    @XmlElement(name = "StsUpdTm", required = true)
    protected String stsUpdTm;
    @XmlElement(name = "InstgAgt", required = true)
    protected Agent instgAgt;

    /**
     * Gets the value of the adrRptId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdrRptId() {
        return adrRptId;
    }

    /**
     * Sets the value of the adrRptId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdrRptId(String value) {
        this.adrRptId = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the tp property.
     * 
     * @return
     *     possible object is
     *     {@link ProxyIDType }
     *     
     */
    public ProxyIDType getTp() {
        return tp;
    }

    /**
     * Sets the value of the tp property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProxyIDType }
     *     
     */
    public void setTp(ProxyIDType value) {
        this.tp = value;
    }

    /**
     * Gets the value of the cusId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCusId() {
        return cusId;
    }

    /**
     * Sets the value of the cusId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCusId(String value) {
        this.cusId = value;
    }

    /**
     * Gets the value of the sts property.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public Status getSts() {
        return sts;
    }

    /**
     * Sets the value of the sts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setSts(Status value) {
        this.sts = value;
    }

    /**
     * Gets the value of the dflt property.
     * 
     * @return
     *     possible object is
     *     {@link YesNoIndicator }
     *     
     */
    public YesNoIndicator getDflt() {
        return dflt;
    }

    /**
     * Sets the value of the dflt property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNoIndicator }
     *     
     */
    public void setDflt(YesNoIndicator value) {
        this.dflt = value;
    }

    /**
     * Gets the value of the stsUpdTm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStsUpdTm() {
        return stsUpdTm;
    }

    /**
     * Sets the value of the stsUpdTm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStsUpdTm(String value) {
        this.stsUpdTm = value;
    }

    /**
     * Gets the value of the instgAgt property.
     * 
     * @return
     *     possible object is
     *     {@link Agent }
     *     
     */
    public Agent getInstgAgt() {
        return instgAgt;
    }

    /**
     * Sets the value of the instgAgt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Agent }
     *     
     */
    public void setInstgAgt(Agent value) {
        this.instgAgt = value;
    }

}
