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
    private String coffee_name;
    private String coffee_address;
    private int raw_review;
    private String phone;
    private String website;
    
    
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
        return coffee_name;
    }

    public void setCoffeeName(String coffee_name) {
        this.coffee_name = coffee_name;
    }
    
    // Coffee shop address
    public String getCoffeeAddress() {
        return coffee_address;
    }

    public void setCoffeeAddress(String coffee_address) {
        this.coffee_address = coffee_address;
    }
    
    // raw score for all reviews for this (cid) coffee shop
    public int getRawReview() {
        return raw_review;
    }

    public void setRawReview(int raw_review) {
        this.raw_review = raw_review;
    }
    
    // phone number for coffee shop
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    // URL for coffee shop
    public String getUrl() {
        return website;
    }

    //Determine fields getter/setters and constructors
    public void setUrl(String website) {
        this.website = website;
    }
    
}
