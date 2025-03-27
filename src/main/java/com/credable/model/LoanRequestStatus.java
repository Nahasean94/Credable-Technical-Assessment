package com.credable.model;


public enum LoanRequestStatus {

    PENDING,APPROVED, REJECTED;

    public String value() {
        return name();
    }

    public static LoanRequestStatus fromValue(String v) {
        return valueOf(v);
    }

}
