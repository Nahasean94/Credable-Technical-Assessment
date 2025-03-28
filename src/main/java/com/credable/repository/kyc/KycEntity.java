package com.credable.repository.kyc;

import com.credable.external.soap.wsdl.Gender;
import com.credable.external.soap.wsdl.IdType;
import com.credable.external.soap.wsdl.Status;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "kyc")
public class KycEntity {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String customerNumber;
    private String firstName;
    private String middleName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private IdType idType;
    private String idNumber;
    private String email;
    private String mobile;
    private Double monthlyIncome;

    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime dob;
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
