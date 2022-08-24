package com.example.realestate.models;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="feature")
public class Feature extends BaseEntity{

    @NotNull
    @Size(min=1, max=255, message="The length must be between 1 and 25 charachters ")
    private String featureName;
    private String description;

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Feature() {
    }

    public Feature(String featureName, String description) {
        this.featureName = featureName;
        this.description = description;
    }

}