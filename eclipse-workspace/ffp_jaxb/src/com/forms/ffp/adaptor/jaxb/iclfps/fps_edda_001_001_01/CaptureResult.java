//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.30 at 11:51:13 ���� CST 
//


package com.forms.ffp.adaptor.jaxb.iclfps.fps_edda_001_001_01;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CaptureResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CaptureResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Accptd" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="RjctRsn" type="{urn:hkicl:fps:xsd:fps.edda.001.001.01}RejectReason" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CaptureResult", propOrder = {
    "accptd",
    "rjctRsn"
})
public class CaptureResult {

    @XmlElement(name = "Accptd")
    protected boolean accptd;
    @XmlElement(name = "RjctRsn")
    protected RejectReason rjctRsn;

    /**
     * Gets the value of the accptd property.
     * 
     */
    public boolean isAccptd() {
        return accptd;
    }

    /**
     * Sets the value of the accptd property.
     * 
     */
    public void setAccptd(boolean value) {
        this.accptd = value;
    }

    /**
     * Gets the value of the rjctRsn property.
     * 
     * @return
     *     possible object is
     *     {@link RejectReason }
     *     
     */
    public RejectReason getRjctRsn() {
        return rjctRsn;
    }

    /**
     * Sets the value of the rjctRsn property.
     * 
     * @param value
     *     allowed object is
     *     {@link RejectReason }
     *     
     */
    public void setRjctRsn(RejectReason value) {
        this.rjctRsn = value;
    }

}
