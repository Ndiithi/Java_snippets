package com.exchangerateschecker;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author duncan
 */
public class ExchangeRateService {

    @GET
    @Path("/{denom,currency}")
    public Response getExchangeRate(@PathParam("currency") String name) {
        String currency = EchangeRateRestClient.getExchangeRate(name, name);
        return Response.status(200).entity(currency).build();
    }
}
