//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.16 at 02:10:56 ���� CST 
//


package com.forms.ffp.adaptor.jaxb.participant.request.ffpcti02;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.forms.ffp.adaptor.jaxb.participant.request.BODY;


/**
 * <p>Java class for FFPCTI02 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FFPCTI02">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SrcRefNm" type="{}RestrictedNZText_Max30"/>
 *         &lt;element name="CdtrNm" type="{}RestrictedUnicodeTextMax140"/>
 *         &lt;element name="CdtrAcTp" type="{}UpperCaseNumericText_Exact3"/>
 *         &lt;element name="CdtrAcNo" type="{}RestrictedFINZText_Max34"/>
 *         &lt;element name="CdtrContPhone" type="{}PhoneNumber" minOccurs="0"/>
 *         &lt;element name="CdtrContEmailAddr" type="{}RestrictedFINZText_Max254" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FFPCTI02", propOrder = {
    "srcRefNm",
    "cdtrNm",
    "cdtrAcTp",
    "cdtrAcNo",
    "cdtrContPhone",
    "cdtrContEmailAddr"
})
public class FFPCTI02 extends BODY{

    @XmlElement(name = "SrcRefNm", required = true)
    protected String srcRefNm;
    @XmlElement(name = "CdtrNm", required = true)
    protected String cdtrNm;
    @XmlElement(name = "CdtrAcTp", required = true)
    protected String cdtrAcTp;
    @XmlElement(name = "CdtrAcNo", required = true)
    protected String cdtrAcNo;
    @XmlElement(name = "CdtrContPhone")
    protected String cdtrContPhone;
    @XmlElement(name = "CdtrContEmailAddr")
    protected String cdtrContEmailAddr;

    /**
     * Gets the value of the srcRefNm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrcRefNm() {
        return srcRefNm;
    }

    /**
     * Sets the value of the srcRefNm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrcRefNm(String value) {
        this.srcRefNm = value;
    }

    /**
     * Gets the value of the cdtrNm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdtrNm() {
        return cdtrNm;
    }

    /**
     * Sets the value of the cdtrNm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdtrNm(String value) {
        this.cdtrNm = value;
    }

    /**
     * Gets the value of the cdtrAcTp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdtrAcTp() {
        return cdtrAcTp;
    }

    /**
     * Sets the value of the cdtrAcTp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdtrAcTp(String value) {
        this.cdtrAcTp = value;
    }

    /**
     * Gets the value of the cdtrAcNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdtrAcNo() {
        return cdtrAcNo;
    }

    /**
     * Sets the value of the cdtrAcNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdtrAcNo(String value) {
        this.cdtrAcNo = value;
    }

    /**
     * Gets the value of the cdtrContPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdtrContPhone() {
        return cdtrContPhone;
    }

    /**
     * Sets the value of the cdtrContPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdtrContPhone(String value) {
        this.cdtrContPhone = value;
    }

    /**
     * Gets the value of the cdtrContEmailAddr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdtrContEmailAddr() {
        return cdtrContEmailAddr;
    }

    /**
     * Sets the value of the cdtrContEmailAddr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdtrContEmailAddr(String value) {
        this.cdtrContEmailAddr = value;
    }

}