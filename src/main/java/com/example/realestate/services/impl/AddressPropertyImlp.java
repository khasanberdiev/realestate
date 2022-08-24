package com.example.realestate.services.impl;

import com.example.realestate.models.Address;
import com.example.realestate.models.Property;
import com.example.realestate.models.composite.AddressProperty;
import com.example.realestate.repositories.PropertyRepository;
import com.example.realestate.services.AddressPropertyService;
import com.example.realestate.services.AddressService;
import com.example.realestate.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressPropertyImlp implements AddressPropertyService{
    @Autowired
    private AddressService addressService;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyService propertyService;

    @Override
    public List<Property> findallProperties() {
        List<Property> allProperties=(List<Property>) propertyRepository.findAll();
        return allProperties;
    }

    @Override
    public Property saveProperty(AddressProperty addressProperty) {
        Address savedAddress=addressService.saveAddress(addressProperty.getAddress());
        Property property=addressProperty.getProperty();
        property.setAddress(savedAddress);
        Property savedProperty=propertyService.saveProperty(property);

        return savedProperty;
        
    }

    @Override
    public void deleteById(Long id) {
      
        
    }

    @Override
    public Property findById(Long id) {
        
        // Optional<Property> findProperyById=propertyRepository.findById(id);
       
        return null;
    }
    
}
