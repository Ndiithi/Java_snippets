package com.JsonServlet;

import com.JsonServlet.model.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author duncan
 */
public class MyServelet extends HttpServlet {

    @Resource(mappedName = "requestqueue")
    private Queue requestqueue;

    @Resource(mappedName = "bankFactoryQueue")
    private static ConnectionFactory context;

    Logger log = Logger.getLogger("MyServelet");

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        Person pers = new Person();
        ObjectMapper mapper = new ObjectMapper();
        pers.setName(request.getParameter("Name"));
        pers.setAge(request.getParameter("Age"));
        pers.setGender(request.getParameter("Gender"));
        pers.setPrimary_sch(request.getParameter("primary_sch"));
        pers.setSecondary_sch(request.getParameter("secondary_sch"));
        pers.setCollege(request.getParameter("college"));

        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pers);
        log.info(jsonString);
        sendJMSMessageToRequestqueue(jsonString);
        try (PrintWriter out = response.getWriter()) {
            out.println(jsonString);
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Electics biodata servelet";
    }

    private void sendJMSMessageToRequestqueue(String messageData) {
        context.createContext().createProducer().send(requestqueue, messageData);
        
    }

}
