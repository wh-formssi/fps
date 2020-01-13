//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.30 at 11:51:13 ���� CST 
//


package com.forms.ffp.adaptor.jaxb.iclfps.pacs_002_001_08;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.forms.ffp.adaptor.jaxb.iclfps.pacs_002_001_08 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Document_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:pacs.002.001.08", "Document");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.forms.ffp.adaptor.jaxb.iclfps.pacs_002_001_08
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OriginalTransactionReference241 }
     * 
     */
    public OriginalTransactionReference241 createOriginalTransactionReference241() {
        return new OriginalTransactionReference241();
    }

    /**
     * Create an instance of {@link FIToFIPaymentStatusReportV08 }
     * 
     */
    public FIToFIPaymentStatusReportV08 createFIToFIPaymentStatusReportV08() {
        return new FIToFIPaymentStatusReportV08();
    }

    /**
     * Create an instance of {@link Document }
     * 
     */
    public Document createDocument() {
        return new Document();
    }

    /**
     * Create an instance of {@link GroupHeader531 }
     * 
     */
    public GroupHeader531 createGroupHeader531() {
        return new GroupHeader531();
    }

    /**
     * Create an instance of {@link StatusReasonInformation91 }
     * 
     */
    public StatusReasonInformation91 createStatusReasonInformation91() {
        return new StatusReasonInformation91();
    }

    /**
     * Create an instance of {@link StatusReasonInformation92 }
     * 
     */
    public StatusReasonInformation92 createStatusReasonInformation92() {
        return new StatusReasonInformation92();
    }

    /**
     * Create an instance of {@link Restricted15Digit2DecimalCurrencyAndAmount }
     * 
     */
    public Restricted15Digit2DecimalCurrencyAndAmount createRestricted15Digit2DecimalCurrencyAndAmount() {
        return new Restricted15Digit2DecimalCurrencyAndAmount();
    }

    /**
     * Create an instance of {@link StatusReason6Choice1 }
     * 
     */
    public StatusReason6Choice1 createStatusReason6Choice1() {
        return new StatusReason6Choice1();
    }

    /**
     * Create an instance of {@link OriginalGroupHeader71 }
     * 
     */
    public OriginalGroupHeader71 createOriginalGroupHeader71() {
        return new OriginalGroupHeader71();
    }

    /**
     * Create an instance of {@link PaymentTransaction801 }
     * 
     */
    public PaymentTransaction801 createPaymentTransaction801() {
        return new PaymentTransaction801();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Document }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.002.001.08", name = "Document")
    public JAXBElement<Document> createDocument(Document value) {
        return new JAXBElement<Document>(_Document_QNAME, Document.class, null, value);
    }

}
