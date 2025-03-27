package com.credable.repository.loan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ILoanRepository extends JpaRepository<LoanEntity, Long> {
//    LoanEntity saveLoan(LoanEntity loan);
////    Optional<LoanEntity> findById(Long id);
//    List<LoanEntity> findLoansByCustomerNumber(String customerNumber);
}
