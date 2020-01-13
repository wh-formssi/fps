//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.04.13 at 02:09:05 下午 CST 
//


package com.forms.ffp.adaptor.jaxb.participant.response.ffpadr03;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for SUMMARYTYPE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SUMMARYTYPE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CusNm" type="{}CUSTOMERNAMETYPE" maxOccurs="2"/>
 *         &lt;element name="MmbId" type="{}MmbIdType"/>
 *         &lt;element name="DefInd" type="{}defaultInd"/>
 *         &lt;element name="PurpCd" type="{}UpperCaseNumericText_Exact4"/>
 *         &lt;element name="CreDtTm" type="{}DateTimeType"/>
 *         &lt;element name="LstUpdDtTm" type="{}DateTimeType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUMMARYTYPE",namespace = "http://www.formssi.com/response/ffpadr03", propOrder = {
    "cusNm",
    "mmbId",
    "defInd",
    "purpCd",
    "creDtTm",
    "lstUpdDtTm"
})
public class SUMMARYTYPE {

    @XmlElement(name = "CusNm", required = true)
    protected List<CUSTOMERNAMETYPE> cusNm;
    @XmlElement(name = "MmbId", required = true)
    protected String mmbId;
    @XmlElement(name = "DefInd", required = true)
    protected DefaultInd defInd;
    @XmlElement(name = "PurpCd", required = true)
    protected String purpCd;
    @XmlElement(name = "CreDtTm", required = true)
    protected XMLGregorianCalendar creDtTm;
    @XmlElement(name = "LstUpdDtTm", required = true)
    protected XMLGregorianCalendar lstUpdDtTm;

    /**
     * Gets the value of the cusNm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cusNm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCusNm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CUSTOMERNAMETYPE }
     * 
     * 
     */
    public List<CUSTOMERNAMETYPE> getCusNm() {
        if (cusNm == null) {
            cusNm = new ArrayList<CUSTOMERNAMETYPE>();
        }
        return this.cusNm;
    }

    /**
     * Gets the value of the mmbId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMmbId() {
        return mmbId;
    }

    /**
     * Sets the value of the mmbId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMmbId(String value) {
        this.mmbId = value;
    }

    /**
     * Gets the value of the defInd property.
     * 
     * @return
     *     possible object is
     *     {@link DefaultInd }
     *     
     */
    public DefaultInd getDefInd() {
        return defInd;
    }

    /**
     * Sets the value of the defInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link DefaultInd }
     *     
     */
    public void setDefInd(DefaultInd value) {
        this.defInd = value;
    }

    /**
     * Gets the value of the purpCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurpCd() {
        return purpCd;
    }

    /**
     * Sets the value of the purpCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurpCd(String value) {
        this.purpCd = value;
    }

    /**
     * Gets the value of the creDtTm property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreDtTm() {
        return creDtTm;
    }

    /**
     * Sets the value of the creDtTm property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreDtTm(XMLGregorianCalendar value) {
        this.creDtTm = value;
    }

    /**
     * Gets the value of the lstUpdDtTm property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLstUpdDtTm() {
        return lstUpdDtTm;
    }

    /**
     * Sets the value of the lstUpdDtTm property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLstUpdDtTm(XMLGregorianCalendar value) {
        this.lstUpdDtTm = value;
    }

}
