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
public class Share {
    private int Sid;

    public int getSid() {
        return Sid;
    }

    public void setSid(int Sid) {
        this.Sid = Sid;
    }
    private String name;
    private String city;
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    private String zip;
    private String phone;
    private int opentime;
    private int closetime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getOpentime() {
        return opentime;
    }

    public void setOpentime(int opentime) {
        this.opentime = opentime;
    }

    public int getClosetime() {
        return closetime;
    }

    public void setClosetime(int closetime) {
        this.closetime = closetime;
    }
           
}
