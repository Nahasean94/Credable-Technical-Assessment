package com.credable.external.rest.mock_data.score;


import lombok.Getter;
import lombok.Setter;

@Getter
 @Setter
public class ScoreObj {

    private String customerNumber;
    private int score;
    private double limitAmount;
    private String exclusion;
    private String exclusionReason;

    public ScoreObj(  String customerNumber, int score, double limitAmount, String exclusion, String exclusionReason) {
        this.customerNumber = customerNumber;
        this.score = score;
        this.limitAmount = limitAmount;
        this.exclusion = exclusion;
        this.exclusionReason = exclusionReason;
    }


}

