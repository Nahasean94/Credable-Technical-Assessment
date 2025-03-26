package com.credable.Credable.Technical.Assessment.repository.kyc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface KycRepository extends JpaRepository<Kyc, Long> {
        Kyc findByCustomerNumber(String customerNumber);
    }
