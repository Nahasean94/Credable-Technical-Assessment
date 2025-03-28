package com.credable.controller;

import com.credable.model.CustomerLoanRequest;
import com.credable.model.CustomerLoanResponse;
import com.credable.model.LoanRequestStatus;
import com.credable.model.LoanStatus;
import com.credable.repository.loan.LoanEntity;
import com.credable.service.LoanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class LoanControllerTest {

    @Mock
    private LoanService loanService;

    @InjectMocks
    private LoanController loanController;

    private CustomerLoanRequest loanRequest;
    private LoanEntity loanEntity;
    private UUID loanId;

    @BeforeEach
    void setUp() {
        loanId = UUID.randomUUID();

        loanRequest = new CustomerLoanRequest();
        loanRequest.setCustomerNumber("123456");
        loanRequest.setLoanAmount(5000.0);

        loanEntity = new LoanEntity();
        loanEntity.setCustomerNumber("123456");
        loanEntity.setLoanAmount(5000.0);
        loanEntity.setRetries(0);
        loanEntity.setLoanRequestStatus(LoanRequestStatus.PENDING);
        loanEntity.setStatus(LoanStatus.INACTIVE);
    }

    @Test
    void requestLoan_WhenCustomerHasPendingLoan_ShouldReturnFailedResponse() {
        when(loanService.findByCustomerNumberAndStatus("123456", LoanRequestStatus.PENDING)).thenReturn(loanEntity);

        CustomerLoanResponse response = loanController.requestLoan(loanRequest);

        assertEquals("failed", response.getStatus());
        assertEquals("User already has a pending loan request. Please try again later", response.getMessage());
        verify(loanService, never()).saveLoan(any());
    }

    @Test
    void requestLoan_WhenLoanIsSuccessfullyRequested_ShouldReturnSuccessResponse() {
        when(loanService.findByCustomerNumberAndStatus("123456", LoanRequestStatus.PENDING)).thenReturn(null);

        // Fix: Use doNothing() for void method
        doNothing().when(loanService).saveLoan(any());
        doNothing().when(loanService).processLoanRequest(any());

        CustomerLoanResponse response = loanController.requestLoan(loanRequest);

        assertEquals("successful", response.getStatus());
        assertEquals("Successfully requested a loan", response.getMessage());
        assertNotNull(response.getData());

        verify(loanService).saveLoan(any());
        verify(loanService).processLoanRequest(any());
    }

    @Test
    void requestLoan_WhenExceptionOccurs_ShouldReturnFailedResponse() {
        when(loanService.findByCustomerNumberAndStatus(any(), any())).thenThrow(new RuntimeException("Unexpected error"));

        CustomerLoanResponse response = loanController.requestLoan(loanRequest);

        assertEquals("failed", response.getStatus());
        assertEquals("An error occurred while applying for a loan", response.getMessage());
        assertNull(response.getData());
    }

    @Test
    void checkLoanStatus_WhenLoanExists_ShouldReturnSuccessResponse() {
        when(loanService.findById(loanId)).thenReturn(Optional.of(loanEntity));

        CustomerLoanResponse response = loanController.checkLoanStatus(loanId);

        assertEquals("successful", response.getStatus());
        assertEquals("Successfully found a loan", response.getMessage());
        assertNotNull(response.getData());
    }

    @Test
    void checkLoanStatus_WhenLoanDoesNotExist_ShouldReturnFailedResponse() {
        when(loanService.findById(loanId)).thenReturn(Optional.empty());

        CustomerLoanResponse response = loanController.checkLoanStatus(loanId);

        assertEquals("failed", response.getStatus());
        assertEquals("Failed to find a loan with that id", response.getMessage());
        assertNull(response.getData());
    }

    @Test
    void checkLoanStatus_WhenExceptionOccurs_ShouldReturnFailedResponse() {
        when(loanService.findById(any())).thenThrow(new RuntimeException("Unexpected error"));

        CustomerLoanResponse response = loanController.checkLoanStatus(loanId);

        assertEquals("failed", response.getStatus());
        assertEquals("An error occurred while checking loan status", response.getMessage());
        assertNull(response.getData());
    }
}
