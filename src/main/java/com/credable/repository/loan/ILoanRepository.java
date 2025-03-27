package com.credable.repository.loan;

import com.credable.model.LoanRequestStatus;
import com.credable.model.LoanStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ILoanRepository extends JpaRepository<LoanEntity, Long> {
    @Query("SELECT l FROM LoanEntity l WHERE l.id = :id")
    Optional<LoanEntity> findById(@Param("id") Long id);

    @Query("SELECT l FROM LoanEntity l WHERE l.customerNumber = :customerNumber")
    List<LoanEntity> findLoansByCustomerNumber(@Param("customerNumber") String customerNumber);

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
            @Param("id") Long id,
            @Param("status") LoanStatus status,
            @Param("loanRequestStatus") LoanRequestStatus loanRequestStatus);
    @Modifying
    @Query(value = "UPDATE loan_entity SET retrials = retrials + 1 WHERE id = :id RETURNING *", nativeQuery = true)
    LoanEntity incrementRetrialsAndReturn(@Param("id") Long id);

}
