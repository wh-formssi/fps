//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.18 at 11:11:46 上午 CST 
//


package com.forms.ffp.adaptor.jaxb.participant.response.ffpenq01;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.forms.ffp.adaptor.jaxb.participant.response.BODY;


/**
 * <p>Java class for FFPENQ01 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FFPENQ01">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SrcRefNm" type="{}RestrictedFINZText_Max30"/>
 *         &lt;element name="ProxyId" type="{}RestrictedFINZText_Max34"/>
 *         &lt;element name="ProxyIdTp" type="{}UpperCaseNumericText_Exact4"/>
 *         &lt;element name="NoOfAc" type="{}Noofaddress"/>
 *         &lt;element name="AcInf" type="{}ACCOUNTSUMMARY" maxOccurs="50" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FFPENQ01", propOrder = {
    "srcRefNm",
    "proxyId",
    "proxyIdTp",
    "noOfAc",
    "acInf"
})
public class FFPENQ01 extends BODY{

    @XmlElement(name = "SrcRefNm", required = true)
    protected String srcRefNm;
    @XmlElement(name = "ProxyId", required = true)
    protected String proxyId;
    @XmlElement(name = "ProxyIdTp", required = true)
    protected String proxyIdTp;
    @XmlElement(name = "NoOfAc", required = true)
    protected String noOfAc;
    @XmlElement(name = "AcInf")
    protected List<ACCOUNTSUMMARY> acInf;

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

    /**
     * Gets the value of the noOfAc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoOfAc() {
        return noOfAc;
    }

    /**
     * Sets the value of the noOfAc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoOfAc(String value) {
        this.noOfAc = value;
    }

    /**
     * Gets the value of the acInf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the acInf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAcInf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ACCOUNTSUMMARY }
     * 
     * 
     */
    public List<ACCOUNTSUMMARY> getAcInf() {
        if (acInf == null) {
            acInf = new ArrayList<ACCOUNTSUMMARY>();
        }
        return this.acInf;
    }

}
