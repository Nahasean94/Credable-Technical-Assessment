package com.credable.model;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


public enum LoanStatus {
    ACTIVE,
    INACTIVE;

    public String value() {
        return name();
    }

    public static LoanStatus fromValue(String v) {
        return valueOf(v);
    }

}


