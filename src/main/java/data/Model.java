/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import com.mycompany.sample_maven_web_app.UserService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import objects.User;

/**
 *
 * @author wlloyd
 */
public class Model {
    static final Logger logger = Logger.getLogger(Model.class.getName());

    private static String PG_URL = "postgres://wxojhmodfpbmsv:80cfef5defecd78ff44e5e2bab48a26b06f930d1f57e097a6be957be98358c53@ec2-54-235-204-221.compute-1.amazonaws.com:5432/d19m0j1erhvr7v";
    private Properties dbprops = new Properties();
    
    private static String USR = "wxojhmodfpbmsv";
    private static String PWD = "80cfef5defecd78ff44e5e2bab48a26b06f930d1f57e097a6be957be98358c53";
    private static Model instance;
    private Connection conn;
    
    public static Model singleton() throws Exception {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }
    
    Model() throws Exception
    {
        Class.forName("org.postgresql.Driver");
        dbprops.setProperty("user", USR);
        dbprops.setProperty("password", PWD);
        dbprops.setProperty("ssl", "true");
          
        logger.log(Level.INFO, "attempting db connection");
        conn = DriverManager.getConnection(PG_URL, dbprops);
        logger.log(Level.INFO, "db connection ok.");
    }
    
    private Connection getConnection()
    {
        return conn;
    }
    
    private Statement createStatement() throws SQLException
    {
        Connection conn = getConnection();
        if ((conn != null) && (!conn.isClosed()))
        {
            logger.log(Level.INFO, "attempting statement create");
            Statement st = conn.createStatement();
            logger.log(Level.INFO, "statement created");
            return st;
        }
        else
        {
            // Handle connection failure
        }
        return null;
    }
    
    public void newUser(User usr) throws SQLException
    {
        String sqlInsert="insert into users (name, age) values ('" + usr.getName() + "'" + "," + usr.getAge() + ");";
        Statement s = createStatement();
        logger.log(Level.INFO, "attempting statement execute");
        s.execute(sqlInsert,Statement.RETURN_GENERATED_KEYS);
        logger.log(Level.INFO, "statement executed.  atempting get generated keys");
        ResultSet rs = s.getGeneratedKeys();
        logger.log(Level.INFO, "retrieved keys from statement");
    }
    
    public void newMessage(User usr) throws SQLException
    {
        //String sqlInsert="insert into messages ("
    }
}
