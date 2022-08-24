package com.example.realestate.services;

import com.example.realestate.models.Feature;

import java.util.List;


public interface FeatureService {

    public List<Feature> findAll();
    public Feature findById(Long Id);
    public Feature saveFeature(Feature feature);
    public void deleteById(Long id);
    
}
