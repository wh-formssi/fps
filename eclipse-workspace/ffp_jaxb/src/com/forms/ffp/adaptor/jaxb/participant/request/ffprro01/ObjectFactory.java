//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.04.24 at 05:43:53 下午 CST 
//


package com.forms.ffp.adaptor.jaxb.participant.request.ffprro01;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.forms.ffp.adaptor.jaxb.participant.request.ffprro01 package. 
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

    private final static QName _BODY_QNAME = new QName("", "BODY");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.forms.ffp.adaptor.jaxb.participant.request.ffprro01
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FFPRRO01 }
     * 
     */
    public FFPRRO01 createFFPRRO01() {
        return new FFPRRO01();
    }

    /**
     * Create an instance of {@link FPSPARTICIPANTID }
     * 
     */
    public FPSPARTICIPANTID createFPSPARTICIPANTID() {
        return new FPSPARTICIPANTID();
    }

    /**
     * Create an instance of {@link RTRRSNINF }
     * 
     */
    public RTRRSNINF createRTRRSNINF() {
        return new RTRRSNINF();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FFPRRO01 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "BODY")
    public JAXBElement<FFPRRO01> createBODY(FFPRRO01 value) {
        return new JAXBElement<FFPRRO01>(_BODY_QNAME, FFPRRO01 .class, null, value);
    }

}
