package com.yammer.knapsack.core;
/**
 * representation class: this will have the value of the maximum revenue generating solution (knapsack).
 * it contains the campaigns, their size (weights), and value (revenue).
 *
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;


public class Knapsack {

    @JsonProperty
    private HashMap<Campaign,Integer> campaigns;

    @JsonProperty
    private int valueOfSolution;

    @JsonProperty
    private int sizeOfSolution;

    public Knapsack() {
        this.valueOfSolution = 0;
        this.sizeOfSolution = 0;
        this.campaigns= new HashMap();
    }

    public Knapsack(int valueOfSolution, int sizeOfSolution) {
        this.valueOfSolution = valueOfSolution;
        this.sizeOfSolution = sizeOfSolution;
        this.campaigns = new HashMap();
    }

    @JsonProperty
    public int getValueOfSolution() {
        return valueOfSolution;
    }

    @JsonProperty
    public void setValueOfSolution(int valueOfSolution) {
        this.valueOfSolution = valueOfSolution;
    }

    @JsonProperty
    public int getSizeOfSolution() {
        return sizeOfSolution;
    }

    @JsonProperty
    public void setSizeOfSolution(int sizeOfSolution) {
        this.sizeOfSolution = sizeOfSolution;
    }

    @JsonProperty
    public HashMap<Campaign, Integer> getCampaigns() {
        return campaigns;
    }

    @JsonProperty
    public void setCampaigns(HashMap<Campaign, Integer> campaigns) {
        this.campaigns = campaigns;
    }

    @Override
    public String toString() {
        return "Knapsack{" + "campaigns=" + campaigns
                + ", valueOfSolution=" + valueOfSolution
                + ", sizeOfSolution=" + sizeOfSolution + '}';
    }


}
