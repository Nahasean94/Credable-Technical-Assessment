package com.credable.repository.loan;

import com.credable.model.LoanRequestStatus;
import com.credable.model.LoanStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ILoanRepository extends JpaRepository<LoanEntity, Long> {
    @Query("SELECT l FROM LoanEntity l WHERE l.id = :id")
    Optional<LoanEntity> findById(@Param("id") UUID id);

    @Query("SELECT l FROM LoanEntity l WHERE l.customerNumber = :customerNumber AND l.loanRequestStatus = :status")
    LoanEntity findByCustomerNumberAndStatus(@Param("customerNumber") String customerNumber,
                                             @Param("status") LoanRequestStatus status);


    @Query("SELECT COALESCE(SUM(l.loanAmount), 0) FROM LoanEntity l WHERE l.customerNumber = :customerNumber AND l.status = :status AND l.loanRequestStatus = :loanRequestStatus")

    Double sumLoanAmountByCustomerNumberAndStatusAndLoanRequestStatus(
            @Param("customerNumber") String customerNumber,
            @Param("status") LoanStatus status,
            @Param("loanRequestStatus") LoanRequestStatus loanRequestStatus);

    @Modifying
    @Transactional

    @Query("UPDATE LoanEntity l SET l.status = :status, l.loanRequestStatus = :loanRequestStatus WHERE l.id = :id")
    void updateLoanStatusById(
            @Param("id") UUID id,
            @Param("status") LoanStatus status,
            @Param("loanRequestStatus") LoanRequestStatus loanRequestStatus);

}
