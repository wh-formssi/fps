//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.23 at 11:11:48 上午 CST 
//


package com.forms.ffp.adaptor.jaxb.participant.response.ffprri01;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FPSPARTICIPANTID complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FPSPARTICIPANTID">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BICCODE" type="{}BICFIIdentifier" minOccurs="0"/>
 *         &lt;element name="ID" type="{}UpperCaseNumericText_Exact3" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FPSPARTICIPANTID", namespace = "http://www.formssi.com/response/ffprri01", propOrder = {
    "biccode",
    "id"
})
public class FPSPARTICIPANTID {

    @XmlElement(name = "BICCODE")
    protected String biccode;
    @XmlElement(name = "ID")
    protected String id;

    /**
     * Gets the value of the biccode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBICCODE() {
        return biccode;
    }

    /**
     * Sets the value of the biccode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBICCODE(String value) {
        this.biccode = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
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
    public void setID(String value) {
        this.id = value;
    }

}
