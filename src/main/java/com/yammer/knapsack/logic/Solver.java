package com.yammer.knapsack.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import com.yammer.knapsack.core.Campaign;
import com.yammer.knapsack.core.Knapsack;
import com.yammer.knapsack.logic.CampaignComparator;

public class Solver {

    private int[] subproblems;
    private Campaign[] campaignsAdded;
    private ArrayList<Campaign> campaigns;
    private int valueSolution;
    private int backtrackOfSolution;

    // initialize with campaigns and maximum no of impressions per month
    public Solver(ArrayList<Campaign> campaigns, int maxImpressions) {
        this.campaigns = campaigns;
        this.subproblems = new int[maxImpressions + 1];
        this.campaignsAdded = new Campaign[maxImpressions + 1];
        this.backtrackOfSolution = 0;
        this.valueSolution = 0;
    }
    // dynamic programming approach
    public void generateSolution() {

        for (int i = 1; i < subproblems.length; i++) {
            for (Campaign element : campaigns) {
                int itemWeight = element.getImpressionsPerCampaign();
                int itemValue = element.getValuePerCampaign();
                if (itemWeight<=i
                        &&(itemValue+subproblems[i-itemWeight])>subproblems[i]) {
                    subproblems[i]= itemValue+subproblems[i-itemWeight];
                    campaignsAdded[i]=element;
                }
            }
        }
        valueSolution = subproblems[subproblems.length-1];
        backtrackOfSolution=subproblems.length-1;
    }

    //Returns the optimal solution in knapsack Object
    public Knapsack obtainKnapsack() {
        Knapsack solution = new Knapsack(valueSolution, backtrackOfSolution);
        HashMap<Campaign, Integer> backtrackSolution = new HashMap();

        // recover the elements
        Campaign lastCampaign = campaignsAdded[backtrackOfSolution];
        int i = backtrackOfSolution;
        while (lastCampaign!=null&&i >= 0) {
            if (backtrackSolution.containsKey(lastCampaign)) {
                Integer counter = backtrackSolution.get(lastCampaign);
                backtrackSolution.put(lastCampaign, counter + 1);
            }
            else {
                backtrackSolution.put(lastCampaign, 1);
            }
            i -= lastCampaign.getImpressionsPerCampaign();
            lastCampaign=campaignsAdded[i];
        }
        solution.setCampaigns(backtrackSolution);
        return solution;
    }

    // to give prority to most profitable campaigns, we order them based on ratio impressions/value
    public void applyPriorityCampaigns() {

        Collections.sort(campaigns, new CampaignComparator());
    }

    // for improving performance
    public void applyDominance() {
        int m = campaigns.size();
        for(int i=0;i<m-1;i++){
            Campaign temp1 = campaigns.get(i);
            for(int j=i+1;j<m-1;j++){
                Campaign temp2 = campaigns.get(j);
                if(((temp1.getImpressionsPerCampaign()
                        *temp2.getValuePerCampaign())
                        /temp1.getValuePerCampaign())
                        <temp2.getImpressionsPerCampaign()){
                    campaigns.remove(j);
                    m--;
                }

            }
        }
    }

}
