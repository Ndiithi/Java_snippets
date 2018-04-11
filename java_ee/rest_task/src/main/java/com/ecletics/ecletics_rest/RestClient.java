package com.ecletics.ecletics_rest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.net.URLEncoder;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author duncan
 */
public class RestClient {

    final static Logger log = Logger.getLogger(RestClient.class);

    public static void main(String[] args) {
        try {

            Client client = Client.create();
            String verse_url = "https://bible-api.com/jn%203:16";
            //verse_url=URLEncoder.encode(verse_url, "UTF-8");
            log.info("The url: " + verse_url);
            WebResource webResource = client
                    .resource(verse_url);

            ClientResponse response = webResource.accept("application/json")
                    .get(ClientResponse.class);

            if (response.getStatus() != 200) {
                log.error("Failed to fetch ecletics verse : "
                        + response.getStatus());
                throw new RuntimeException();
            }

            String output = response.getEntity(String.class);

            log.info("Output from Server .... \n");
            log.info(output);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}
