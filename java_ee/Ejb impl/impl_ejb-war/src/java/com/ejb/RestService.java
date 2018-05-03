package com.ejb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author duncan
 */
@Path("/send_jms_message")
public class RestService {

    @GET
    @Path("/{id}")
    public Response getMsg(@PathParam("id") String name) {
        try {
            service s = new service();
            s.sendJMSMessageToEcleticsQueue(name);
            String output = "Welcome   : " + name;
            return Response.status(200).entity(output).build();
        } catch (JMSException | NamingException ex) {
            Logger.getLogger(RestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.status(200).build();
    }

}
