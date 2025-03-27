package com.credable.repository.loan;


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
    @GeneratedValue(strategy = GenerationType.UUID)
    @jakarta.persistence.Id
    @Id
    private Long id;
    private String customerNumber;
    private Long loanAmount;
    private Long amountPaid;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
