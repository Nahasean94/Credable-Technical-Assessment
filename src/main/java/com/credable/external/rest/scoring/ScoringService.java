package com.credable.external.rest.scoring;

import com.credable.external.rest.mock_data.score.ScoreObj;
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

@Service
public class ScoringService {
    @Value("${scoring.api.base-url}")
    private String scoringApiBaseUrl;

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
        headers.set("client-token", UUID.randomUUID().toString());

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return response.getBody(); // Returns the token
    }

    /**
     * Step 2: Query the score using the received token.
     */
    public ScoreObj queryScore(String token) {
        try {
            String url = scoringApiBaseUrl + "/queryScore/" + token;

            HttpHeaders headers = new HttpHeaders();
            headers.set("client-token", UUID.randomUUID().toString());

            HttpEntity<Void> entity = new HttpEntity<>(headers);

            ResponseEntity<ScoreObj> response = restTemplate.exchange(url, HttpMethod.GET, entity, ScoreObj.class);

            return response.getBody();
        } catch (ResourceAccessException e) {
            // This exception occurs when the request times out
            System.err.println("Request timed out: " + e.getMessage());
            return null;
        } catch (Exception e) {
            // Handle other exceptions
            System.err.println("An error occurred: " + e.getMessage());
            return null;
        }
    }
}
