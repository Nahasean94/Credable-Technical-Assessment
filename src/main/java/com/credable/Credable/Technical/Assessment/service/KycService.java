package com.credable.Credable.Technical.Assessment.service;


import com.credable.Credable.Technical.Assessment.repository.kyc.Kyc;
import com.credable.Credable.Technical.Assessment.repository.kyc.KycRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class KycService {

    @Autowired
    private KycRepository kycRepository;

    public List<Kyc> getAllKycRecords() {
        return kycRepository.findAll();
    }

    public Optional<Kyc> getKycByCustomerNumber(String customerNumber) {
        return Optional.ofNullable(kycRepository.findByCustomerNumber(customerNumber));
    }

    public Kyc saveKyc(Kyc kyc) {
        return kycRepository.save(kyc);
    }
}
