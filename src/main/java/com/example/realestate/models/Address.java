package com.example.realestate.models;


import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="address")
public class Address extends BaseEntity {
    @NotNull
    @Size(min = 1, max = 200, message 
      = "Title must be between 3 and 200 characters")
    private String houseNumber;

    @NotNull
    @Size(min = 1, max = 252, message 
      = "Title must be between 3 and 252 characters")
    private String street;

    @NotNull
    @Size(min = 1, max = 252, message 
      = "Title must be between 3 and 252 characters")
    private String city;

    @NotNull
    @Size(min = 1, max = 252, message 
      = "Title must be between 3 and 252 characters")
    private String region;

    @Size(min = 1, max = 252, message 
      = "Title must be between 3 and 252 characters")
    private String postalCode;

    @NotNull
    @Size(min = 1, max = 252, message 
      = "Title must be between 3 and 252 characters")
    private String country;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    @OneToOne(mappedBy = "address")
    private Property property;

    public Address(){

    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
    
    

}
