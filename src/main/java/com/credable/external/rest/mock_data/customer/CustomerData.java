package com.credable.external.rest.mock_data.customer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.credable.external.soap.wsdl.Gender.FEMALE;
import static com.credable.external.soap.wsdl.Gender.MALE;
import static com.credable.external.soap.wsdl.IdType.*;
import static com.credable.external.soap.wsdl.Status.ACTIVE;
import static com.credable.external.soap.wsdl.Status.INACTIVE;

public class CustomerData {

    private final List<CustomerObj> customers = new ArrayList<>();

    public CustomerData() {
        customers.add(new CustomerObj(  "234774784", "John", "M.", "Doe", MALE, PASSPORT, "A1234567", "john" +
                ".doe@example.com", "1234567890", 5000.0, ACTIVE, LocalDateTime.of(1990, 5, 10, 0, 0), LocalDateTime.now(), LocalDateTime.now()));
        customers.add(new CustomerObj(  "318411216", "Jane", "A.", "Smith", FEMALE, NATIONAL_ID, "B9876543", "jane" +
                ".smith@example.com", "2345678901", 6000.0, ACTIVE, LocalDateTime.of(1985, 8, 15, 0, 0), LocalDateTime.now(), LocalDateTime.now()));
        customers.add(new CustomerObj(  "340397370", "Alice", "B.", "Johnson", FEMALE, DRIVERS_LICENSE, "C7654321",
                "alice.johnson@example.com", "3456789012", 7000.0, ACTIVE, LocalDateTime.of(1992, 11, 20, 0, 0), LocalDateTime.now(), LocalDateTime.now()));
        customers.add(new CustomerObj(  "366585630", "Bob", "C.", "Williams", MALE, NATIONAL_ID, "D6543210", "bob" +
                ".williams@example.com", "4567890123", 5500.0, INACTIVE, LocalDateTime.of(1988, 2, 5, 0, 0), LocalDateTime.now(), LocalDateTime.now()));
        customers.add(new CustomerObj(  "397178638", "Charlie", "D.", "Brown", MALE, VOTERS_ID, "E5432109",
                "charlie.brown@example.com", "5678901234", 6200.0, INACTIVE, LocalDateTime.of(1995, 7, 12, 0, 0), LocalDateTime.now(), LocalDateTime.now()));
    }

    public CustomerObj findCustomerByNumber(String customerNumber) {
        return customers.stream()
                .filter(customer -> customer.getCustomerNumber().equals(customerNumber))
                .findFirst()
                .orElse(null);
    }
}


