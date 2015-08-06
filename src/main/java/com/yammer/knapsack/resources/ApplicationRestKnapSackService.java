package com.yammer.knapsack.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.yammer.knapsack.core.*;
import com.yammer.knapsack.logic.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by jawad on 2015-08-04.
 */
@Path("/rest")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ApplicationRestKnapSackService {

    public ApplicationRestKnapSackService(){
    }

    // take any browzer as client to this rest service. type the below URL, with maxImpressions
    // and in the message body a JSON object for campaigns.
    // please set the browzer header Content-Type: application/json & Accept: application/json

    // URL: http://localhost:8080/rest/service?maxImpressions=32356000
    // Message Body:
    /*

   [
    {
        "customer": "Acme",
        "impressionsPerCampaign": 2000000,
        "valuePerCampaign": 200
    },
    {
        "customer": "Lorem",
        "impressionsPerCampaign": 3500000,
        "valuePerCampaign": 400
    },
    {
        "customer": "Ipsum",
        "impressionsPerCampaign": 2300000,
        "valuePerCampaign": 210
    },
    {
        "customer": "Dolor",
        "impressionsPerCampaign": 8000000,
        "valuePerCampaign": 730
    },
    {
        "customer": "SIT",
        "impressionsPerCampaign": 10000000,
        "valuePerCampaign": 1000
    },
    {
        "customer": "Amet",
        "impressionsPerCampaign": 1500000,
        "valuePerCampaign": 160
    },
    {
        "customer": "Mauris",
        "impressionsPerCampaign": 1000000,
        "valuePerCampaign": 100
    }
   ]
     */

    @POST
    @Path("/service")
    // http://localhost:8080/rest/service?maxImpressions=32356000
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ServiceResponse consumeJson(@QueryParam("maxImpressions") String maxImpressions, ArrayList<Campaign> campaigns){
        int maxImpressionsMonthly = Integer.parseInt(maxImpressions);
        System.out.println(maxImpressionsMonthly);
        ArrayList<Campaign> tempCampaigns = new ArrayList<Campaign>(campaigns);
        Solver knapsackSolver = new Solver(tempCampaigns, maxImpressionsMonthly);
        knapsackSolver.applyPriorityCampaigns();
        knapsackSolver.applyDominance();
        knapsackSolver.generateSolution();
        Knapsack solution = knapsackSolver.obtainKnapsack();
        //System.out.println(solution);
        ServiceResponse serviceResponse = ApplicationRestKnapSackService.generateResponse(solution);

        return serviceResponse;
    }

    // sample GET
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String testService(@QueryParam("name") String name){
        String value = "Hello" + name + "!";
        return value;
    }

    // to generate response

    public static ServiceResponse generateResponse(Knapsack solution){
        int totalImpressionSold = 0;
        MixCampaignsToSell singleMixCampaignsToSell;
        ArrayList<MixCampaignsToSell> mixCampaignsToSells = new ArrayList<MixCampaignsToSell>();
        ServiceResponse serviceResponse;
        Knapsack tempKnapSack = solution;
        HashMap<Campaign,Integer> tempCampaigns = tempKnapSack.getCampaigns();
        Iterator<Campaign> winnerCampaigns = tempKnapSack.getCampaigns().keySet().iterator();
        while(winnerCampaigns.hasNext()){
            Campaign singleWinnerCampaign = winnerCampaigns.next();
            Integer numOfCampaigns = tempKnapSack.getCampaigns().get(singleWinnerCampaign);

            singleMixCampaignsToSell = new MixCampaignsToSell(singleWinnerCampaign.getCustomer(), numOfCampaigns,
                    (singleWinnerCampaign.getImpressionsPerCampaign()* numOfCampaigns),
                    (singleWinnerCampaign.getValuePerCampaign() * numOfCampaigns));

            totalImpressionSold += singleWinnerCampaign.getImpressionsPerCampaign() * numOfCampaigns.intValue();

            mixCampaignsToSells.add(singleMixCampaignsToSell);

        }
        serviceResponse = new ServiceResponse(totalImpressionSold, tempKnapSack.getValueOfSolution(), mixCampaignsToSells);
        //System.out.println(serviceResponse.getTotolImpressionsSold());
        //System.out.println(serviceResponse.toString());
        return serviceResponse;
    }

    // the response JSON
    /*

    {
        "totolImpressionsSold": 32000000,
        "totalRevenueGenerated": 3620,
        "mixCampaigns":
        [
            {
                "customer": "Mauris",
                "noOfCampaignsToSell": 1,
                "totalImpressions4Customer": 1000000,
                "totalRevenueForCustomer": 100
            },
            {
                "customer": "Lorem",
                "noOfCampaignsToSell": 8,
                "totalImpressions4Customer": 28000000,
                "totalRevenueForCustomer": 3200
            },
            {
                "customer": "Amet",
                "noOfCampaignsToSell": 2,
                "totalImpressions4Customer": 3000000,
                "totalRevenueForCustomer": 320
            }
        ]
    }

     */
}
