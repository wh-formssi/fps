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
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PaymentTransaction76__1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentTransaction76__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RtrId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.07}RestrictedFINZMax35Text"/>
 *         &lt;element name="OrgnlInstrId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.07}RestrictedFINZMax35Text" minOccurs="0"/>
 *         &lt;element name="OrgnlEndToEndId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.07}RestrictedFINZMax35Text"/>
 *         &lt;element name="OrgnlTxId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.07}RestrictedFINZMax35Text"/>
 *         &lt;element name="OrgnlClrSysRef" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.07}RestrictedFINZMax35Text"/>
 *         &lt;element name="RtrdIntrBkSttlmAmt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.07}Restricted15Digit2DecimalCurrencyAndAmount"/>
 *         &lt;element name="IntrBkSttlmDt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.07}ISODate" minOccurs="0"/>
 *         &lt;element name="RtrdInstdAmt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.07}Restricted15Digit2DecimalCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="ChrgBr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.07}ChargeBearerType1Code__1" minOccurs="0"/>
 *         &lt;element name="ChrgsInf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.07}Charges2__1" minOccurs="0"/>
 *         &lt;element name="RtrRsnInf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.07}PaymentReturnReason1__1"/>
 *         &lt;element name="OrgnlTxRef" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.07}OriginalTransactionReference24__1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentTransaction76__1", propOrder = {
    "rtrId",
    "orgnlInstrId",
    "orgnlEndToEndId",
    "orgnlTxId",
    "orgnlClrSysRef",
    "rtrdIntrBkSttlmAmt",
    "intrBkSttlmDt",
    "rtrdInstdAmt",
    "chrgBr",
    "chrgsInf",
    "rtrRsnInf",
    "orgnlTxRef"
})
public class PaymentTransaction761 {

    @XmlElement(name = "RtrId", required = true)
    protected String rtrId;
    @XmlElement(name = "OrgnlInstrId")
    protected String orgnlInstrId;
    @XmlElement(name = "OrgnlEndToEndId", required = true)
    protected String orgnlEndToEndId;
    @XmlElement(name = "OrgnlTxId", required = true)
    protected String orgnlTxId;
    @XmlElement(name = "OrgnlClrSysRef", required = true)
    protected String orgnlClrSysRef;
    @XmlElement(name = "RtrdIntrBkSttlmAmt", required = true)
    protected Restricted15Digit2DecimalCurrencyAndAmount rtrdIntrBkSttlmAmt;
    @XmlElement(name = "IntrBkSttlmDt")
    protected XMLGregorianCalendar intrBkSttlmDt;
    @XmlElement(name = "RtrdInstdAmt")
    protected Restricted15Digit2DecimalCurrencyAndAmount rtrdInstdAmt;
    @XmlElement(name = "ChrgBr")
    protected ChargeBearerType1Code1 chrgBr;
    @XmlElement(name = "ChrgsInf")
    protected Charges21 chrgsInf;
    @XmlElement(name = "RtrRsnInf", required = true)
    protected PaymentReturnReason11 rtrRsnInf;
    @XmlElement(name = "OrgnlTxRef", required = true)
    protected OriginalTransactionReference241 orgnlTxRef;

    /**
     * Gets the value of the rtrId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRtrId() {
        return rtrId;
    }

    /**
     * Sets the value of the rtrId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRtrId(String value) {
        this.rtrId = value;
    }

    /**
     * Gets the value of the orgnlInstrId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlInstrId() {
        return orgnlInstrId;
    }

    /**
     * Sets the value of the orgnlInstrId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlInstrId(String value) {
        this.orgnlInstrId = value;
    }

    /**
     * Gets the value of the orgnlEndToEndId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlEndToEndId() {
        return orgnlEndToEndId;
    }

    /**
     * Sets the value of the orgnlEndToEndId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlEndToEndId(String value) {
        this.orgnlEndToEndId = value;
    }

    /**
     * Gets the value of the orgnlTxId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlTxId() {
        return orgnlTxId;
    }

    /**
     * Sets the value of the orgnlTxId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlTxId(String value) {
        this.orgnlTxId = value;
    }

    /**
     * Gets the value of the orgnlClrSysRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlClrSysRef() {
        return orgnlClrSysRef;
    }

    /**
     * Sets the value of the orgnlClrSysRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlClrSysRef(String value) {
        this.orgnlClrSysRef = value;
    }

    /**
     * Gets the value of the rtrdIntrBkSttlmAmt property.
     * 
     * @return
     *     possible object is
     *     {@link Restricted15Digit2DecimalCurrencyAndAmount }
     *     
     */
    public Restricted15Digit2DecimalCurrencyAndAmount getRtrdIntrBkSttlmAmt() {
        return rtrdIntrBkSttlmAmt;
    }

    /**
     * Sets the value of the rtrdIntrBkSttlmAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Restricted15Digit2DecimalCurrencyAndAmount }
     *     
     */
    public void setRtrdIntrBkSttlmAmt(Restricted15Digit2DecimalCurrencyAndAmount value) {
        this.rtrdIntrBkSttlmAmt = value;
    }

    /**
     * Gets the value of the intrBkSttlmDt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIntrBkSttlmDt() {
        return intrBkSttlmDt;
    }

    /**
     * Sets the value of the intrBkSttlmDt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIntrBkSttlmDt(XMLGregorianCalendar value) {
        this.intrBkSttlmDt = value;
    }

    /**
     * Gets the value of the rtrdInstdAmt property.
     * 
     * @return
     *     possible object is
     *     {@link Restricted15Digit2DecimalCurrencyAndAmount }
     *     
     */
    public Restricted15Digit2DecimalCurrencyAndAmount getRtrdInstdAmt() {
        return rtrdInstdAmt;
    }

    /**
     * Sets the value of the rtrdInstdAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Restricted15Digit2DecimalCurrencyAndAmount }
     *     
     */
    public void setRtrdInstdAmt(Restricted15Digit2DecimalCurrencyAndAmount value) {
        this.rtrdInstdAmt = value;
    }

    /**
     * Gets the value of the chrgBr property.
     * 
     * @return
     *     possible object is
     *     {@link ChargeBearerType1Code1 }
     *     
     */
    public ChargeBearerType1Code1 getChrgBr() {
        return chrgBr;
    }

    /**
     * Sets the value of the chrgBr property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeBearerType1Code1 }
     *     
     */
    public void setChrgBr(ChargeBearerType1Code1 value) {
        this.chrgBr = value;
    }

    /**
     * Gets the value of the chrgsInf property.
     * 
     * @return
     *     possible object is
     *     {@link Charges21 }
     *     
     */
    public Charges21 getChrgsInf() {
        return chrgsInf;
    }

    /**
     * Sets the value of the chrgsInf property.
     * 
     * @param value
     *     allowed object is
     *     {@link Charges21 }
     *     
     */
    public void setChrgsInf(Charges21 value) {
        this.chrgsInf = value;
    }

    /**
     * Gets the value of the rtrRsnInf property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentReturnReason11 }
     *     
     */
    public PaymentReturnReason11 getRtrRsnInf() {
        return rtrRsnInf;
    }

    /**
     * Sets the value of the rtrRsnInf property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentReturnReason11 }
     *     
     */
    public void setRtrRsnInf(PaymentReturnReason11 value) {
        this.rtrRsnInf = value;
    }

    /**
     * Gets the value of the orgnlTxRef property.
     * 
     * @return
     *     possible object is
     *     {@link OriginalTransactionReference241 }
     *     
     */
    public OriginalTransactionReference241 getOrgnlTxRef() {
        return orgnlTxRef;
    }

    /**
     * Sets the value of the orgnlTxRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalTransactionReference241 }
     *     
     */
    public void setOrgnlTxRef(OriginalTransactionReference241 value) {
        this.orgnlTxRef = value;
    }

}
