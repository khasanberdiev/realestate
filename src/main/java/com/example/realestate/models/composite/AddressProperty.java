package com.example.realestate.models.composite;


import com.example.realestate.models.Address;
import com.example.realestate.models.Property;

public class AddressProperty {
    private Address address;
    private Property property;
    // private Picture picture;

    public AddressProperty(Address address, Property property){
        this.address=address;
        this.property=property;
    }

    public AddressProperty(){
        
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    
 

    
}
