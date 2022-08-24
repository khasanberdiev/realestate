package com.example.realestate.repositories.Custom;

import com.example.realestate.models.Property;

import java.util.List;

public interface CustomPropertyRepository {

    List<Property> filterByParams(Double upperRightBorder, Double upperLeftBorder, Double lowerRightBorder, Double lowerleftBorder,
                                  Integer pageNumber, Integer pageSize, String sortField, String sortDirection, String searchQuery,
                                  String searchAddress, String searchPurpose, String type, String availableFrom, Integer minArea,
                                  Integer maxArea, Integer minPrice );

    List<Property> findSearchResults(Integer pageNumber, Integer pageSize, String sortField,
                                     String sortDirection, String searchQuery,
                                     String searchPurpose, String type, String availableFrom, Integer minArea, Integer maxArea);
    
}
