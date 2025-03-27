package com.credable.external.soap.wsdl;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 *
 *
 * <p>Java class for gender</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="gender">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="MALE"/>
 *     <enumeration value="FEMALE"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 *
 */
@XmlType(name = "gender", namespace = "http://credable.io/cbs/customer")
@XmlEnum
public enum Gender {

    MALE,
    FEMALE;

    public String value() {
        return name();
    }

    public static Gender fromValue(String v) {
        return valueOf(v);
    }

}
