package com.credable.external.soap;

import com.credable.external.soap.wsdls.CustomerRequest;
import com.credable.external.soap.wsdls.CustomerResponse;
import com.credable.repository.kyc.KycEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.SoapFaultClientException;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Service
public class CustomerSoapClient {
    private static final Logger logger = LoggerFactory.getLogger(CustomerSoapClient.class);
    private final WebServiceTemplate webServiceTemplate;
    private static final String WSDL_URL = "https://scoringtest.credable.io/api/v1/service/customer";
    private static final String SOAP_ACTION = "https://kycapitest.credable.io/service/customerWsdl.wsdl";

    public CustomerSoapClient(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public Optional<KycEntity> getCustomerDetails(String customerNumber) {
        int maxRetries = 5;
        int attempt = 0;

        while (attempt < maxRetries) {
            try {
                // Create a proper JAXB request object
                CustomerRequest request = new CustomerRequest();
                request.setCustomerNumber(customerNumber);

                // Send SOAP request with headers
                Object response = webServiceTemplate.marshalSendAndReceive(SOAP_ACTION, request, new SoapActionCallback(SOAP_ACTION));
//                Object response = webServiceTemplate.marshalSendAndReceive(WSDL_URL, request);

                // Ensure response is of the expected type
                if (response instanceof CustomerResponse) {
                    return parseResponse((CustomerResponse) response);
                }

            } catch (SoapFaultClientException ex) {
                logger.error("SOAP Request failed on attempt {}/{}", attempt + 1, maxRetries, ex);
                attempt++;
                if (attempt == maxRetries) return Optional.empty();
                try { Thread.sleep(2000); } catch (InterruptedException ignored) {} // Wait before retrying
            }
        }
        return Optional.empty();
    }

    private Optional<KycEntity> parseResponse(CustomerResponse response) {
        try {
            KycEntity customer = new KycEntity();

            customer.setCustomerNumber(response.getCustomerNumber());
            customer.setFirstName(response.getFirstName());
            customer.setLastName(response.getLastName());
            customer.setEmail(response.getEmail());
            customer.setMobile(response.getMobile());
            customer.setStatus  (response.getStatus().toString());
            customer.setIdNumber(response.getIdNumber());
            customer.setIdType(response.getIdType().toString());
            customer.setMonthlyIncome(response.getMonthlyIncome());
            customer.setDob(convertToLocalDateTime(response.getDob()));
            customer.setCreatedAt(LocalDateTime.now());
            customer.setUpdatedAt(LocalDateTime.now());

            return Optional.of(customer);
        } catch (Exception e) {
            logger.error("Error parsing SOAP response", e);
            return Optional.empty();
        }
    }
    // Convert XMLGregorianCalendar to LocalDateTime
    private LocalDateTime convertToLocalDateTime(XMLGregorianCalendar xmlGregorianCalendar) {
        if (xmlGregorianCalendar == null) {
            return null;
        }
        return xmlGregorianCalendar.toGregorianCalendar().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}

