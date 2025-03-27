package com.credable.external.soap.wsdls;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;


/**
 * <p>Java class for customer complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType name="customer">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="createdAt" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         <element name="createdDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         <element name="customerNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="dob" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         <element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="gender" type="{http://credable.io/cbs/customer}gender" minOccurs="0"/>
 *         <element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         <element name="idNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="idType" type="{http://credable.io/cbs/customer}idType" minOccurs="0"/>
 *         <element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="middleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="mobile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="monthlyIncome" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="status" type="{http://credable.io/cbs/customer}status" minOccurs="0"/>
 *         <element name="updatedAt" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customer", namespace = "http://credable.io/cbs/customer", propOrder = {
    "createdAt",
    "createdDate",
    "customerNumber",
    "dob",
    "email",
    "firstName",
    "gender",
    "id",
    "idNumber",
    "idType",
    "lastName",
    "middleName",
    "mobile",
    "monthlyIncome",
    "status",
    "updatedAt"
})
public class Customer {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdAt;

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdDate;

    protected String customerNumber;

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dob;

    protected String email;

    protected String firstName;

    @XmlSchemaType(name = "string")
    protected Gender gender;

    protected Long id;

    protected String idNumber;

    @XmlSchemaType(name = "string")
    protected IdType idType;

    protected String lastName;

    protected String middleName;

    protected String mobile;

    protected double monthlyIncome;

    @XmlSchemaType(name = "string")
    protected Status status;

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updatedAt;

}
