//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.30 at 11:51:13 ���� CST 
//


package com.forms.ffp.adaptor.jaxb.iclfps.fps_cex_002_001_01;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RejectedRevokedCertificates complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RejectedRevokedCertificates">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RjctRevokedCert" type="{urn:hkicl:fps:xsd:fps.cex.002.001.01}RejectedCertificate" maxOccurs="10"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RejectedRevokedCertificates", propOrder = {
    "rjctRevokedCert"
})
public class RejectedRevokedCertificates {

    @XmlElement(name = "RjctRevokedCert", required = true)
    protected List<RejectedCertificate> rjctRevokedCert;

    /**
     * Gets the value of the rjctRevokedCert property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rjctRevokedCert property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRjctRevokedCert().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RejectedCertificate }
     * 
     * 
     */
    public List<RejectedCertificate> getRjctRevokedCert() {
        if (rjctRevokedCert == null) {
            rjctRevokedCert = new ArrayList<RejectedCertificate>();
        }
        return this.rjctRevokedCert;
    }

}
