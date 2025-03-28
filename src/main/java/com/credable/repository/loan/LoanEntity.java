package com.credable.repository.loan;


import com.credable.model.LoanRequestStatus;
import com.credable.model.LoanStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "loan")
public class LoanEntity {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String customerNumber;
    private Double loanAmount;
    @Enumerated(EnumType.STRING)
    private LoanStatus status;
    private Integer retries;
    @Enumerated(EnumType.STRING)
    private LoanRequestStatus loanRequestStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }


}
