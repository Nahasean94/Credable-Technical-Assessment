package com.credable.model;


public enum LoanRequestStatus {

    PENDING,APPROVED, REJECTED;

    public String value() {
        return name();
    }

}
