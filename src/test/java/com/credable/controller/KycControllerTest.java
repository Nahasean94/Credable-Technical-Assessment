package com.credable.controller;

import com.credable.external.rest.scoring.ScoringService;
import com.credable.model.KycRequest;
import com.credable.repository.kyc.KycEntity;
import com.credable.service.KycService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(MockitoExtension.class)
class KycControllerTest {

    private MockMvc mockMvc;

    @Mock
    private KycService kycService;

    @InjectMocks
    private KycController kycController;
    @InjectMocks
    private ScoringService scoringService;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(kycController).build();
    }

    @Test
    void testSaveKyc_CustomerFound() throws Exception {
        KycRequest request = new KycRequest();
        request.setCustomerNumber("12345");

        KycEntity kycEntity = new KycEntity();
        when(kycService.getCustomer("12345")).thenReturn(Optional.of(kycEntity));

        mockMvc.perform(post("/api/v1/customer/subscribe")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"customerNumber\": \"12345\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("successful"))
                .andExpect(jsonPath("$.message").value("Successfully subscribed a customer"));
    }

    @Test
    void testSaveKyc_Exception() throws Exception {
        when(kycService.getCustomer(anyString())).thenThrow(new RuntimeException("Database error"));

        mockMvc.perform(post("/api/v1/customer/subscribe")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"customerNumber\": \"99999\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("failed"))
                .andExpect(jsonPath("$.message").value("An error occurred while subscribing user to loan service"));
    }
}
