package com.yammer.knapsack;

import com.yammer.knapsack.resources.ApplicationRestKnapSackService;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

/**
 * Created by jawad on 2015-08-03.
 */
public class ApplicationKnapSack extends Application<ConfigurationKnapSack> {


    public static void main(String[] args) throws Exception {
        try {
            new ApplicationKnapSack().run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName(){

        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<ConfigurationKnapSack> bootstrap){
        bootstrap.addBundle(new ViewBundle<ConfigurationKnapSack>());
    }

    @Override
    public void run(ConfigurationKnapSack configurationKnapSack, Environment environment) throws Exception {
        final ApplicationRestKnapSackService resourceKnapSack = new ApplicationRestKnapSackService();
        environment.jersey().register(resourceKnapSack);

    }
}
