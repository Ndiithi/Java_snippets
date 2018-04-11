/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecletics.subscriptionservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author duncan
 */
public class SubscriptionService {
    @GET
    @Path("/{xxx}")
    public Response getExchangeRate(@PathParam("user_name") String userName,@PathParam("hash_password") String hashPassword) {
        //More endpoints for ecletics microserices
        return Response.status(200).build();
    }
}
