//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.30 at 11:51:13 ���� CST 
//


package com.forms.ffp.adaptor.jaxb.iclfps.pain_009_001_05;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MandateInitiationRequestV05 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MandateInitiationRequestV05">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GrpHdr" type="{urn:iso:std:iso:20022:tech:xsd:pain.009.001.05}GroupHeader47__1"/>
 *         &lt;element name="Mndt" type="{urn:iso:std:iso:20022:tech:xsd:pain.009.001.05}Mandate10__1" maxOccurs="10000"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MandateInitiationRequestV05", propOrder = {
    "grpHdr",
    "mndt"
})
public class MandateInitiationRequestV05 {

    @XmlElement(name = "GrpHdr", required = true)
    protected GroupHeader471 grpHdr;
    @XmlElement(name = "Mndt", required = true)
    protected List<Mandate101> mndt;

    /**
     * Gets the value of the grpHdr property.
     * 
     * @return
     *     possible object is
     *     {@link GroupHeader471 }
     *     
     */
    public GroupHeader471 getGrpHdr() {
        return grpHdr;
    }

    /**
     * Sets the value of the grpHdr property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupHeader471 }
     *     
     */
    public void setGrpHdr(GroupHeader471 value) {
        this.grpHdr = value;
    }

    /**
     * Gets the value of the mndt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mndt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMndt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Mandate101 }
     * 
     * 
     */
    public List<Mandate101> getMndt() {
        if (mndt == null) {
            mndt = new ArrayList<Mandate101>();
        }
        return this.mndt;
    }

}
