package com.credable.external.rest.scoring;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class ScoringResponse {
    // Getters and Setters
    private int id;
    private String customerNumber;
    private int score;
    private int limitAmount;
    private String exclusion;
    private String exclusionReason;

}
