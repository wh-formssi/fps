//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.30 at 11:51:13 ���� CST 
//


package com.forms.ffp.adaptor.jaxb.iclfps.camt_060_001_03;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.forms.ffp.adaptor.jaxb.iclfps.camt_060_001_03 package. 
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

    private final static QName _Document_QNAME = new QName("urn:iso:std:iso:20022:tech:xsd:camt.060.001.03", "Document");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.forms.ffp.adaptor.jaxb.iclfps.camt_060_001_03
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GroupHeader591 }
     * 
     */
    public GroupHeader591 createGroupHeader591() {
        return new GroupHeader591();
    }

    /**
     * Create an instance of {@link CashAccount241 }
     * 
     */
    public CashAccount241 createCashAccount241() {
        return new CashAccount241();
    }

    /**
     * Create an instance of {@link ReportingRequest31 }
     * 
     */
    public ReportingRequest31 createReportingRequest31() {
        return new ReportingRequest31();
    }

    /**
     * Create an instance of {@link BranchAndFinancialInstitutionIdentification51 }
     * 
     */
    public BranchAndFinancialInstitutionIdentification51 createBranchAndFinancialInstitutionIdentification51() {
        return new BranchAndFinancialInstitutionIdentification51();
    }

    /**
     * Create an instance of {@link AccountIdentification4Choice1 }
     * 
     */
    public AccountIdentification4Choice1 createAccountIdentification4Choice1() {
        return new AccountIdentification4Choice1();
    }

    /**
     * Create an instance of {@link AccountReportingRequestV03 }
     * 
     */
    public AccountReportingRequestV03 createAccountReportingRequestV03() {
        return new AccountReportingRequestV03();
    }

    /**
     * Create an instance of {@link FinancialInstitutionIdentification81 }
     * 
     */
    public FinancialInstitutionIdentification81 createFinancialInstitutionIdentification81() {
        return new FinancialInstitutionIdentification81();
    }

    /**
     * Create an instance of {@link Party12Choice1 }
     * 
     */
    public Party12Choice1 createParty12Choice1() {
        return new Party12Choice1();
    }

    /**
     * Create an instance of {@link GenericAccountIdentification11 }
     * 
     */
    public GenericAccountIdentification11 createGenericAccountIdentification11() {
        return new GenericAccountIdentification11();
    }

    /**
     * Create an instance of {@link Document }
     * 
     */
    public Document createDocument() {
        return new Document();
    }

    /**
     * Create an instance of {@link ClearingSystemMemberIdentification21 }
     * 
     */
    public ClearingSystemMemberIdentification21 createClearingSystemMemberIdentification21() {
        return new ClearingSystemMemberIdentification21();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Document }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:iso:std:iso:20022:tech:xsd:camt.060.001.03", name = "Document")
    public JAXBElement<Document> createDocument(Document value) {
        return new JAXBElement<Document>(_Document_QNAME, Document.class, null, value);
    }

}
