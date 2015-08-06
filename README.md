# dropwizard-knapsack
The home assignment for Ooyala, i.e. dropwizard rest service for selling online video advertisements. 
The web Client for the service is: Mozilla Firefox  or Chrome, the service accepts/repond in JSON format.

Application Description: 
this is web service created using dropwizard Java framework. The service is used to choose the best campaigns to sell, in order to maximize revenues. 

Launch the Application, and open web browzer

Method: POST and set the header Accept:application/json & Content-Type: application/json.

The problem is defined as: 


URL: http://localhost:8080/rest/service?maxImpressions=32356000


For Body of POST, please copy and paste the campaigns.json content in body section of request method.  


SEND THE REQUEST TO THE dropwizard SERVICE. 



Please Note: 
for simplicity purposes, I have choosen to send the maximum impression per month in the URL,
the variable "maxImpressions=32356000". So to change monthly quota for maximum impressions, please change it in URL. 

For example if monthly quota is: 50000000 for the same campaigns.json the url will be: 
URL: http://localhost:8080/rest/service?maxImpressions=50000000







