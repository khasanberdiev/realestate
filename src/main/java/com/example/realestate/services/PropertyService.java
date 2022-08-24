package com.example.realestate.services;

import com.example.realestate.models.Property;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PropertyService {
    List<Property> findALl();
    Property findById(Long id);
    Property saveProperty(Property property);
    void delete(Long id);
    Integer getMaxPrice();
    Integer getMinPrice();
    List<Property> getSearchResults(Integer pageNumber, Integer pageSize, String sortField, 
                                            String sortDirection, String searchQuery, String searchAddress,
                                            String searchPurpose, String type, String availableFrom,
                                            Integer minArea,  Integer minPrice);

    Page<Property> pagedSearch(Integer pageNumber, Integer pageSize, String sortField, 
                                String sortDirection, String searchQuery, String searchAddress,
                                String searchPurpose, String type, Integer minArea,
                                Integer maxArea );

    List<Property> filterByParams(Double latitude1, Double latitude2, Double longitude1, Double longitude2,
                                 Integer pageNumber, Integer pageSize, String sortField,
                                 String sortDirection, String searchQuery, String searchAddress,
                                 String searchPurpose, String type, String availableFrom,
                                 Integer minArea, Integer maxArea,  Integer minPrice);


}
