package com.credable.controller;


import com.credable.external.rest.mock_data.score.ScoreData;
import com.credable.model.CustomerLoanRequest;
import com.credable.model.LoanRequestStatus;
import com.credable.model.LoanStatus;
import com.credable.repository.loan.LoanEntity;
import com.credable.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.credable.model.LoanRequestStatus.PENDING;
import static com.credable.model.LoanStatus.INACTIVE;


@RestController
@RequestMapping("/api")
public class LoanController {

    @Autowired
    private LoanService loanService;



    @PostMapping("/v1/loan/request")
    public String requestLoan(@RequestBody CustomerLoanRequest loan) {

       LoanEntity custLoan = loanService.findByCustomerNumberAndStatus(loan.getCustomerNumber(), LoanRequestStatus.PENDING);
        if (custLoan != null) {
            return "You have already requested a loan";
        }
        custLoan = new LoanEntity();
        custLoan.setCustomerNumber(loan.getCustomerNumber());
        custLoan.setLoanAmount(loan.getLoanAmount());
        custLoan.setRetries(0);
        //store the loan request before further processing
        custLoan.setLoanRequestStatus(LoanRequestStatus.PENDING);
        custLoan.setStatus(LoanStatus.INACTIVE);
        loanService.saveLoan(custLoan);
        loanService.processLoanRequest(custLoan);
        return "You have successfully requested a loan";


    }
}
