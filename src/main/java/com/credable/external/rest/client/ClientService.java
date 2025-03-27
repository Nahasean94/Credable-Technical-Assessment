package com.credable.external.rest.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientService {

    @Value("${scoring.api.client-create-url}")
    private String createClientUrl;

    private final RestTemplate restTemplate;

    @Autowired
    public ClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Registers a new client with the scoring system.
     */
    public ClientResponse createClient(ClientRequest clientRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ClientRequest> requestEntity = new HttpEntity<>(clientRequest, headers);

        ResponseEntity<ClientResponse> response = restTemplate.exchange(
                createClientUrl,
                HttpMethod.POST,
                requestEntity,
                ClientResponse.class
        );

        return response.getBody();
    }
}
