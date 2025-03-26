package com.credable.service;

import com.credable.external.CustomerSoapClient;
import com.credable.repository.kyc.KycEntity;
import com.credable.repository.kyc.KycRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
@Service
public class KycService {

    private final CustomerSoapClient soapClient;
    private final KycRepository kycRepository;

    @Autowired
    public KycService(CustomerSoapClient soapClient, KycRepository kycRepository) {
        this.soapClient = soapClient;
        this.kycRepository = kycRepository;
    }
    public List<KycEntity> getAllKycRecords() {
        return kycRepository.findAll();
    }

    public Optional<KycEntity> getKycByCustomerNumber(String customerNumber) {
        return Optional.ofNullable(kycRepository.findByCustomerNumber(customerNumber));
    }

    public KycEntity saveKyc(KycEntity kyc) {
        return kycRepository.save(kyc);
    }

    @Transactional
    public Optional<KycEntity> getCustomer(String customerNumber) {
        // Check database first
        Optional<KycEntity> existingCustomer = Optional.ofNullable(kycRepository.findByCustomerNumber(customerNumber));
        if (existingCustomer.isPresent()) {
            return existingCustomer;
        }
        // Query SOAP service
        Optional<KycEntity> newCustomer = soapClient.getCustomerDetails(customerNumber);
        newCustomer.ifPresent(kycRepository::save);

        return newCustomer;
    }
}
