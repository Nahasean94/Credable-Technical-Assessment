package com.credable.model;

import com.credable.repository.kyc.KycEntity;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
public class TransactionResponse {
    private String status;
    private String message;
    private List<com.credable.external.soap.wsdl.TransactionData> data;
}
