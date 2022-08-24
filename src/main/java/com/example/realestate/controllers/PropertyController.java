package com.example.realestate.controllers;

import com.example.realestate.models.Address;
import com.example.realestate.models.Picture;
import com.example.realestate.models.Property;
import com.example.realestate.models.composite.AddressProperty;

import com.example.realestate.models.enums.Status;
import com.example.realestate.services.*;
import com.example.realestate.utils.GenerateRandomName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("backoffice/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AddressPropertyService addressPropertyService;

    @Autowired
    private PictureService pictureService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private  FilesStorageService filesStorageService;


  


    @GetMapping({"", "/", "/index", "/index/"})
    public String index(Model model){
        model.addAttribute("properties", propertyService.findALl());
        return "backoffice/property/index";
    }

    @GetMapping("/new")
    public String create(Model model){
//        categoryService.fillingCategory();

        model.addAttribute("composite", new AddressProperty());
        model.addAttribute("categoryList", categoryService.findAll());
        return "backoffice/property/form";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){

        Property getProperty=propertyService.findById(id);
        Address getAddress=addressService.findByPropertyId(getProperty);
        AddressProperty addressProperty=new AddressProperty();
        addressProperty.setProperty(getProperty);
        addressProperty.setAddress(getAddress);

              
        model.addAttribute("composite", addressProperty);
        model.addAttribute("categoryList", categoryService.findAll());
        return  "backoffice/property/form";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") Long id, Model model){

        model.addAttribute("property", propertyService.findById(id));

        return "backoffice/property/view";
    }

    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(@Valid @RequestParam("files") MultipartFile[] pictures, @ModelAttribute AddressProperty addressPropertyComposite,  BindingResult bindingResult, Model model){
        
        if(bindingResult.hasErrors()){
            // bindingResult.getAllErrors().forEach(objectError -> {
            //     System.out.println(objectError.toString());
            // });
            return "backoffice/property/form";
        }

        Property savedProperty=addressPropertyService.saveProperty(addressPropertyComposite);
        Long getId=savedProperty.getId();
        GenerateRandomName randomUniqueName=new GenerateRandomName();
        try {
            List<Picture> fileList = new ArrayList<Picture>();
            for (MultipartFile mfile : pictures) {
                String fileContentType = mfile.getContentType();
                String sourceFileContent = new String(mfile.getBytes(), StandardCharsets.UTF_8);
                String fileName = randomUniqueName.RandomNames()+mfile.getOriginalFilename();
                Picture fileModal = new Picture(fileName, sourceFileContent, fileContentType, savedProperty, Status.active);
                filesStorageService.save(mfile, fileName);
                fileList.add(fileModal);

            }
                pictureService.saveAllPictureList(fileList);
     
            } catch (Exception e) {
                e.printStackTrace();
            }
       return "redirect:view/"+getId;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")  Long id){
        propertyService.delete(id);
        return "redirect:/";
    }

    

    
    
}
