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
    private String coffeeAddress;
    private int rawReview;
    private String phone;
    private String url;
    
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
    public String getCoffeeAddress() {
        return coffeeAddress;
    }

    public void setCoffeeAddress(String coffeeAddress) {
        this.coffeeAddress = coffeeAddress;
    }
    
    // raw score for all reviews for this (cid) coffee shop
    public int getRawReview() {
        return rawReview;
    }

    public void setRawReview(int rawReview) {
        this.rawReview = rawReview;
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
        return url;
    }

    //Determine fields getter/setters and constructors
    public void setUrl(String url) {
        this.url = url;
    }
    
}
