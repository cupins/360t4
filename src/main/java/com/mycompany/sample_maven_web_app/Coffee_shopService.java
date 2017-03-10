/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sample_maven_web_app;


import data.Model;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import objects.Coffee_Shop;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * REST Web Service
 * @author tim, reid, gabriel & chris
 */
@Path("shops")
public class Coffee_shopService {

    static final Logger logger = Logger.getLogger(Coffee_shopService.class.getName());
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public Coffee_shopService() {
    }



    /**
     * Retrieves representation of an instance of services.GenericResource
     * @return an instance of java.lang.String
     */
    /*
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getCShops() {
        //TODO return proper representation object
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body><style>table, th, td {font-family:Arial,Verdana,sans-serif;font-size:16px;padding: 0px;border-spacing: 0px;}</style><b>Coffee Shop List:</b><br><br><table cellpadding=10 border=1><tr><td>coffee id</td><td>coffee name</td><td>coffee address</td><td>raw review</td><td>phone number</td><td>url</td></tr>");
        try
        {
            Model db = Model.singleton();
            Coffee_Shop[] cs = db.getCoffeeShops();
            for (int i=0;i<cs.length;i++)
                sb.append("<tr><td>" + cs[i].getCid() + "</td><td>" + cs[i].getCoffeeName() + "</td><td>" + cs[i].getCoffeeAddress() + "</td><td>" + cs[i].getRawReview() + "</td><td>" + cs[i].getPhone() + "</td><td>" + cs[i].getWebsite() + "</td></tr>");
        }
        catch (Exception e)
        {
            sb.append("</table><br>Error getting coffee shops: " + e.toString() + "<br>");
        }
        sb.append("</table></body></html>");
        return sb.toString();
    }
    */
    @GET
    @Path("{cid}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Coffee_Shop> getShopsJson(@PathParam("cid") String id) {
        LinkedList<Coffee_Shop> lshops = new LinkedList<Coffee_Shop>();
     
        try
        {
            int cid = Integer.parseInt(id);
            Model db = Model.singleton();
            Coffee_Shop[] shops = db.getCoffeeShops(cid);
            if (cid ==0)
                for (int i=0;i<shops.length;i++)
                    lshops.add(shops[i]);
            else
                lshops.add(shops[0]);
            logger.log(Level.INFO, "Received request to fetch shop id=" + cid);
            return lshops;
        }
        catch (Exception e)
        {
            JSONObject obj = new JSONObject();
                logger.log(Level.WARNING, "Error getting shops:" + e.toString());
                return null;
        }
    } 

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateCoffeeShop(String jobj) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        Coffee_Shop cs = mapper.readValue(jobj.toString(), Coffee_Shop.class);
        StringBuilder text = new StringBuilder();
        try {
            Model db = Model.singleton();
            int cid = cs.getCid();
            db.updateCoffeeShop(cs);
            logger.log(Level.INFO, "update cs with cid=" + cid);
            text.append("Coffee_Shop id updated with cid=" + cid + "\n");
        }
        catch (SQLException sqle)
        {
            String errText = "Error updating cs after db connection made:\n" + sqle.getMessage() + " --- " + sqle.getSQLState() + "\n";
            logger.log(Level.SEVERE, errText);
            text.append(errText);
        }
        catch (Exception e)
        {
            logger.log(Level.SEVERE, "Error connecting to db.");
            text.append("Error connecting to db.");
        }
        return text.toString();
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteCoffeeShop(String jobj) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        Coffee_Shop cs = mapper.readValue(jobj.toString(), Coffee_Shop.class);
        StringBuilder text = new StringBuilder();
        try {
            Model db = Model.singleton();
            int cid = cs.getCid();
            db.deleteCoffeeShop(cid);
            logger.log(Level.INFO, "cs deleted from db=" + cid);
            text.append("cs id deleted with id=" + cid);
        }
        catch (SQLException sqle)
        {
            String errText = "Error deleteing cs after db connection made:\n" + sqle.getMessage() + " --- " + sqle.getSQLState() + "\n";
            logger.log(Level.SEVERE, errText);
            text.append(errText);
        }
        catch (Exception e)
        {
            logger.log(Level.SEVERE, "Error connecting to db.");
            text.append("Error connecting to db.");
        }
        return text.toString();
    }
    

//   @POST
//   @Produces(MediaType.TEXT_PLAIN)
//   @Consumes(MediaType.APPLICATION_JSON)
//   public String createCShop(String jobj) throws IOException {
//       ObjectMapper mapper = new ObjectMapper();
//       Coffee_Shop shop = mapper.readValue(jobj.toString(), Coffee_Shop.class);
//       StringBuilder text = new StringBuilder();
//       text.append("The JSON obj:" + jobj.toString() + "\n");
////         text.append("Hello " + user.getName() + "\n");
////         text.append("You're only " + user.getAge() + " years old.\n");
////         text.append("Messages:\n");
////         for (Object msg : user.getMessages())
////             text.append(msg.toString() + "\n");
//       try {
//           Model db = Model.singleton();
//           int cid = db.newCoffeeShop(shop);
//           logger.log(Level.INFO, "coffee stuff\n");
//           db.newCoffeeShop(shop);
//           logger.log(Level.INFO, "shop persisted to db as cid=" + cid);
//           text.append("Shop id persisted with id=" + cid);
//       }
//       catch (SQLException sqle)
//       {
//           String errText = "Error persisting cs after db connection made:\n" + sqle.getMessage() + " --- " + sqle.getSQLState() + "\n";
//           logger.log(Level.SEVERE, errText);
//           text.append(errText);
//       }
//       catch (Exception e)
//       {
//           logger.log(Level.SEVERE, "Error connecting to db.");
//       }
//       return text.toString();
//   }
   /*
   @POST
   @Produces(MediaType.TEXT_PLAIN)
   @Consumes(MediaType.APPLICATION_JSON)
   public String createCShops(String jobj) throws IOException {
       Model data = Model.singleton();
       Coffee_Shop[] shopsToAdd = data.getCoffeeShops();
       for (Coffee_Shop shop: shopsToAdd) {
           ObjectMapper mapper = new ObjectMapper();
           Coffee_Shop shop = mapper.readValue(jobj.toString(), Coffee_Shop.class);
           StringBuilder text = new StringBuilder();
           text.append("The JSON obj:" + jobj.toString() + "\n");
           try {
               Model db = Model.singleton();
               int cid = db.newCoffeeShop(shop);
               logger.log(Level.INFO, "coffee stuff\n");
               db.newCoffeeShop(shop);
               logger.log(Level.INFO, "shop persisted to db as cid=" + cid);
               text.append("Shop id persisted with id=" + cid);
           }
           catch (SQLException sqle)
           {
               String errText = "Error persisting cs after db connection made:\n" + sqle.getMessage() + " --- " + sqle.getSQLState() + "\n";
               logger.log(Level.SEVERE, errText);
               text.append(errText);
           }
           catch (Exception e)
           {
               logger.log(Level.SEVERE, "Error connecting to db.");
           }
//            return text.toString();
       }
   }
    */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Coffee_Shop> createShop(String jobj) throws IOException {
        logger.log(Level.INFO, "RECEIVED CREATE REQUEST FOR:\n");
        logger.log(Level.INFO, "OBJECT:" + jobj + "\n");
        
        LinkedList<Coffee_Shop> lshops = new LinkedList<Coffee_Shop>();

        ObjectMapper mapper = new ObjectMapper();
        Coffee_Shop shop = mapper.readValue(jobj.toString(), Coffee_Shop.class);
        
        StringBuilder text = new StringBuilder();
        text.append("The JSON obj:" + jobj.toString() + "\n");
        text.append("Hello " + shop.getCoffeeName() + "\n");
        text.append("Messages:\n");
//        if (user.getMessages() != null)
//            for (Object msg : user.getMessages())
//                text.append(msg.toString() + "\n");
        
        try {
            Model db = Model.singleton();
            Coffee_Shop shop = db.newCoffeeShop(shop);
            logger.log(Level.INFO, "shop persisted to db as cid=" + shop.getCid());
            text.append("Shop id persisted with id=" + shop.getCid());
            lshops.add(shop);
        }
        catch (SQLException sqle)
        {
            String errText = "Error persisting shop after db connection made:\n" + sqle.getMessage() + " --- " + sqle.getSQLState() + "\n";
            logger.log(Level.SEVERE, errText);
            text.append(errText);
        }
        catch (Exception e)
        {
            logger.log(Level.SEVERE, "Error connecting to db.");
        }
        
        return lshops;
}
}
