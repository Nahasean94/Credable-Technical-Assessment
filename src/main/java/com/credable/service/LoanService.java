package com.credable.service;

import com.credable.external.rest.mock_data.score.ScoreObj;
import com.credable.external.rest.scoring.ScoringService;
import com.credable.model.LoanRequestStatus;
import com.credable.model.LoanStatus;
import com.credable.repository.loan.ILoanRepository;
import com.credable.repository.loan.LoanEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class LoanService {

    private final ILoanRepository loanRepository;

    @Autowired
    ScoringService scoringService;

    @Autowired
    public LoanService(ILoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public LoanEntity findByCustomerNumberAndStatus(String loanId, LoanRequestStatus status) {
        return loanRepository.findByCustomerNumberAndStatus(loanId, status);
    }

    public void saveLoan(LoanEntity loan) {
        log.info("About to save loan: {}", loan);

        loanRepository.save(loan);
        log.info("Saved loan record");

    }

    public Optional<LoanEntity> findById(UUID id) {
        log.info("About to find a long by id: {}", id);

        Optional<LoanEntity> loanEntity = loanRepository.findById(id);
        log.info("Found a loan record by id: {}", loanEntity);

        return loanEntity;
    }

    @Async
    public void processLoanRequest(LoanEntity loan) {
        //get client token
        log.info("About to call scoring engine to get token: {}", loan);
        String token = scoringService.initiateQueryScore(loan.getCustomerNumber()).getToken();

        log.info("Obtained token from scoring engine: {}", token);

        // get score
        log.info("About to obtain customer score from scoring engine");

        ScoreObj score = queryScore(loan.getCustomerNumber(), 0);
        log.info("Obtained customer score from scoring engine: {} ", score);

//check score exclusion
        if (score == null) {
            log.info("About to update loan status");

            loanRepository.updateLoanStatusById(loan.getId(), LoanStatus.INACTIVE, LoanRequestStatus.REJECTED);
            //TODO send notification that they have a credit score
            log.info("Updated loan status");

            return;
        }
        if (!Objects.equals(score.getExclusion(), "No Exclusion")) {

            log.info("About to update loan status");
            loanRepository.updateLoanStatusById(loan.getId(), LoanStatus.INACTIVE, LoanRequestStatus.REJECTED);
            //TODO send notification that they do not qualify for a loan
            log.info("Updated loan status ");

            return;
        }

        //Check if the user already has an active loan, if so, check from score whether they can take a new loan
        Double loanAmount =
                loanRepository.sumLoanAmountByCustomerNumberAndStatusAndLoanRequestStatus(loan.getCustomerNumber(),
                        LoanStatus.ACTIVE, LoanRequestStatus.APPROVED);

        double availableLoanAmount = score.getLimitAmount() - loanAmount;

        if (availableLoanAmount < loan.getLoanAmount()) {
            //TODO send notification that they have exceeded loan limit
            return;
        }
//update the loan status
        log.info("About to update loan status");

        loanRepository.updateLoanStatusById(loan.getId(), LoanStatus.ACTIVE, LoanRequestStatus.APPROVED);
        //TODO send notification that the loan application was successful
        log.info("Updated loan status");

    }

    //TODO use an event management system to perform retries
    private ScoreObj queryScore(String token, int retrials) {

        ScoreObj scoreObj = scoringService.queryScore(token);
        if (scoreObj == null) {
            if (retrials <= 2) {
               //Increase the the retrials and retru
                queryScore(token, retrials + 1);
            } else {
                return null;
            }
        }
        System.out.println(scoreObj + " is the score object");
        return scoreObj;
    }


}
