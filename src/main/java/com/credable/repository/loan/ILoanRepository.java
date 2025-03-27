package com.credable.repository.loan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ILoanRepository extends JpaRepository<LoanEntity, Long> {
    LoanEntity saveLoan(LoanEntity loan);
    LoanEntity getLoanStatus(String loanId);
    List<LoanEntity> findLoansByCustomerNumber(String customerNumber);
}
