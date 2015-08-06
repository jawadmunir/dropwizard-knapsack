package com.yammer.knapsack.logic;

/**
 * representation class needed to create service response of winner campaigns
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

/**
 * Created by jawad on 2015-08-06.
 */
public class MixCampaignsToSell {
    @JsonProperty
    private String customer;

    @JsonProperty
    private int noOfCampaignsToSell;

    @JsonProperty
    private int totalImpressions4Customer;

    @JsonProperty
    private int totalRevenueForCustomer;

    public MixCampaignsToSell(){
    }

    public MixCampaignsToSell(String customer, int noOfCampaignsToSell, int totalImpressions4Customer, int totalRevenueForCustomer) {
        this.customer = customer;
        this.noOfCampaignsToSell = noOfCampaignsToSell;
        this.totalImpressions4Customer = totalImpressions4Customer;
        this.totalRevenueForCustomer = totalRevenueForCustomer;
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
    public int getNoOfCampaignsToSell() {
        return noOfCampaignsToSell;
    }
    @JsonProperty
    public void setNoOfCampaignsToSell(int noOfCampaignsToSell) {
        this.noOfCampaignsToSell = noOfCampaignsToSell;
    }
    @JsonProperty
    public int getTotalImpressions4Customer() {
        return totalImpressions4Customer;
    }
    @JsonProperty
    public void setTotalImpressions4Customer(int totalImpressions4Customer) {
        this.totalImpressions4Customer = totalImpressions4Customer;
    }
    @JsonProperty
    public int getTotalRevenueForCustomer() {
        return totalRevenueForCustomer;
    }
    @JsonProperty
    public void setTotalRevenueForCustomer(int totalRevenueForCustomer) {
        this.totalRevenueForCustomer = totalRevenueForCustomer;
    }

    @Override
    public String toString() {
        return "MixCampaignsToSell{" +
                "customer='" + customer + '\'' +
                ", noOfCampaignsToSell=" + noOfCampaignsToSell +
                ", totalImpressions4Customer=" + totalImpressions4Customer +
                ", totalRevenueForCustomer=" + totalRevenueForCustomer +
                '}';
    }
}
