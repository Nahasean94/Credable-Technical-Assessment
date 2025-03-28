package com.credable.external.rest.mock_data.customer;

import com.credable.external.soap.wsdl.Gender;
import com.credable.external.soap.wsdl.IdType;
import com.credable.external.soap.wsdl.Status;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CustomerData {

    private final List<CustomerObj> customers = new ArrayList<>();

    public CustomerData() {
        customers.add(new CustomerObj(  "234774784", "John", "Msdd", "Doe", Gender.MALE, IdType.PASSPORT, "A1234567",
                "john" +
                ".doe@example.com", "1234567890", 5000.0, Status.ACTIVE, LocalDateTime.of(1990, 5, 10, 0, 0), LocalDateTime.now(), LocalDateTime.now()));
        customers.add(new CustomerObj(  "318411216", "Jane", "Aczc", "Smith", Gender.FEMALE, IdType.NATIONAL_ID,
                "B9876543", "jane" +
                ".smith@example.com", "2345678901", 6000.0, Status.ACTIVE, LocalDateTime.of(1985, 8, 15, 0, 0), LocalDateTime.now(), LocalDateTime.now()));
        customers.add(new CustomerObj(  "340397370", "Alice", "Badd", "Johnson", Gender.FEMALE, IdType.DRIVERS_LICENSE,
                "C7654321",
                "alice.johnson@example.com", "3456789012", 7000.0, Status.ACTIVE, LocalDateTime.of(1992, 11, 20, 0, 0), LocalDateTime.now(), LocalDateTime.now()));
        customers.add(new CustomerObj(  "366585630", "Bob", "Casd", "Williams",Gender. MALE, IdType.NATIONAL_ID,
                "D6543210", "bob" +
                ".williams@example.com", "4567890123", 5500.0, Status.INACTIVE, LocalDateTime.of(1988, 2, 5, 0, 0), LocalDateTime.now(), LocalDateTime.now()));
        customers.add(new CustomerObj(  "397178638", "Charlie", "Dsf", "Brown", Gender.MALE, IdType.VOTERS_ID,
                "E5432109",
                "charlie.brown@example.com", "5678901234", 6200.0, Status.INACTIVE, LocalDateTime.of(1995, 7, 12, 0, 0), LocalDateTime.now(), LocalDateTime.now()));
    }

    public CustomerObj findCustomerByNumber(String customerNumber) {
        return customers.stream()
                .filter(customer -> customer.getCustomerNumber().equals(customerNumber))
                .findFirst()
                .orElse(null);
    }
}


