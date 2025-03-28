package com.credable.model;

import com.credable.repository.kyc.KycEntity;
import lombok.Data;

import java.util.Optional;

@Data
public class KycResponse {
    private String status;
    private String message;
    private Optional<KycEntity> data;
}
