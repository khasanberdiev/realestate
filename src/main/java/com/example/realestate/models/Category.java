package com.example.realestate.models;


import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
//@Table(name="category")
public class Category extends BaseEntity {

    @NotNull(message = "Category name cannot be empty")
    @Size(min = 2, max = 20, message 
      = "Category name must be between 2 and 20 characters")
    private String categoryName;

    @Size(min = 2, max = 200, message 
      = "Category description must be between 2 and 200 characters")
    private String categoryDescription;

    public Category(){}

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}
