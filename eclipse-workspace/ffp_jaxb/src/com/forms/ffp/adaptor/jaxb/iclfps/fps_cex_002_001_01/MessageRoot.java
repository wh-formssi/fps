//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.30 at 11:51:13 ���� CST 
//


package com.forms.ffp.adaptor.jaxb.iclfps.fps_cex_002_001_01;

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
 *         &lt;element name="GrpHdr" type="{urn:hkicl:fps:xsd:fps.cex.002.001.01}GroupHeader"/>
 *         &lt;element name="MsgRjct" type="{urn:hkicl:fps:xsd:fps.cex.002.001.01}MessageRejected" minOccurs="0"/>
 *         &lt;element name="MsgAcpt" type="{urn:hkicl:fps:xsd:fps.cex.002.001.01}MessageAccepted" minOccurs="0"/>
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
    "msgRjct",
    "msgAcpt"
})
public class MessageRoot {

    @XmlElement(name = "GrpHdr", required = true)
    protected GroupHeader grpHdr;
    @XmlElement(name = "MsgRjct")
    protected MessageRejected msgRjct;
    @XmlElement(name = "MsgAcpt")
    protected MessageAccepted msgAcpt;

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
     * Gets the value of the msgRjct property.
     * 
     * @return
     *     possible object is
     *     {@link MessageRejected }
     *     
     */
    public MessageRejected getMsgRjct() {
        return msgRjct;
    }

    /**
     * Sets the value of the msgRjct property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageRejected }
     *     
     */
    public void setMsgRjct(MessageRejected value) {
        this.msgRjct = value;
    }

    /**
     * Gets the value of the msgAcpt property.
     * 
     * @return
     *     possible object is
     *     {@link MessageAccepted }
     *     
     */
    public MessageAccepted getMsgAcpt() {
        return msgAcpt;
    }

    /**
     * Sets the value of the msgAcpt property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageAccepted }
     *     
     */
    public void setMsgAcpt(MessageAccepted value) {
        this.msgAcpt = value;
    }

}
