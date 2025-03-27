package com.credable.external.wsdls;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.credable.external.wsdl.customerWsdl package.
 * <p>An com.credable.external.wsdls.ObjectFactory allows you to programmatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new com.credable.external.wsdls.ObjectFactory that can be used to create new instances of schema derived classes for package: com.credable.external.wsdl.customerWsdl
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TransactionsRequest }
     *
     * @return
     *     the new instance of {@link TransactionsRequest }
     */
    public TransactionsRequest createTransactionsRequest() {
        return new TransactionsRequest();
    }

    /**
     * Create an instance of {@link TransactionsResponse }
     *
     * @return
     *     the new instance of {@link TransactionsResponse }
     */
    public TransactionsResponse createTransactionsResponse() {
        return new TransactionsResponse();
    }

    /**
     * Create an instance of {@link TransactionData }
     *
     * @return
     *     the new instance of {@link TransactionData }
     */
    public TransactionData createTransactionData() {
        return new TransactionData();
    }

    /**
     * Create an instance of {@link Account }
     *
     * @return
     *     the new instance of {@link Account }
     */
    public Account createAccount() {
        return new Account();
    }

    /**
     * Create an instance of {@link CustomerRequest }
     *
     * @return
     *     the new instance of {@link CustomerRequest }
     */
    public CustomerRequest createCustomerRequest() {
        return new CustomerRequest();
    }

    /**
     * Create an instance of {@link CustomerResponse }
     *
     * @return
     *     the new instance of {@link CustomerResponse }
     */
    public CustomerResponse createCustomerResponse() {
        return new CustomerResponse();
    }

    /**
     * Create an instance of {@link Customer }
     *
     * @return
     *     the new instance of {@link Customer }
     */
    public Customer createCustomer() {
        return new Customer();
    }

}
