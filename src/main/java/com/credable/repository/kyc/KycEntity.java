package com.credable.repository.kyc;

import com.credable.external.soap.wsdl.Gender;
import com.credable.external.soap.wsdl.IdType;
import com.credable.external.soap.wsdl.Status;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "kyc")
public class KycEntity {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private Gender gender;
    private IdType idType;
    private String idNumber;
    private String email;
    private String mobile;
    private Double monthlyIncome;
    private Status status;
    private LocalDateTime dob;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
