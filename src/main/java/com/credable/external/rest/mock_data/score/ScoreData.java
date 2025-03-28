package com.credable.external.rest.mock_data.score;

import java.util.ArrayList;
import java.util.List;

public class ScoreData {

    private final List<ScoreObj> customers = new ArrayList<>();

    public ScoreData() {
        customers.add(new ScoreObj("234774784", 750, 50000, "No Exclusion", "No Exclusion"));
        customers.add(new ScoreObj("318411216", 50, 500, "Exclusion", "No Exclusion"));
        customers.add(new ScoreObj("340397370", 150, 5000, "No Exclusion", "No Exclusion"));
        customers.add(new ScoreObj("366585630", 350, 25000, "No Exclusion", "No Exclusion"));
        customers.add(new ScoreObj("397178638", 720, 45000, "No Exclusion", "No Exclusion"));
    }

    public ScoreObj findCustomerByNumber(String customerNumber) {
        return customers.stream()
                .filter(customer -> customer.getCustomerNumber().equals(customerNumber))
                .findFirst()
                .orElse(null);

//    public String findCustomerByNumber(String customerNumber) {
//        return customers.stream()
//                .filter(customer -> customer.getCustomerNumber().equals(customerNumber))
//                .findFirst()
//                .orElse(null);
//    }
    }
}

