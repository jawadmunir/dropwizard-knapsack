package com.yammer.knapsack.core;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * this is the respresentation class for the campaign profile
 */
public class Campaign {

    //@JsonProperty
    @NotEmpty
    private String customer;

    //@JsonProperty
    @NotEmpty
    private int impressionsPerCampaign;

    //@JsonProperty
    @NotEmpty
    private int valuePerCampaign;

    public Campaign(){
    }

    public Campaign(String customer, int impressionsPerCampaign,
                    int valuePerCampaign) {
        this.customer = customer;
        this.impressionsPerCampaign = impressionsPerCampaign;
        this.valuePerCampaign = valuePerCampaign;
    }

    @JsonProperty
    public String getCustomer() {
        return customer;
    }
    @JsonProperty
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @JsonProperty
    public int getImpressionsPerCampaign() {
        return impressionsPerCampaign;
    }
    @JsonProperty
    public void setImpressionsPerCampaign(int impressionsPerCampaign) {
        this.impressionsPerCampaign = impressionsPerCampaign;
    }

    @JsonProperty
    public int getValuePerCampaign() {
        return valuePerCampaign;
    }
    @JsonProperty
    public void setValuePerCampaign(int valuePerCampaign) {
        this.valuePerCampaign = valuePerCampaign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Campaign)) return false;

        Campaign campaign = (Campaign) o;

        if (getImpressionsPerCampaign() != campaign.getImpressionsPerCampaign()) return false;
        if (getValuePerCampaign() != campaign.getValuePerCampaign()) return false;
        return getCustomer().equals(campaign.getCustomer());

    }

    @Override
    public int hashCode() {
        int result = getCustomer().hashCode();
        result = 31 * result + getImpressionsPerCampaign();
        result = 31 * result + getValuePerCampaign();
        return result;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "customer='" + customer + '\'' +
                ", impressionsPerCampaign=" + impressionsPerCampaign +
                ", valuePerCampaign=" + valuePerCampaign +
                '}';
    }
}