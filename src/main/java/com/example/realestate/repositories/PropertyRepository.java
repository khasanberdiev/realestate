package com.example.realestate.repositories;

import com.example.realestate.models.Property;
import com.example.realestate.repositories.Custom.CustomPropertyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PropertyRepository extends JpaRepository<Property, Long>, CustomPropertyRepository{

    @Query(value="select *from property where (title=:searchQuery or :searchQuery is null or :searchQuery = '')", nativeQuery=true)
    Page<Property> findByTitle(@Param("searchQuery") String searchQuery, Pageable pageable);

}