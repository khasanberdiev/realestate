package com.example.realestate.services.impl;

import com.example.realestate.models.Feature;
import com.example.realestate.repositories.FeatureRepository;
import com.example.realestate.services.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FeatureServiceImpl implements FeatureService{

    @Autowired
    private FeatureRepository featureRespository;

    @Override
    public List<Feature> findAll() {
        List<Feature> featuresList=featureRespository.findAll();
        return featuresList;
    }

    @Override
    public Feature findById(Long id){
       Optional<Feature> getFeature =featureRespository.findById(id);
    //    if(!getFeature.isPresent()){
    //         throw new NotFoundException( "not found");
    //    }             
        
        return getFeature.get();
    }

    @Override
    public Feature saveFeature(Feature feature) {
        return featureRespository.save(feature);
        
    }

    @Override
    public void deleteById(Long id) {
        featureRespository.deleteById(id);
        
    }

   
    



}