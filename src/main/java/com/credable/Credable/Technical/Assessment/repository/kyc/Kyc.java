package com.credable.Credable.Technical.Assessment.repository.kyc;



import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "kyc")
public class Kyc {

    @jakarta.persistence.Id
    @Id
    private Long id;

    private String customerNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String idType;
    private String idNumber;
    private String email;
    private String mobile;
    private Double monthlyIncome;
    private String status;
    private LocalDateTime dob;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
