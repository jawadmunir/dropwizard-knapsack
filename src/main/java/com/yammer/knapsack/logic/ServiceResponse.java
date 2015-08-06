package com.yammer.knapsack.logic;

/**
 * the representation class for Service response.
 */
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by jawad on 2015-08-06.
 */
public class ServiceResponse {

    @JsonProperty
    private int totolImpressionsSold;

    @JsonProperty
    private int totalRevenueGenerated;

    @JsonProperty
    private ArrayList<MixCampaignsToSell> mixCampaigns;

    public ServiceResponse(){

    }

    public ServiceResponse(int totolImpressionsSold, int totalRevenueGenerated, ArrayList<MixCampaignsToSell> mixCampaigns) {
        this.totolImpressionsSold = totolImpressionsSold;
        this.totalRevenueGenerated = totalRevenueGenerated;
        this.mixCampaigns = mixCampaigns;
    }

    @JsonProperty
    public int getTotolImpressionsSold() {
        return totolImpressionsSold;
    }

    @JsonProperty
    public void setTotolImpressionsSold(int totolImpressionsSold) {
        this.totolImpressionsSold = totolImpressionsSold;
    }

    @JsonProperty
    public int getTotalRevenueGenerated() {
        return totalRevenueGenerated;
    }

    @JsonProperty
    public void setTotalRevenueGenerated(int totalRevenueGenerated) {
        this.totalRevenueGenerated = totalRevenueGenerated;
    }

    @JsonProperty
    public ArrayList<MixCampaignsToSell> getMixCampaigns() {
        return mixCampaigns;
    }

    @JsonProperty
    public void setMixCampaigns(ArrayList<MixCampaignsToSell> mixCampaigns) {
        this.mixCampaigns = mixCampaigns;
    }

    @Override
    public String toString() {
        return "ServiceResponse{" +
                "totolImpressionsSold=" + totolImpressionsSold +
                ", totalRevenueGenerated=" + totalRevenueGenerated +
                ", mixCampaigns=" + mixCampaigns +
                '}';
    }
}
