# dropwizard-knapsack
The home assignment for Ooyala, i.e. dropwizard rest service for selling online video advertisements. 
The web Client for the service is: Mozilla Firefox  or Chrome, the service accepts/repond in JSON format.

Application Description: 
this is web service created using dropwizard Java framework. The service is used to choose the best campaigns to sell, in order to maximize revenues. 
Launch the Application, and open web browzer

The problem is defined as: 


Method: POST and set the header Accept:application/json & Content-Type: application/json.


URL: http://localhost:8080/rest/service?maxImpressions=32356000


Body: 
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


SEND THE REQUEST TO THE dropwizard SERVICE. 



Please Note: 
for simplicity purposes, I have choosen to send the maximum impression per month in the URL,
the variable "maxImpressions=32356000". So to change monthly quota for maximum impressions, please change it in URL. 






