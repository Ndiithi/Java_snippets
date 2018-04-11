/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecletics.usernmanager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author duncan
 */
public class UserManager {
    
    @GET
    @Path("/{user_name,hash_password}")
    public Response getExchangeRate(@PathParam("user_name") String userName,@PathParam("hash_password") String hashPassword) {
        UserManagerService userService=new UserManagerService();
        User User = userService.validateUser(userName, hashPassword);
        return Response.status(200).entity(User).build();
    }
}
