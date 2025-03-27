package com.credable.external;

import org.apache.http.HttpRequestInterceptor;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.client.support.interceptor.ClientInterceptorAdapter;
import org.springframework.ws.context.MessageContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class SoapConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.credable.external.wsdls");
        return marshaller;
    }

    @Bean
    public WebServiceTemplate webServiceTemplate(Jaxb2Marshaller marshaller) {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(marshaller);
        webServiceTemplate.setUnmarshaller(marshaller);

        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("admin", "pwd123"));

        // Create Request Config (avoid automatic Content-Length issue)
        RequestConfig requestConfig = RequestConfig.custom()
                .setExpectContinueEnabled(false)  // Disable Expect: 100-Continue
                .build();

        // Create HttpClient with authentication
        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider)
                .setDefaultRequestConfig(requestConfig)  // Apply config to avoid content-length issue
                .addInterceptorFirst((HttpRequestInterceptor) (request, context) -> {
                    // Ensure Content-Length is not set multiple times
                    request.removeHeaders("Content-Length");
                })
                .build();

        // Use HttpComponentsMessageSender with custom HttpClient
        HttpComponentsMessageSender messageSender = new HttpComponentsMessageSender(httpClient);
        webServiceTemplate.setMessageSender(messageSender);
        webServiceTemplate.setInterceptors(new ClientInterceptor[]{new SoapLoggingInterceptor()});

        return webServiceTemplate;
    }


}


  class SoapLoggingInterceptor extends ClientInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(SoapLoggingInterceptor.class);

    @Override
    public boolean handleRequest(MessageContext messageContext) {
        logger.info("SOAP Request: {}", messageContext.getRequest());
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext) {
        logger.info("SOAP Response: {}", messageContext.getResponse());
        return true;
    }
}
//@Component
//public class KycSoapClient extends WebServiceGatewaySupport {
//
//    private static final String SOAP_ACTION = "https://kycapitest.credable.io/service/customerWsdl.wsdl";
//
//    public KycResponse getKycDetails(String customerNumber) {
//        KycRequest request = new KycRequest();
//        request.setCustomerNumber(customerNumber);
//
//        return (KycResponse) getWebServiceTemplate()
//                .marshalSendAndReceive(SOAP_ACTION, request, new SoapActionCallback(SOAP_ACTION));
//    }
//}
