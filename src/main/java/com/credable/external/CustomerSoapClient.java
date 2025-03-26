package com.credable.external;

import com.credable.repository.kyc.KycEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.SoapFaultClientException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

@Service
public class CustomerSoapClient {
    private static final Logger logger = LoggerFactory.getLogger(CustomerSoapClient.class);
    private final WebServiceTemplate webServiceTemplate;
    private static final String WSDL_URL = "https://kycapitest.credable.io/service/customerWsdl.wsdl";


    public CustomerSoapClient(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public Optional<KycEntity> getCustomerDetails(String customerNumber) {
        int maxRetries = 5;
        int attempt = 0;

        while (attempt < maxRetries) {
            try {
                String requestXml = "<CustomerRequest><customerNumber>" + customerNumber + "</customerNumber></CustomerRequest>";
                StreamSource source = new StreamSource(new StringReader(requestXml));

                StreamSource response = (StreamSource) webServiceTemplate.marshalSendAndReceive(WSDL_URL, source);
                return parseResponse(response);
            } catch (SoapFaultClientException ex) {
                logger.error("SOAP Request failed on attempt {}/{}", attempt + 1, maxRetries, ex);
                attempt++;
                if (attempt == maxRetries) return Optional.empty();
                try { Thread.sleep(2000); } catch (InterruptedException ignored) {} // Wait before retrying
            }
        }
        return Optional.empty();
    }


    private Optional<KycEntity> parseResponse(StreamSource response) {
        try {
            // Convert StreamSource to String
            String xmlString = convertStreamSourceToString(response);

            // Parse XML using DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xmlString)));
            document.getDocumentElement().normalize();

            // Extract customer data
            String customerNumber = getTagValue("customerNumber", document);
            String firstName = getTagValue("firstName", document);
            String lastName = getTagValue("lastName", document);
            String email = getTagValue("email", document);
            String mobile = getTagValue("mobile", document);
            String status = getTagValue("status", document);
            String idNumber = getTagValue("idNumber", document);
            String idType = getTagValue("idType", document);
            Double monthlyIncome = getTagValue("monthlyIncome", document) != null ? Double.parseDouble(Objects.requireNonNull(getTagValue("monthlyIncome", document))) : null;
            LocalDateTime dob = getTagValue("dob", document) != null ? LocalDateTime.parse(Objects.requireNonNull(getTagValue("dob", document))) : null;

            // Create KycEntity object
            KycEntity customer = new KycEntity();
            customer.setCustomerNumber(customerNumber);
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setEmail(email);
            customer.setMobile(mobile);
            customer.setStatus(status);
            customer.setIdNumber(idNumber);
            customer.setIdType(idType);
            customer.setMonthlyIncome(monthlyIncome);
            customer.setDob(dob);
            customer.setCreatedAt(LocalDateTime.now());
            customer.setUpdatedAt(LocalDateTime.now());

            return Optional.of(customer);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    // Convert StreamSource to String
    private String convertStreamSourceToString(StreamSource source) {
        try {
            StringBuilder xmlStringBuilder = new StringBuilder();
            char[] buffer = new char[1024];
            int bytesRead;
            java.io.Reader reader = source.getReader();
            while ((bytesRead = reader.read(buffer)) != -1) {
                xmlStringBuilder.append(buffer, 0, bytesRead);
            }
            return xmlStringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    // Get value from XML tag
    private String getTagValue(String tag, Document document) {
        NodeList nodeList = document.getElementsByTagName(tag);
        if (nodeList.getLength() > 0) {
            Node node = nodeList.item(0);
            return node.getTextContent();
        }
        return null;
    }
}
