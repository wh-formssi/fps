//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.30 at 11:51:13 ���� CST 
//


package com.forms.ffp.adaptor.jaxb.iclfps.fps_admi_001_001_01;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MessageRoot complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MessageRoot">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GrpHdr" type="{urn:hkicl:fps:xsd:fps.admi.001.001.01}GroupHeader"/>
 *         &lt;element name="RcptMd" type="{urn:hkicl:fps:xsd:fps.admi.001.001.01}ReceiptMode"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageRoot", propOrder = {
    "grpHdr",
    "rcptMd"
})
public class MessageRoot {

    @XmlElement(name = "GrpHdr", required = true)
    protected GroupHeader grpHdr;
    @XmlElement(name = "RcptMd", required = true)
    protected ReceiptMode rcptMd;

    /**
     * Gets the value of the grpHdr property.
     * 
     * @return
     *     possible object is
     *     {@link GroupHeader }
     *     
     */
    public GroupHeader getGrpHdr() {
        return grpHdr;
    }

    /**
     * Sets the value of the grpHdr property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupHeader }
     *     
     */
    public void setGrpHdr(GroupHeader value) {
        this.grpHdr = value;
    }

    /**
     * Gets the value of the rcptMd property.
     * 
     * @return
     *     possible object is
     *     {@link ReceiptMode }
     *     
     */
    public ReceiptMode getRcptMd() {
        return rcptMd;
    }

    /**
     * Sets the value of the rcptMd property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReceiptMode }
     *     
     */
    public void setRcptMd(ReceiptMode value) {
        this.rcptMd = value;
    }

}