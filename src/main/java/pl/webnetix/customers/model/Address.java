package pl.webnetix.customers.model;

import javax.persistence.*;

@Embeddable
public class Address {

    private String city, building, street, postcode, country;

    public Address() {
    }

    public Address(String city, String building, String street, String postcode, String country) {
        this.city = city;
        this.building = building;
        this.street = street;
        this.postcode = postcode;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
