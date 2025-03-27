package com.credable.external.soap.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;

import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType>
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="customer" type="{http://credable.io/cbs/customer}customer"/>
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
@XmlType(name = "", propOrder = {
    "customer"
})
@XmlRootElement(name = "CustomerResponse", namespace = "http://credable.io/cbs/customer")
public class CustomerResponse {

    @XmlElement(namespace = "http://credable.io/cbs/customer", required = true)
    protected Customer customer;

    public String getCustomerNumber() {
        return this.customer.getCustomerNumber();
    }

    public String getFirstName() {
        return  this.customer.getFirstName();
    }

    public String getLastName() {
        return this.customer.getLastName();
    }

    public String getEmail() {
        return this.customer.getEmail();
    }

    public String getMobile() {
        return this.customer.getMobile();
    }

    public Status getStatus() {
        return this.customer.getStatus();
    }

    public String getIdNumber() {
        return  this.customer.getIdNumber();
    }

    public IdType getIdType() {
        return this.customer.getIdType();
    }

    public Double getMonthlyIncome() {
        return this.customer.getMonthlyIncome();
    }

    public XMLGregorianCalendar getDob() {
        return this.customer.getDob();
    }
}
