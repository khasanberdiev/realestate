package com.example.realestate.services;

import com.example.realestate.models.Property;
import com.example.realestate.models.composite.AddressProperty;

import java.util.List;

public interface AddressPropertyService {
    List<Property> findallProperties();
    Property saveProperty(AddressProperty addressPropertyComposite);
    void deleteById(Long id);
    Property findById(Long id);

    
}
