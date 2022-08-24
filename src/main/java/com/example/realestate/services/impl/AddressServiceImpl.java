package com.example.realestate.services.impl;

import com.example.realestate.models.Address;
import com.example.realestate.models.Property;
import com.example.realestate.repositories.AddressRepository;
import com.example.realestate.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> findAll(){
        List<Address> allAddress=addressRepository.findAll();
        return allAddress;

    }
    @Override
    public Address saveAddress(Address address){
        return addressRepository.save(address);
    }
    @Override
    public Address findByPropertyId(Property property) {
        Address getAddressByProperty=addressRepository.findByProperty(property);
        return getAddressByProperty;
    }
    
    
}
