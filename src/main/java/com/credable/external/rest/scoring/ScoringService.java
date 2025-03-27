package com.credable.external.rest.scoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ScoringService {
    @Value("${scoring.api.base-url}")
    private String scoringApiBaseUrl;

    private String clientToken;

    private final RestTemplate restTemplate;

    @Autowired
    public ScoringService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Step 1: Initiate the scoring query to get a token.
     */
    public String initiateQueryScore(String customerNumber) {
        String url = scoringApiBaseUrl + "/initiateQueryScore/" + customerNumber;

        HttpHeaders headers = new HttpHeaders();
        headers.set("client-token", clientToken);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return response.getBody(); // Returns the token
    }

    /**
     * Step 2: Query the score using the received token.
     */
    public ScoringResponse queryScore(String token) {
        String url = scoringApiBaseUrl + "/queryScore/" + token;

        HttpHeaders headers = new HttpHeaders();
        headers.set("client-token", clientToken);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<ScoringResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, ScoringResponse.class);

        return response.getBody();
    }
}
