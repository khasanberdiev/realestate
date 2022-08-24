package com.example.realestate.services.impl;


import com.example.realestate.models.Property;
import com.example.realestate.repositories.PropertyRepository;
import com.example.realestate.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;




@Service
public class PropertyServiceImpl implements PropertyService{

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private EntityManager entityManager;

    // @Autowired
    // private PictureService pictureService;


    @Override
    public Property saveProperty(Property property){
        return propertyRepository.save(property);
    }

    @Override
    public List<Property> findALl() {
        List<Property> properties=(List<Property>) propertyRepository.findAll();
        return properties;
    }

   
    public Property findById(Long id) {

        Optional<Property> propertyOptional = propertyRepository.findById(id);

        if (!propertyOptional.isPresent()) {
            // throw new Exception("Recipe Not Found. For ID value: " + id.toString() );
            //  NotFoundException("Recipe Not Found. For ID value: " + id.toString() );
        }

        return propertyOptional.get();
    }

    @Override
    public void delete(Long id) {
        propertyRepository.deleteById(id);

        
    }

    @Override
    public Integer getMaxPrice() {
      String sqlString = "SELECT max(Price) FROM property ";
      Integer maxPrice=0;
      Number singleResult = ((Number) entityManager.createNativeQuery(sqlString).getSingleResult());

        if(singleResult!=null){
            maxPrice = singleResult.intValue();
        }
      return maxPrice;
      
      
    }

    @Override
    public Integer getMinPrice() {
        Integer minPrice =0;
        String sqlString = "SELECT min(Price) FROM property ";
        Number singleResult = ((Number) entityManager.createNativeQuery(sqlString).getSingleResult());
        if(singleResult!=null){
            minPrice = singleResult.intValue();
        }
      return minPrice;
    }


    @Override
    public List<Property> getSearchResults(Integer pageNumber, Integer pageSize, String sortField, 
                                            String sortDirection, String searchQuery, String searchAddress,
                                            String searchPurpose, String type, String availableFrom, Integer minArea, Integer maxArea
                                           ){

       List<Property> searchResults=propertyRepository.findSearchResults(pageNumber, pageSize, sortField, sortDirection,
                                                                            searchQuery, searchPurpose, type, availableFrom,
                                                                            minArea, maxArea);

       return searchResults;
    }

    @Override
    public Page<Property> pagedSearch(Integer pageNumber, Integer pageSize, String sortField, 
                                        String sortDirection, String searchQuery, String searchAddress,
                                        String searchPurpose, String type, Integer minArea,
                                        Integer maxArea ) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
            Sort.by(sortField).descending();
        Pageable pageable  = PageRequest.of(pageNumber - 1, pageSize, sort);
        System.out.println(pageable);
        // return propertyRepository.findByAllParam(searchQuery, searchAddress, searchPurpose, 
        //                                                     type, minArea, maxArea, pageable );
        return propertyRepository.findByTitle(searchQuery, pageable);
        // return null;
       
    }

    @Override
    public List<Property> filterByParams(Double latitude1, Double latitude2, Double longitude1, Double longitude2,
                                         Integer pageNumber, Integer pageSize, String sortField, String sortDirection, String searchQuery,
                                         String searchAddress, String searchPurpose, String type, String availableFrom, Integer minArea,
                                         Integer maxArea, Integer minPrice) {

        List<Property> filteredResuts=propertyRepository.filterByParams(latitude1, latitude2, longitude1, longitude2,
                pageNumber,  pageSize, sortField, sortDirection, searchQuery,
                searchAddress, searchPurpose, type,  availableFrom, minArea,
                 maxArea, minPrice);
        System.out.println(filteredResuts);
        return filteredResuts;
    }


}
