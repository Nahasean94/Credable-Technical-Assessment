package com.credable.model;

import com.credable.external.rest.mock_data.score.ScoreObj;
import com.credable.repository.loan.LoanEntity;
import lombok.Data;

@Data
public class CustomerLoanResponse {
    private String status;
    private String message;
    private LoanEntity data;
}
