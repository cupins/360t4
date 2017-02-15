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
    Coffee_Shop(){}
    
    // Getter and Setters
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public String getCoffeeAddress() {
        return coffeeAddress;
    }

    public void setCoffeeAddress(String coffeeAddress) {
        this.coffeeAddress = coffeeAddress;
    }

    public int getRawReview() {
        return rawReview;
    }

    public void setRawReview(int rawReview) {
        this.rawReview = rawReview;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUrl() {
        return url;
    }

    //Determine fields getter/setters and constructors
    public void setUrl(String url) {
        this.url = url;
    }
    
}
