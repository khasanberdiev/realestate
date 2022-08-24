package com.example.realestate.services.impl;

import com.example.realestate.models.Category;
import com.example.realestate.repositories.CategoryRepository;
import com.example.realestate.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceImp implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;



    @Override
    public Category findById(Long id) throws NotFoundException {
        Optional<Category> category = categoryRepository.findById(id);

        if (!category.isPresent()) {
            throw new NotFoundException( );
        }
        return category.get();
              
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
       
    }

    // public void updateCategory(Category category) {
    //     Category category = categoryRepository.findById(category.getId());
    //     if(category!=null){
    //         category.setCategoryName(category.getCategoryName());
    //         category.setCategoryDescription(category.getCategoryDescription());
          
    //     }
    // }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> findAll() {
        List<Category> allCategories=categoryRepository.findAll();
        return allCategories;
    }

    public void fillingCategory(){
        Category cat=new Category();
        cat.setCategoryName("Apartment");
        categoryRepository.save(cat);
    }
    
}
