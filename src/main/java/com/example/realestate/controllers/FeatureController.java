package com.example.realestate.controllers;


import com.example.realestate.models.Feature;
import com.example.realestate.services.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/backoffice/feature")
public class FeatureController {
    
    @Autowired
    private FeatureService featureService;

    @GetMapping({"", "/", "/index"})
    public String index(Model model){
        model.addAttribute("features", featureService.findAll());
        return "backoffice/feature/index";
    }

    @GetMapping("/new")
    public String create(Model model){
        model.addAttribute("feature", new Feature());
        return "backoffice/feature/form";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, Model model){
        model.addAttribute("feature", featureService.findById(id));
        return "/backoffice/feature/view";    
    }

    @PostMapping("/saveOrUpdate")
    public String save(@Valid @ModelAttribute("features") Feature  feature, BindingResult bindingResult){
        if(bindingResult.hasErrors() ){
            return "redirect:/";
        }
        Feature savedFeature=featureService.saveFeature(feature);;

        return "redirect:view/"+savedFeature.getId();
        
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        Feature getFeature=featureService.findById(id);
        model.addAttribute("feature", getFeature);
        return "backoffice/feature/form";
        
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        featureService.deleteById(id);
        return "redirect:/backoffice/feature";        
    }
    
}
