//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.04.10 at 02:39:57 下午 CST 
//


package com.forms.ffp.adaptor.jaxb.participant.response.ffpamr01;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UNDRLYGDTLSTYPE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UNDRLYGDTLSTYPE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SrcRefNm" type="{}RestrictedFINZText_Max30"/>
 *         &lt;element name="Sts" type="{}Exact4UpperCaseText"/>
 *         &lt;element name="RsnInfCd" type="{}RestrictedNZText_Max8" minOccurs="0"/>
 *         &lt;element name="ProxyId" type="{}RestrictedFINZText_Max34" minOccurs="0"/>
 *         &lt;element name="ProxyIdTp" type="{}UpperCaseNumericText_Exact4"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UNDRLYGDTLSTYPE", namespace = "http://www.formssi.com/response/ffpamr01", propOrder = {
    "srcRefNm",
    "sts",
    "rsnInfCd",
    "proxyId",
    "proxyIdTp"
})
public class UNDRLYGDTLSTYPE {

    @XmlElement(name = "SrcRefNm", required = true)
    protected String srcRefNm;
    @XmlElement(name = "Sts", required = true)
    protected String sts;
    @XmlElement(name = "RsnInfCd")
    protected String rsnInfCd;
    @XmlElement(name = "ProxyId")
    protected String proxyId;
    @XmlElement(name = "ProxyIdTp", required = true)
    protected String proxyIdTp;

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
     * Gets the value of the sts property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSts() {
        return sts;
    }

    /**
     * Sets the value of the sts property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSts(String value) {
        this.sts = value;
    }

    /**
     * Gets the value of the rsnInfCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRsnInfCd() {
        return rsnInfCd;
    }

    /**
     * Sets the value of the rsnInfCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRsnInfCd(String value) {
        this.rsnInfCd = value;
    }

    /**
     * Gets the value of the proxyId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProxyId() {
        return proxyId;
    }

    /**
     * Sets the value of the proxyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProxyId(String value) {
        this.proxyId = value;
    }

    /**
     * Gets the value of the proxyIdTp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProxyIdTp() {
        return proxyIdTp;
    }

    /**
     * Sets the value of the proxyIdTp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProxyIdTp(String value) {
        this.proxyIdTp = value;
    }

}