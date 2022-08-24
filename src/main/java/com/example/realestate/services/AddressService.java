package com.example.realestate.services;

import com.example.realestate.models.Address;
import com.example.realestate.models.Property;

import java.util.List;

public interface AddressService {
    public List<Address>findAll();
    public Address findByPropertyId(Property pproperty);

    public Address saveAddress(Address address);
}
