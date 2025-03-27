package com.credable.service;

import com.credable.repository.loan.ILoanRepository;
import com.credable.repository.loan.LoanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class LoanService {

    private final ILoanRepository loanRepository;

    @Autowired
    public LoanService(ILoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<LoanEntity> getLoanByCustomerNumber(String customerNumber) {
        return loanRepository.findLoansByCustomerNumber((customerNumber));
    }

    public LoanEntity saveLoan(LoanEntity loan) {
        return loanRepository.save(loan);
    }

    public LoanEntity getLoanStatus(String id) {
        return loanRepository.getLoanStatus(id);
    }


}
