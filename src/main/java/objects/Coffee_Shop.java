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
    private String coffeeName;
    private String city;
    private String stat;
    private String zip;
    private String description;
    private String phone;
    private int opentime;
    private int clostime;
    
    
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
    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }
    
    // Coffee shop address
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    // Coffee shop address
    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
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
    public int getClostime() {
        return clostime;
    }

    public void setClostime(int clostime) {
        this.clostime = clostime;
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
