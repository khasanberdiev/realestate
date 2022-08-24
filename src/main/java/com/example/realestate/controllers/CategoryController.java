package com.example.realestate.controllers;

import com.example.realestate.models.Category;
import com.example.realestate.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/backoffice/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping({"", "/index", "/main"})
    public String index(Model model){
        List <Category> categories=categoryService.findAll();
        model.addAttribute("categories", categories);
        return "backoffice/category/index";
    }

    @GetMapping("/new")
    public String create(Model model){
        model.addAttribute("categories", new Category());
        return "backoffice/category/form";

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) throws NotFoundException{
        model.addAttribute("categories", categoryService.findById(id));
        return "backoffice/category/form";
    }

    @GetMapping("/view/{id}")
    public String view(Model model, @PathVariable("id") Long id) throws NotFoundException{
        model.addAttribute("category", categoryService.findById(id));
        return "backoffice/category/view";
    }

    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(@Valid @ModelAttribute("categories") Category category, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/";
        }
        Category savedCategory=categoryService.saveCategory(category);
        return "redirect:view/"+savedCategory.getId();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        categoryService.deleteById(id);
        return "redirect:/backoffice/category";
    }


}
