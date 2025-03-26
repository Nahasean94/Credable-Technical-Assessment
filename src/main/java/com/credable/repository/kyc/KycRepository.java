package com.credable.repository.kyc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface KycRepository extends JpaRepository<KycEntity, Long> {
        KycEntity findByCustomerNumber(String customerNumber);
    }
