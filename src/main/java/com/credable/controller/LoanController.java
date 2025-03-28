package com.credable.controller;


import com.credable.model.CustomerLoanRequest;
import com.credable.model.CustomerLoanResponse;
import com.credable.model.LoanRequestStatus;
import com.credable.model.LoanStatus;
import com.credable.repository.loan.LoanEntity;
import com.credable.service.LoanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api")
public class LoanController {

    @Autowired
    private LoanService loanService;

    private final CustomerLoanResponse customerLoanResponse = new CustomerLoanResponse();

    @PostMapping(value = "/v1/loan/request", produces = "application/json")
    public CustomerLoanResponse requestLoan(@RequestBody CustomerLoanRequest loan) {
        log.info("Received request for loan {}", loan);
        try {
        LoanEntity custLoan = loanService.findByCustomerNumberAndStatus(loan.getCustomerNumber(), LoanRequestStatus.PENDING);
        if (custLoan != null) {
            log.info("User already has a pending loan request. Please try again later");

            customerLoanResponse.setStatus("failed");
            customerLoanResponse.setMessage("User already has a pending loan request. Please try again later");
            return customerLoanResponse;
        }
        custLoan = new LoanEntity();
        custLoan.setCustomerNumber(loan.getCustomerNumber());
        custLoan.setLoanAmount(loan.getLoanAmount());
        custLoan.setRetries(0);
        custLoan.setLoanRequestStatus(LoanRequestStatus.PENDING);
        custLoan.setStatus(LoanStatus.INACTIVE);
        //store the loan request before further processing
        loanService.saveLoan(custLoan);
        loanService.processLoanRequest(custLoan);
        customerLoanResponse.setStatus("successful");
        customerLoanResponse.setMessage("Successfully requested a loan");
        customerLoanResponse.setData(custLoan);
        log.info("Successfully processed request for a loan {}", custLoan);

        return customerLoanResponse;

    } catch (Exception e) {
        log.error("An error occurred while applying for a loan", e.getCause());
        customerLoanResponse.setStatus("failed");
        customerLoanResponse.setMessage("An error occurred while applying for a loan");
        customerLoanResponse.setData(null);
        return customerLoanResponse;

    }
    }

    @GetMapping(value = "/v1/loan/status/{loanId}", produces = "application/json")
    public CustomerLoanResponse checkLoanStatus(@PathVariable UUID loanId) {
        log.info("Received request to check loan status {}", loanId);
        try {
            Optional<LoanEntity> custLoan = loanService.findById(loanId);
            if (custLoan.isPresent()) {
                customerLoanResponse.setStatus("successful");
                customerLoanResponse.setMessage("Successfully found a loan");
                log.info("Successfully found a loan {}", customerLoanResponse);

            } else {
                customerLoanResponse.setStatus("failed");
                customerLoanResponse.setMessage("Failed to find a loan with that id");
                log.info("Failed to find a loan with that id {}", customerLoanResponse);

            }
            customerLoanResponse.setData(custLoan.orElse(null));


            return customerLoanResponse;
        } catch (Exception e) {
            log.error("An error occurred while checking loan status", e.getCause());
            customerLoanResponse.setStatus("failed");
            customerLoanResponse.setMessage("An error occurred while checking loan status");
            customerLoanResponse.setData(null);
            return customerLoanResponse;

        }

    }
}
