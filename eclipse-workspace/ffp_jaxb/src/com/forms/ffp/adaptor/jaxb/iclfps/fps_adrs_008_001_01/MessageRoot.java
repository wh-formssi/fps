//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.30 at 11:51:13 ���� CST 
//


package com.forms.ffp.adaptor.jaxb.iclfps.fps_adrs_008_001_01;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="GrpHdr" type="{urn:hkicl:fps:xsd:fps.adrs.008.001.01}GroupHeader"/>
 *         &lt;element name="AdrSchme" type="{urn:hkicl:fps:xsd:fps.adrs.008.001.01}AddressingScheme" maxOccurs="50"/>
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
    "adrSchme"
})
public class MessageRoot {

    @XmlElement(name = "GrpHdr", required = true)
    protected GroupHeader grpHdr;
    @XmlElement(name = "AdrSchme", required = true)
    protected List<AddressingScheme> adrSchme;

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
     * Gets the value of the adrSchme property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adrSchme property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdrSchme().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AddressingScheme }
     * 
     * 
     */
    public List<AddressingScheme> getAdrSchme() {
        if (adrSchme == null) {
            adrSchme = new ArrayList<AddressingScheme>();
        }
        return this.adrSchme;
    }

}
