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

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;


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

    public LoanEntity findByCustomerNumberAndStatus(String loanId, LoanRequestStatus status) {
        return loanRepository.findByCustomerNumberAndStatus(loanId, status);
    }

    public void saveLoan(LoanEntity loan) {
        loanRepository.save(loan);
    }

    public Optional<LoanEntity> findById(UUID id) {
       return loanRepository.findById(id);
    }

    @Async
    public void processLoanRequest(LoanEntity loan) {
        //get client token
        String token = scoringService.initiateQueryScore(loan.getCustomerNumber()).getToken();
        System.out.println("Called scoring API found token"+token);

        // get score
        ScoreObj score = queryScore(  loan.getCustomerNumber(),0);
//check score exclusion
        if (score == null) {
            loanRepository.updateLoanStatusById(loan.getId(),LoanStatus.INACTIVE,LoanRequestStatus.REJECTED);
            //TODO send notification that they have a credit score
            return;
        }
        if (!Objects.equals(score.getExclusion(), "No Exclusion")) {
            loanRepository.updateLoanStatusById(loan.getId(),LoanStatus.INACTIVE,LoanRequestStatus.REJECTED);
            //TODO send notification that they do not qualify for a loan
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
        loanRepository.updateLoanStatusById(loan.getId(), LoanStatus.ACTIVE, LoanRequestStatus.APPROVED);
        //TODO send notification

    }

    private ScoreObj queryScore(  String token,int retrials) {

        ScoreObj scoreObj = scoringService.queryScore(token);
        if (scoreObj == null) {
            if (retrials <= 2) {
                //update retries in the db
                queryScore(  token,retrials+1);
            } else {
                return null;
            }
        }
        System.out.println(scoreObj+" is the score object");
        return scoreObj;
    }


}
