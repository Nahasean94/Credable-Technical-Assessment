package com.credable.service;

import com.credable.external.rest.mock_data.score.ScoreData;
import com.credable.external.rest.mock_data.score.ScoreObj;
import com.credable.external.rest.scoring.ScoringService;
import com.credable.model.LoanRequestStatus;
import com.credable.model.LoanStatus;
import com.credable.repository.loan.ILoanRepository;
import com.credable.repository.loan.LoanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.credable.model.LoanRequestStatus.APPROVED;
import static com.credable.model.LoanStatus.ACTIVE;


@Service
public class LoanService {

    private final ILoanRepository loanRepository;

    private final ScoreData scoreData = new ScoreData();

    @Autowired
    ScoringService scoringService;

    @Autowired
    public LoanService(ILoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<LoanEntity> findLoanByCustomerNumber(String customerNumber) {
        return loanRepository.findLoansByCustomerNumber((customerNumber));
    }

    public LoanEntity findByCustomerNumberAndStatus(String loanId, LoanRequestStatus status) {
        return loanRepository.findByCustomerNumberAndStatus(loanId, status);
    }

    public LoanEntity saveLoan(LoanEntity loan) {

        return loanRepository.save(loan);
    }

    @Async
    public void processLoanRequest(LoanEntity loan) {
        //get client token
        String token = scoringService.initiateQueryScore(loan.getCustomerNumber());

        // get score
        ScoreObj score = queryScore(loan, token);
//check score exclusion
        if (score == null) {
            //TODO send notification that they have a credit score
            return;
        }
        if (!Objects.equals(score.getExclusion(), "No Exclusion")) {
            //TODO send notification that they do not qualify for a loan
            return;
        }

        //Check if the user already has an active loan, if so, check from score whether they can take a new loan
        Double loanAmount =
                loanRepository.sumLoanAmountByCustomerNumberAndStatusAndLoanRequestStatus(loan.getCustomerNumber(),
                        ACTIVE, APPROVED);

        double availableLoanAmount = score.getLimitAmount() - loanAmount;

        if (availableLoanAmount < loan.getLoanAmount()) {
            //TODO send notification that they have exceeded loan limit
            return;
        }
//update the loan status
        loanRepository.updateLoanStatusById(loan.getId(), ACTIVE, APPROVED);
        //TODO send notification

    }

    public Optional<LoanEntity> getLoanStatus(Long id) {
        return loanRepository.findById(id);
    }

    public Double sumLoanAmountByCustomerNumberAndStatusAndLoanRequestStatus(
            String customerNumber, LoanStatus status, LoanRequestStatus loanRequestStatus) {
        return loanRepository.sumLoanAmountByCustomerNumberAndStatusAndLoanRequestStatus(customerNumber, status, loanRequestStatus);
    }

    private ScoreObj queryScore(LoanEntity loan, String token) {

        ScoreObj scoreObj = scoringService.queryScore(token);
        if (scoreObj == null) {
            if (loan.getRetries() <= 3) {
                //update retries in the db
                LoanEntity updatedLoan = loanRepository.incrementRetrialsAndReturn(loan.getId());
                queryScore(updatedLoan, token);
            } else {
                return null;
            }
        }
        return scoreObj;
    }


}
