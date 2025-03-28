package com.credable.service;

import com.credable.external.rest.mock_data.customer.CustomerData;
import com.credable.external.rest.mock_data.customer.CustomerObj;
import com.credable.repository.kyc.IKycRepository;
import com.credable.repository.kyc.KycEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
public class KycService {

    //    private final CustomerSoapClient soapClient;
    private final IKycRepository kycRepository;
    private final CustomerData customerData = new CustomerData();

    @Autowired
    public KycService(IKycRepository kycRepository) {
//        this.soapClient = soapClient;
        this.kycRepository = kycRepository;
    }

    @Transactional
    public Optional<KycEntity> getCustomer(String customerNumber) {
        // Check database first
        log.info("About to query customer, customer number: {}", customerNumber);
        Optional<KycEntity> existingCustomer = Optional.ofNullable(kycRepository.findByCustomerNumber(customerNumber));
        if (existingCustomer.isPresent()) {
            log.info("Found a customer, customer: {}", existingCustomer.get());

            return existingCustomer;
        }
        // Query SOAP service
        log.info("Did not find customer, about to query from scoring engine");

        Optional<KycEntity> newCustomer = parseResponse(customerData.findCustomerByNumber(customerNumber));
        log.info("Response from scoring engine: {}", newCustomer);

        newCustomer.ifPresent(kycRepository::save);
        log.info("Saved customer record");

        return newCustomer;
    }

    private Optional<KycEntity> parseResponse(CustomerObj obj) {
        try {
            KycEntity customer = new KycEntity();

            customer.setId(obj.getId());
            customer.setCustomerNumber(obj.getCustomerNumber());
            customer.setFirstName(obj.getFirstName());
            customer.setMiddleName(obj.getMiddleName());
            customer.setLastName(obj.getLastName());
            customer.setEmail(obj.getEmail());
            customer.setGender(obj.getGender());
            customer.setMobile(obj.getMobile());
            customer.setStatus(obj.getStatus());
            customer.setIdNumber(obj.getIdNumber());
            customer.setIdType(obj.getIdType());
            customer.setMonthlyIncome(obj.getMonthlyIncome());
            customer.setDob(obj.getDob());
            customer.setCreatedAt(LocalDateTime.now());
            customer.setUpdatedAt(LocalDateTime.now());

            return Optional.of(customer);
        } catch (Exception e) {
            log.info("An error occurred when parsing response");
            log.error(e.getMessage());
            return Optional.empty();
        }
    }

}
