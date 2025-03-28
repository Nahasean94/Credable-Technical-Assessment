package com.credable.model;

import lombok.Data;

@Data
public class CustomerLoanRequest {
    private String customerNumber;
    private Double loanAmount;
}
