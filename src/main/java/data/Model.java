/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objects.User;
import objects.Coffee_Shop;
import objects.Review;



/**
 *
 * @author wlloyd
 * 
 * @author reid, tim, gabriel, chris
 */

public class Model {
    static final Logger logger = Logger.getLogger(Model.class.getName());
    private static Model instance;
    private Connection conn;
    //private LinkedList<Coffee_Shop> csList = new LinkedList<Coffee_Shop>();
    

    public static Model singleton() throws Exception {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    ////blabla
    Model() throws Exception
    {
        Class.forName("org.postgresql.Driver");
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        if ((dbUrl == null) || (dbUrl.length() < 1))
            dbUrl = System.getProperties().getProperty("DBCONN");
        logger.log(Level.INFO, "dbUrl=" + dbUrl);  
        logger.log(Level.INFO, "attempting db connection");
        conn = DriverManager.getConnection(dbUrl);
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


    private PreparedStatement createPreparedStatement(String sql) throws SQLException
    {
        Connection conn = getConnection();
        if ((conn != null) && (!conn.isClosed()))
        {
            logger.log(Level.INFO, "attempting statement create");
            PreparedStatement pst = conn.prepareStatement(sql);
            logger.log(Level.INFO, "prepared statement created");
            return pst;
        }
        else
        {
            // Handle connection failure
        }
        return null;
    }

    // users
    /////////////////////////////////////////////////////////////////////////

    public int newUser(User usr) throws SQLException
    {
        String sqlInsert="insert into users (username, password, email, fname, lname, utype) values ('" + usr.getUsername() + "', '" + usr.getPassword() + "', '" + usr.getEmail() +"', '" + usr.getFname() +"', '" + usr.getLname() +"', '" + usr.getUtype() + "');";
        Statement s = createStatement();
        logger.log(Level.INFO, "attempting statement execute");
        s.execute(sqlInsert,Statement.RETURN_GENERATED_KEYS);
        logger.log(Level.INFO, "statement executed.  atempting get generated keys");
        ResultSet rs = s.getGeneratedKeys();
        logger.log(Level.INFO, "retrieved keys from statement");
        int userid = -1;
        while (rs.next())
            userid = rs.getInt(4);   // assuming 4th column is userid
        logger.log(Level.INFO, "The new user id=" + userid);
        return userid;

    }

    

    public void deleteUser(int userid) throws SQLException
    {
        String sqlDelete="delete from users where userid=?";
        PreparedStatement pst = createPreparedStatement(sqlDelete);
        pst.setInt(1, userid);
        pst.execute();
    }

    

    public User[] getUsers() throws SQLException
    {
        LinkedList<User> ll = new LinkedList<User>();
        String sqlQuery ="select * from users;";
        Statement st = createStatement();
        ResultSet rows = st.executeQuery(sqlQuery);
        while (rows.next())
        {
            logger.log(Level.INFO, "Reading row...");
            User usr = new User();
            usr.setUsername(rows.getString("username"));
            usr.setPassword(rows.getString("password"));
            usr.setEmail(rows.getString("email"));
            usr.setFname(rows.getString("fname"));
            usr.setLname(rows.getString("lname"));
            usr.setUtype(rows.getString("utype"));
            usr.setUserId(rows.getInt("userid"));
            
            logger.log(Level.INFO, "Adding user to list with id=" + usr.getUserid());
            ll.add(usr);
        }
        return ll.toArray(new User[ll.size()]);
    }

    

    public boolean updateUser(User usr) throws SQLException
    {
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("update users ");
        sqlQuery.append("set username='" + usr.getUsername() + "', ");
        sqlQuery.append("password='" + usr.getPassword() + "', ");
        sqlQuery.append("email='" + usr.getEmail() + "', ");
        sqlQuery.append("fname='" + usr.getFname() + "', ");
        sqlQuery.append("lname='" + usr.getLname() + "', ");
        sqlQuery.append("utype='" + usr.getUtype() + "' ");
        sqlQuery.append("where userid=" + usr.getUserid() + ";");
        Statement st = createStatement();
        logger.log(Level.INFO, "UPDATE SQL=" + sqlQuery.toString());
        return st.execute(sqlQuery.toString());
    }

    // Shops
    /////////////////////////////////////////////////////////////////////////

    public int newCoffeeShop(Coffee_Shop cs) throws SQLException

    {
        String sqlInsert="insert into shops (coffee_name, coffee_address, raw_review, phone, website) values ("
                + "'" + cs.getCoffeeName() + "'" + ", " + "'" + cs.getCoffeeAddress()
                + "'" + "," + cs.getRawReview() + "," + "'" + cs.getPhone()
                + "'" + "," + "'" + cs.getUrl() + "'" +");";
        Statement s = createStatement();
        logger.log(Level.INFO, "attempting statement execute");
        s.execute(sqlInsert,Statement.RETURN_GENERATED_KEYS);
        logger.log(Level.INFO, "statement executed.  atempting get generated keys");
        ResultSet rs = s.getGeneratedKeys();
        logger.log(Level.INFO, "retrieved keys from statement");
        int shopid = -1;
        while (rs.next())
            shopid = rs.getInt(3);   // assuming 3rd column is userid
        logger.log(Level.INFO, "The new shop id=" + shopid);
        return cs.getCid();
    }

    

    public Coffee_Shop[] getCoffeeShops() throws SQLException {
        LinkedList<Coffee_Shop> ll = new LinkedList<Coffee_Shop>();
        String sqlQuery = "select * from shops;";
        Statement st = createStatement();
        ResultSet rows = st.executeQuery(sqlQuery);
        while (rows.next()) {
            logger.log(Level.INFO, "Reading row...");
            Coffee_Shop cs = new Coffee_Shop();
            cs.setCid(rows.getInt("cid"));
            cs.setCoffeeName(rows.getString("coffee_name"));
            cs.setCoffeeAddress(rows.getString("coffee_address"));
            cs.setRawReview(rows.getInt("raw_review"));
            cs.setPhone(rows.getString("phone"));
            cs.setUrl(rows.getString("website"));
            logger.log(Level.INFO, "Adding shop to list with id=" + cs.getCid());
            ll.add(cs);
        }
        return ll.toArray(new Coffee_Shop[ll.size()]);
    
    }


    public boolean updateCoffeeShop(Coffee_Shop cs) throws SQLException {
        StringBuilder sqlQuery = new StringBuilder();

        sqlQuery.append("update shops ");
        sqlQuery.append("coffee_name=" + cs.getCoffeeName() + ", ");
        sqlQuery.append("coffee_address=" + cs.getCoffeeAddress() + ", ");
        sqlQuery.append("raw_review=" + cs.getRawReview() + ", ");
        sqlQuery.append("phone=" + cs.getPhone() + ", ");
        sqlQuery.append("website=" + cs.getUrl() + ", ");
        sqlQuery.append("where cid=" + cs.getCid() +";");
        Statement st = createStatement();
        logger.log(Level.INFO, "UPDATE SQL=" + sqlQuery.toString());

        return st.execute(sqlQuery.toString());

    }

    // Reviews
    /////////////////////////////////////////////////////////////////////////
    
    
    public int createReview(Review rvw) throws SQLException
    {
        String sqlInsert="insert into reviews (date, text, rating, cid, userid) values (" + rvw.getDate() + "," + " '" + rvw.getText() + "', " + rvw.getRating() + ", " + rvw.getCid() + ", " + rvw.getUserid() + ");";
        Statement s = createStatement();
        logger.log(Level.INFO, "attempting statement execute");
        s.execute(sqlInsert,Statement.RETURN_GENERATED_KEYS);
        logger.log(Level.INFO, "statement executed.  atempting get generated keys");
        ResultSet rs = s.getGeneratedKeys();
        logger.log(Level.INFO, "retrieved keys from statement");
        int rid = -1;
        while (rs.next())
            rid = rs.getInt(6);   // assuming 3rd column is userid
        logger.log(Level.INFO, "The new rid=" + rid);
        return rid;

    }

    

    public void deleteReview(int rid) throws SQLException
    {
        String sqlDelete="delete from reviews where rid=?";
        PreparedStatement pst = createPreparedStatement(sqlDelete);
        pst.setInt(6, rid);
        pst.execute();
    }

    

    public Review[] getReviews() throws SQLException
    {
        LinkedList<Review> ll = new LinkedList<Review>();
        String sqlQuery ="select * from reviews;";
        Statement st = createStatement();
        ResultSet rows = st.executeQuery(sqlQuery);
        while (rows.next())
        {
            logger.log(Level.INFO, "Reading row...");
            Review rvw = new Review();
            rvw.setDate(rows.getDate("date"));
            rvw.setText(rows.getString("text"));
            rvw.setRating(rows.getInt("rating"));
            rvw.setUserid(rows.getInt("userid"));
            rvw.setCid(rows.getInt("cid"));
            logger.log(Level.INFO, "Adding review to list with id=" + rvw.getRid());
            ll.add(rvw);
        }
        return ll.toArray(new Review[ll.size()]);
    }

    

    public boolean updateReview(Review rvw) throws SQLException

    {
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("update reviews ");
        sqlQuery.append("set text='" + rvw.getText() + "', ");
        sqlQuery.append("rating=" + rvw.getRating() + " ");
        sqlQuery.append("where rid=" + rvw.getRid() + ";");
        Statement st = createStatement();
        logger.log(Level.INFO, "UPDATE SQL=" + sqlQuery.toString());
        return st.execute(sqlQuery.toString());
    }

    
}