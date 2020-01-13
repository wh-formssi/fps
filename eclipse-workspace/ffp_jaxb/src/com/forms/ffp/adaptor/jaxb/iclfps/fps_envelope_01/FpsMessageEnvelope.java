//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.30 at 11:51:13 ���� CST 
//


package com.forms.ffp.adaptor.jaxb.iclfps.fps_envelope_01;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.forms.ffp.adaptor.jaxb.iclfps.xmldsig.SignatureType;


/**
 * <p>Java class for FpsMessageEnvelope complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FpsMessageEnvelope">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BtchInf" type="{urn:hkicl:fps:xsd:fps.envelope.01}BatchInformation" minOccurs="0"/>
 *         &lt;element name="NbOfMsgs" type="{urn:hkicl:fps:xsd:fps.envelope.01}Max15NumericText"/>
 *         &lt;element name="FpsPylds" type="{urn:hkicl:fps:xsd:fps.envelope.01}FpsMessagePayloads" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FpsMessageEnvelope", propOrder = {
    "btchInf",
    "nbOfMsgs",
    "fpsPylds",
    "signature"
})
public class FpsMessageEnvelope {

    @XmlElement(name = "BtchInf")
    protected BatchInformation btchInf;
    @XmlElement(name = "NbOfMsgs", required = true)
    protected String nbOfMsgs;
    @XmlElement(name = "FpsPylds")
    protected FpsMessagePayloads fpsPylds;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#", required = true)
    protected SignatureType signature;

    /**
     * Gets the value of the btchInf property.
     * 
     * @return
     *     possible object is
     *     {@link BatchInformation }
     *     
     */
    public BatchInformation getBtchInf() {
        return btchInf;
    }

    /**
     * Sets the value of the btchInf property.
     * 
     * @param value
     *     allowed object is
     *     {@link BatchInformation }
     *     
     */
    public void setBtchInf(BatchInformation value) {
        this.btchInf = value;
    }

    /**
     * Gets the value of the nbOfMsgs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNbOfMsgs() {
        return nbOfMsgs;
    }

    /**
     * Sets the value of the nbOfMsgs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNbOfMsgs(String value) {
        this.nbOfMsgs = value;
    }

    /**
     * Gets the value of the fpsPylds property.
     * 
     * @return
     *     possible object is
     *     {@link FpsMessagePayloads }
     *     
     */
    public FpsMessagePayloads getFpsPylds() {
        return fpsPylds;
    }

    /**
     * Sets the value of the fpsPylds property.
     * 
     * @param value
     *     allowed object is
     *     {@link FpsMessagePayloads }
     *     
     */
    public void setFpsPylds(FpsMessagePayloads value) {
        this.fpsPylds = value;
    }

    /**
     * Gets the value of the signature property.
     * 
     * @return
     *     possible object is
     *     {@link SignatureType }
     *     
     */
    public SignatureType getSignature() {
        return signature;
    }

    /**
     * Sets the value of the signature property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureType }
     *     
     */
    public void setSignature(SignatureType value) {
        this.signature = value;
    }

}