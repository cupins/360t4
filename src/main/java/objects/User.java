/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author Reid
 */
public class User {

    private String username;
    private String password;
    private String email;
    private String Fname;
    private String Lname;
    private char utype;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public char getUtype() {
        return utype;
    }

    public void setUtype(char utype) {
        this.utype = utype;
    }
    
    private int userid;
    
    public int getUserid() {
        return userid;
    }
    
    public void setUserId(int userid)
    {
        this.userid = userid;
    }
    
}


