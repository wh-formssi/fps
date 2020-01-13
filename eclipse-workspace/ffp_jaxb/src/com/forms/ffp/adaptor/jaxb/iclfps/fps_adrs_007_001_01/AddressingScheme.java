//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.30 at 11:51:13 ���� CST 
//


package com.forms.ffp.adaptor.jaxb.iclfps.fps_adrs_007_001_01;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="AdrReqId" type="{urn:hkicl:fps:xsd:fps.adrs.007.001.01}Max35Text"/>
 *         &lt;element name="Sts" type="{urn:hkicl:fps:xsd:fps.adrs.007.001.01}Status"/>
 *         &lt;element name="StsRsnInf" type="{urn:hkicl:fps:xsd:fps.adrs.007.001.01}StatusReasonInformation" minOccurs="0"/>
 *         &lt;element name="Id" type="{urn:hkicl:fps:xsd:fps.adrs.007.001.01}Max34Text"/>
 *         &lt;element name="Tp" type="{urn:hkicl:fps:xsd:fps.adrs.007.001.01}ProxyIDType"/>
 *         &lt;element name="NoOfAdr" type="{urn:hkicl:fps:xsd:fps.adrs.007.001.01}Max15NumericText"/>
 *         &lt;element name="Smry" type="{urn:hkicl:fps:xsd:fps.adrs.007.001.01}Summary" maxOccurs="unbounded" minOccurs="0"/>
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
    "adrReqId",
    "sts",
    "stsRsnInf",
    "id",
    "tp",
    "noOfAdr",
    "smry"
})
public class AddressingScheme {

    @XmlElement(name = "AdrReqId", required = true)
    protected String adrReqId;
    @XmlElement(name = "Sts", required = true)
    protected Status sts;
    @XmlElement(name = "StsRsnInf")
    protected StatusReasonInformation stsRsnInf;
    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "Tp", required = true)
    protected ProxyIDType tp;
    @XmlElement(name = "NoOfAdr", required = true)
    protected String noOfAdr;
    @XmlElement(name = "Smry")
    protected List<Summary> smry;

    /**
     * Gets the value of the adrReqId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdrReqId() {
        return adrReqId;
    }

    /**
     * Sets the value of the adrReqId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdrReqId(String value) {
        this.adrReqId = value;
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
     * Gets the value of the stsRsnInf property.
     * 
     * @return
     *     possible object is
     *     {@link StatusReasonInformation }
     *     
     */
    public StatusReasonInformation getStsRsnInf() {
        return stsRsnInf;
    }

    /**
     * Sets the value of the stsRsnInf property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusReasonInformation }
     *     
     */
    public void setStsRsnInf(StatusReasonInformation value) {
        this.stsRsnInf = value;
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
     * Gets the value of the noOfAdr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoOfAdr() {
        return noOfAdr;
    }

    /**
     * Sets the value of the noOfAdr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoOfAdr(String value) {
        this.noOfAdr = value;
    }

    /**
     * Gets the value of the smry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the smry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSmry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Summary }
     * 
     * 
     */
    public List<Summary> getSmry() {
        if (smry == null) {
            smry = new ArrayList<Summary>();
        }
        return this.smry;
    }

}