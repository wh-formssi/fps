//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.18 at 11:11:46 上午 CST 
//


package com.forms.ffp.adaptor.jaxb.participant.response.ffpenq01;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ACCOUNTSUMMARY complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ACCOUNTSUMMARY">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CusId" type="{}RestrictedFINZText_Max34"/>
 *         &lt;element name="AcNo" type="{}RestrictedFINZText_Max34"/>
 *         &lt;element name="AcTp" type="{}UpperCaseNumericText_Exact4" minOccurs="0"/>
 *         &lt;element name="AcCur" type="{}UpperCaseNumericText_Exact10" minOccurs="0"/>
 *         &lt;element name="SrvcTp" type="{}servicetype" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ACCOUNTSUMMARY",namespace = "http://www.formssi.com/response/ffpenq01", propOrder = {
    "cusId",
    "acNo",
    "acTp",
    "acCur",
    "srvcTp"
})
public class ACCOUNTSUMMARY {

    @XmlElement(name = "CusId", required = true)
    protected String cusId;
    @XmlElement(name = "AcNo", required = true)
    protected String acNo;
    @XmlElement(name = "AcTp")
    protected String acTp;
    @XmlElement(name = "AcCur")
    protected String acCur;
    @XmlElement(name = "SrvcTp")
    protected Servicetype srvcTp;

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
     * Gets the value of the acNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcNo() {
        return acNo;
    }

    /**
     * Sets the value of the acNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcNo(String value) {
        this.acNo = value;
    }

    /**
     * Gets the value of the acTp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcTp() {
        return acTp;
    }

    /**
     * Sets the value of the acTp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcTp(String value) {
        this.acTp = value;
    }

    /**
     * Gets the value of the acCur property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcCur() {
        return acCur;
    }

    /**
     * Sets the value of the acCur property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcCur(String value) {
        this.acCur = value;
    }

    /**
     * Gets the value of the srvcTp property.
     * 
     * @return
     *     possible object is
     *     {@link Servicetype }
     *     
     */
    public Servicetype getSrvcTp() {
        return srvcTp;
    }

    /**
     * Sets the value of the srvcTp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Servicetype }
     *     
     */
    public void setSrvcTp(Servicetype value) {
        this.srvcTp = value;
    }

}
