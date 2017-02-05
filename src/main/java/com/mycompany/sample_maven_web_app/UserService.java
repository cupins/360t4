/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sample_maven_web_app;

import data.Model;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.POST;
import objects.User;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * REST Web Service
 *
 * @author wlloyd
 */
@Path("generic")
public class UserService {

    static final Logger logger = Logger.getLogger(UserService.class.getName());
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public UserService() {
    }

    /**
     * Retrieves representation of an instance of services.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getXml() {
        //TODO return proper representation object
        return "<html><body>Generic web service GET!</body></html>";
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String putXml(String content) {
        return "The user just put=" + content;
    }
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String PostJson(String jobj) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(jobj.toString(), User.class);
        //User user = mapper.readValue(jobj, User.class);
        
        StringBuilder text = new StringBuilder();
        text.append("The JSON obj:" + jobj.toString() + "\n");
        text.append("Hello " + user.getName() + "\n");
        text.append("You're only " + user.getAge() + " years old.\n");
        text.append("Messages:\n");
        for (Object msg : user.getMessages())
            text.append(msg.toString() + "\n");
        // Lambda function fails to deploy
        //user.getMessages().forEach((msg) -> { text.append(msg + "\n"); });
        
        try {
            Model db = Model.singleton();
            db.newUser(user);
            logger.log(Level.INFO, "user persisted to db.");
        }
        catch (SQLException sqle)
        {
            String errText = "Error persisting user after db connection made:\n" + sqle.getMessage() + " --- " + sqle.getSQLState() + "\n";
            logger.log(Level.SEVERE, errText);
            text.append(errText);
            StackTraceElement[] ste = sqle.getStackTrace();
            for (int i=0;i<ste.length;i++)
                logger.log(Level.SEVERE, ste[i].toString());
        }
        catch (Exception e)
        {
            logger.log(Level.SEVERE, "Error connecting to db.");
        }
        
        
        return text.toString();
    }
}

