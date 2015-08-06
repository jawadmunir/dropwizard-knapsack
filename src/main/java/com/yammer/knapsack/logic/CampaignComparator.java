package com.yammer.knapsack.logic;
/**
 * Comparator interface, to order based on ration impressions/value our campaigns
 */

import java.util.Comparator;
import com.yammer.knapsack.core.Campaign;

public class CampaignComparator implements Comparator<Campaign> {

    @Override
    public int compare(Campaign o1, Campaign o2) {
        double ratioCampaign1 = o1.getImpressionsPerCampaign()
                / o1.getValuePerCampaign();
        double ratioCampaign2 = o2.getImpressionsPerCampaign()
                / o2.getValuePerCampaign();

        if (ratioCampaign1 < ratioCampaign2) {
            return 1;
        } else if (ratioCampaign1 > ratioCampaign2) {
            return -1;
        } else {
            return 0;
        }
    }
}
