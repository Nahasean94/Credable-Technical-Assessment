package com.credable.external.rest.mock_data.customer;


import com.credable.external.soap.wsdl.Gender;
import com.credable.external.soap.wsdl.IdType;
import com.credable.external.soap.wsdl.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
 @Getter
 @Setter
public class CustomerObj {
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

    // Constructor
    public CustomerObj(  String customerNumber, String firstName, String middleName, String lastName,
                         Gender gender, IdType idType, String idNumber, String email, String mobile,
                       Double monthlyIncome, Status status, LocalDateTime dob, LocalDateTime createdAt,
                       LocalDateTime updatedAt) {

        this.customerNumber = customerNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.idType = idType;
        this.idNumber = idNumber;
        this.email = email;
        this.mobile = mobile;
        this.monthlyIncome = monthlyIncome;
        this.status = status;
        this.dob = dob;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
