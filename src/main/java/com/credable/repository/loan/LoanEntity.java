package com.credable.repository.loan;


import com.credable.model.LoanRequestStatus;
import com.credable.model.LoanStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "loan")
public class LoanEntity {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String customerNumber;
    private Double loanAmount;
    private LoanStatus status;
    private Integer retries;
    private LoanRequestStatus loanRequestStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
