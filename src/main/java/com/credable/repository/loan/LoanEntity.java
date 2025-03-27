package com.credable.repository.loan;


import com.credable.model.LoanRequestStatus;
import com.credable.model.LoanStatus;
import jakarta.persistence.*;
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
    @Enumerated(EnumType.STRING)
    private LoanStatus status;
    private Integer retries;
    @Enumerated(EnumType.STRING)
    private LoanRequestStatus loanRequestStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
