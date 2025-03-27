package com.credable.controller;



import com.credable.repository.kyc.KycEntity;
import com.credable.service.KycService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/kyc")
public class KycController {

    @Autowired
    private KycService kycService;

    @GetMapping
    public List<KycEntity> getAllKycRecords() {
        return kycService.getAllKycRecords();
    }

    @GetMapping("/{customerNumber}")
    public ResponseEntity<KycEntity> getKycByCustomerNumber(@PathVariable String customerNumber) {
            Optional<KycEntity> customer = kycService.getCustomer(customerNumber);
            return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

    @PostMapping
    public KycEntity saveKyc(@RequestBody KycEntity kyc) {
        return kycService.saveKyc(kyc);
    }
}
