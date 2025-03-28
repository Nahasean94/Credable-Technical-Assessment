package com.credable.controller.mock;


import com.credable.external.rest.mock_data.score.ScoreData;
import com.credable.external.rest.mock_data.score.ScoreObj;
import com.credable.repository.kyc.KycEntity;
import com.credable.repository.loan.LoanEntity;
import com.credable.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import static com.credable.model.LoanRequestStatus.PENDING;
import static com.credable.model.LoanStatus.INACTIVE;


@RestController
@RequestMapping("/mock/api/v1/scoring")
public class MockController {
    private final ScoreData scoreData = new ScoreData();


    @GetMapping(value = "/queryScore/{token}", produces = "application/json")
    public ScoreObj querScore(@PathVariable String token) {
        // Simulate delay between 1 and 7 seconds
        int delay = ThreadLocalRandom.current().nextInt(1, 8) * 1000; // Convert to milliseconds
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        ScoreObj obj= scoreData.findCustomerByNumber(token);
        System.out.println(obj.getScore()+ " is the score");
        return obj;
    }

    @GetMapping(value = "/initiateQueryScore/{customerNumber}", produces = "application/json")
    public TokenModel generateToken(@PathVariable String customerNumber) {
        TokenModel tokenModel = new TokenModel();
        tokenModel.setToken(UUID.randomUUID().toString());
        return tokenModel;

    }


}
