package com.credable.controller;


import com.credable.model.KycRequest;
import com.credable.model.KycResponse;
import com.credable.repository.kyc.KycEntity;
import com.credable.service.KycService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@Tag(name = "Customer KYC Management", description = "Operations related to customer management")

@Slf4j
@RestController
@RequestMapping("/api")
public class KycController {

    @Autowired
    private KycService kycService;


    private final KycResponse kycResponse = new KycResponse();

    @Operation(summary = "Subscribe a customer for a loan", description = "Subscribes a customer to a loan. If the " +
            "customer is already subscribed, they wont't be subscribed again")
    @PostMapping(value = "/v1/customer/subscribe", produces = "application/json")
    public KycResponse saveKyc(@RequestBody KycRequest kyc) {
        log.info("Received request to check loan status {}", kyc);
        try {


        Optional<KycEntity> kycEntity = kycService.getCustomer(kyc.getCustomerNumber());
        kycResponse.setStatus("successful");
        if (kycEntity.isPresent()) {
            kycResponse.setMessage("Successfully subscribed a customer");
            log.info("Successfully subscribed a customer to credit scoring system {}", kycEntity);

        } else {
            kycResponse.setMessage("Customer with that customer number not found in the credit scoring system");
            log.info("Customer with that customer number not found in the credit scoring system ");

        }

        kycResponse.setData(kycEntity);
        return kycResponse;
        }catch (Exception e) {
            log.error("An error occurred while subscribing user to loan service: {}", e.getMessage());
            kycResponse.setStatus("failed");
            kycResponse.setMessage("An error occurred while subscribing user to loan service");
            kycResponse.setData(Optional.empty());
            return kycResponse;

        }
    }
}
