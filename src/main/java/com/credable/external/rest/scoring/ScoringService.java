package com.credable.external.rest.scoring;

import com.credable.controller.mock.TokenModel;
import com.credable.external.rest.mock_data.score.ScoreObj;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Slf4j
@Service
public class ScoringService {
    @Value("${scoring.api.base-url}")
    private String scoringApiBaseUrl;

    @Value("${spring.security.user.name}")
    private String scoringUsername;

    @Value("${spring.security.user.password}")
    private String scoringPassword;

    private final RestTemplate restTemplate;

    @Autowired
    public ScoringService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Step 1: Initiate the scoring query to get a token.
     */
    public TokenModel initiateQueryScore(String customerNumber) {
        String url = scoringApiBaseUrl + "/initiateQueryScore/" + customerNumber;


        HttpEntity<Void> entity = getHeaders();

        ResponseEntity<TokenModel> response = restTemplate.exchange(url, HttpMethod.GET, entity, TokenModel.class);


        return response.getBody(); // Returns the token
    }

    private HttpEntity<Void> getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("client-token", UUID.randomUUID().toString());
        headers.set("Content-Type", "application/json");
        headers.set("Accept", "application/json");
        headers.setBasicAuth(scoringUsername, scoringPassword);
        return new HttpEntity<>(headers);
    }

    /**
     * Step 2: Query the score using the received token.
     */
    public ScoreObj queryScore(String token) {
        try {
            String url = scoringApiBaseUrl + "/queryScore/" + token;

            HttpEntity<Void> entity = getHeaders();

            ResponseEntity<ScoreObj> response = restTemplate.exchange(url, HttpMethod.GET, entity, ScoreObj.class);

            return response.getBody();

        } catch (ResourceAccessException e) {
            // This exception occurs when the request times out
            log.error("Request timed out: {}", e.getMessage());
            return null;
        } catch (Exception e) {
            // Handle other exceptions
            log.error("An error occurred: {}", e.getMessage());
            return null;
        }
    }
}
