package com.example.realestate.repositories;

import com.example.realestate.models.Address;
import com.example.realestate.models.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findByProperty(Property property);
    
}
