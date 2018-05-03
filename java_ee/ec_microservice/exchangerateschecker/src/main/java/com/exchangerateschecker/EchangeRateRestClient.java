/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exchangerateschecker;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 *
 * @author duncan
 */
public class EchangeRateRestClient {

    public static String getExchangeRate(String denonination, String currency) {
        Client client = Client.create();
        String exchangeRateService = "url_to_example_provider";

        WebResource webResource = client
                .resource(exchangeRateService);

        ClientResponse response = webResource.accept("application/json")
                .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            System.out.println("Failed to fetch verse : "
                    + response.getStatus());
            throw new RuntimeException();
        }

        String output = response.getEntity(String.class);

        return output;
    }

}
