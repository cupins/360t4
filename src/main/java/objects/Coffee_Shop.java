/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author reid
 */
public class Coffee_Shop {
    
    private int cid;
    private String name;
    private String city;
    private String state;
    private String zip;
    private String description;
    private String phone;
    private String address;
    private int opentime;
    private int closetime;
    
    
    // Constructor
    public Coffee_Shop(){}
    
    // Getter and Setters
    
    // Coffee shop id 
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
    
    //Coffee shop name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    // Coffee shop address
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
    // Coffee shop address
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    // Coffee shop address
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    
    // raw score for all reviews for this (cid) coffee shop
    public int getOpentime() {
        return opentime;
    }

    public void setOpentime(int opentime) {
        this.opentime = opentime;
    }
    // raw score for all reviews for this (cid) coffee shop
    public int getClosetime() {
        return closetime;
    }

    public void setClosetime(int closetime) {
        this.closetime = closetime;
    }
    
    // phone number for coffee shop
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    

   
    
}
