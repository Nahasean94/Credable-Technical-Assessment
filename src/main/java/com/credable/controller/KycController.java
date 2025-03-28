package com.credable.controller;


import com.credable.model.KycRequest;
import com.credable.model.KycResponse;
import com.credable.repository.kyc.KycEntity;
import com.credable.service.KycService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
public class KycController {

    @Autowired
    private KycService kycService;


    private final KycResponse kycResponse = new KycResponse();

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
            log.error("An error occurred while subscribing user to loan service", e.getCause());
            kycResponse.setStatus("failed");
            kycResponse.setMessage("An error occurred while subscribing user to loan service");
            kycResponse.setData(Optional.empty());
            return kycResponse;

        }
    }
}
