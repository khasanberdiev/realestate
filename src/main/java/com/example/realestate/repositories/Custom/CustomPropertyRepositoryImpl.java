package com.example.realestate.repositories.Custom;

import com.example.realestate.models.Property;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class CustomPropertyRepositoryImpl implements CustomPropertyRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Property> filterByParams(Double latitude1, Double latitude2, Double longitude1, Double longitude2,
                                         Integer pageNumber, Integer pageSize, String sortField, String sortDirection, String searchQuery,
                                         String searchAddress, String searchPurpose, String type, String availableFrom, Integer minArea,
                                         Integer maxArea, Integer minPrice) {
        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery<Property> query=cb.createQuery(Property.class);
        Root<Property> properties = query.from(Property.class);

        List<Predicate> predicates = new ArrayList<>();
        System.out.println("rudopo found");


        predicates.add(cb.between(properties.get("address").get("latitude"), latitude1, latitude2));
        predicates.add(cb.between(properties.get("address").get("longitude"), longitude1, longitude2));
        if(searchQuery!=null && !searchQuery.isEmpty() && searchQuery!=""){
            predicates.add(cb.like(properties.get("title"), searchQuery));
        }

//        if(searchQuery!=null && !searchPurpose.isEmpty()){
//            predicates.add(cb.like(properties.get("purpose"), searchPurpose ));
//        }

        if(minArea!=null &&  minArea>0 ){
            predicates.add(cb.greaterThanOrEqualTo(properties.get("size"), minArea));
        }

        if(maxArea!=null &&  maxArea>0 && maxArea>=minArea){
            predicates.add(cb.lessThanOrEqualTo(properties.get("size"), maxArea));
        }

        if(predicates.isEmpty()){
            predicates.add(cb.equal(properties.get("id"), -1));

        }

        query.select(properties).where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        List<Property> results=entityManager.createQuery(query).setFirstResult(pageNumber-1).setMaxResults(pageSize).getResultList();
        for(Property p:results){
            System.out.println(p.getTitle());
        }
        return  results;


    }

    @Override
    public List<Property> findSearchResults(Integer pageNumber, Integer pageSize, String sortField,
                                            String sortDirection, String searchQuery, String searchPurpose,
                                            String type, String availableFrom, Integer minArea, Integer maxArea) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Property> query = cb.createQuery(Property.class);
        Root<Property> properties = query.from(Property.class);
            
        List<Predicate> predicates = new ArrayList<>();
       
        // if(!searchPurpose.isEmpty() && searchPurpose!=null ){
        //     predicates.add(cb.equal(properties.get("searchPurpose"), searchPurpose));
            
        // }

        if(searchQuery!=null && !searchQuery.isEmpty()   ){
            predicates.add(cb.like(properties.get("title"), searchQuery));
            // predicates.add(cb.like(properties.get("description"), searchQuery));
        }


        if(minArea!=null &&  minArea>0){
            predicates.add(cb.greaterThanOrEqualTo(properties.get("size"), minArea));
        }
        if(maxArea!=null &&  maxArea>0 && maxArea>=minArea){
            predicates.add(cb.lessThanOrEqualTo(properties.get("size"), maxArea));
        }

        if(predicates.isEmpty()){
            predicates.add(cb.equal(properties.get("id"), -1));
           
        }
        
       
        query.select(properties).where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        return entityManager.createQuery(query).setFirstResult(pageNumber-1).setMaxResults(pageSize).getResultList();
       
        
    }

   
    
}
