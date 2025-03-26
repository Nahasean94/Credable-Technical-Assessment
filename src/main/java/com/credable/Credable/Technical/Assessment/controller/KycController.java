package com.credable.Credable.Technical.Assessment.controller;


import com.credable.Credable.Technical.Assessment.repository.kyc.Kyc;
import com.credable.Credable.Technical.Assessment.service.KycService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/kyc")
public class KycController {

    @Autowired
    private KycService kycService;

    @GetMapping
    public List<Kyc> getAllKycRecords() {
        return kycService.getAllKycRecords();
    }

    @GetMapping("/{customerNumber}")
    public Optional<Kyc> getKycByCustomerNumber(@PathVariable String customerNumber) {
        return kycService.getKycByCustomerNumber(customerNumber);
    }

    @PostMapping
    public Kyc saveKyc(@RequestBody Kyc kyc) {
        return kycService.saveKyc(kyc);
    }
}
