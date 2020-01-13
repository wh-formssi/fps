//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.30 at 11:51:13 ���� CST 
//


package com.forms.ffp.adaptor.jaxb.iclfps.camt_056_001_06;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.forms.ffp.adaptor.jaxb.iclfps.camt_056_001_06 package. 
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

    private final static QName _Document_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:camt.056.001.06", "Document");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.forms.ffp.adaptor.jaxb.iclfps.camt_056_001_06
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FIToFIPaymentCancellationRequestV06 }
     * 
     */
    public FIToFIPaymentCancellationRequestV06 createFIToFIPaymentCancellationRequestV06() {
        return new FIToFIPaymentCancellationRequestV06();
    }

    /**
     * Create an instance of {@link FinancialInstitutionIdentification81 }
     * 
     */
    public FinancialInstitutionIdentification81 createFinancialInstitutionIdentification81() {
        return new FinancialInstitutionIdentification81();
    }

    /**
     * Create an instance of {@link BranchAndFinancialInstitutionIdentification51 }
     * 
     */
    public BranchAndFinancialInstitutionIdentification51 createBranchAndFinancialInstitutionIdentification51() {
        return new BranchAndFinancialInstitutionIdentification51();
    }

    /**
     * Create an instance of {@link ClearingSystemMemberIdentification21 }
     * 
     */
    public ClearingSystemMemberIdentification21 createClearingSystemMemberIdentification21() {
        return new ClearingSystemMemberIdentification21();
    }

    /**
     * Create an instance of {@link Document }
     * 
     */
    public Document createDocument() {
        return new Document();
    }

    /**
     * Create an instance of {@link CancellationReason33Choice1 }
     * 
     */
    public CancellationReason33Choice1 createCancellationReason33Choice1() {
        return new CancellationReason33Choice1();
    }

    /**
     * Create an instance of {@link PaymentCancellationReason31 }
     * 
     */
    public PaymentCancellationReason31 createPaymentCancellationReason31() {
        return new PaymentCancellationReason31();
    }

    /**
     * Create an instance of {@link UnderlyingTransaction161 }
     * 
     */
    public UnderlyingTransaction161 createUnderlyingTransaction161() {
        return new UnderlyingTransaction161();
    }

    /**
     * Create an instance of {@link PaymentTransaction751 }
     * 
     */
    public PaymentTransaction751 createPaymentTransaction751() {
        return new PaymentTransaction751();
    }

    /**
     * Create an instance of {@link CaseAssignment31 }
     * 
     */
    public CaseAssignment31 createCaseAssignment31() {
        return new CaseAssignment31();
    }

    /**
     * Create an instance of {@link Party12Choice1 }
     * 
     */
    public Party12Choice1 createParty12Choice1() {
        return new Party12Choice1();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Document }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:camt.056.001.06", name = "Document")
    public JAXBElement<Document> createDocument(Document value) {
        return new JAXBElement<Document>(_Document_QNAME, Document.class, null, value);
    }

}
