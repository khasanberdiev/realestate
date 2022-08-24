package com.example.realestate.services;

import com.example.realestate.models.Category;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import java.util.List;

public interface CategoryService {
    Category findById(Long id) throws NotFoundException;
    Category saveCategory(Category category);
    // void updateCategory(Category category);
    void deleteById(Long id);
    List <Category> findAll();
    void fillingCategory();
    
    
}
