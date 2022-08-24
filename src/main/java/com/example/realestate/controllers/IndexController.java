package com.example.realestate.controllers;

import com.example.realestate.models.Picture;
import com.example.realestate.models.Property;
import com.example.realestate.models.SearchCriteria;
import com.example.realestate.services.CategoryService;
import com.example.realestate.services.PictureService;
import com.example.realestate.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping({"/index", "", "/main", "/home"})
public class IndexController {

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PictureService pictureService;

    @GetMapping("/")
    public String main(Model model){


        return "frontoffice/index";
    }

    @GetMapping({"/property/", "/list"})
    public String list(Model model, Integer pageNumber, Integer pageSize, String sortField, 
                                    String sortDirection, String searchQuery, String searchAddress,
                                    String searchPurpose, String type, String availableFrom, Integer minArea,
                                    Integer maxArea ){
        
        return pagedList(model, 1, 5, "id", "desc", searchQuery, 
                        searchAddress, searchAddress, type, "", minArea, maxArea);
    }



    @RequestMapping(value = "/loadCoordinates", method = RequestMethod.GET)
    public @ResponseBody String loadCityByCountry(@RequestBody SearchCriteria searchCriteria) {
        // List<Property> cities = propertyService.findALl();
        return "frontoffice/delete";
    }

    @GetMapping("/list/page/{pageNumber}")
    public String pagedList(Model model, @PathVariable("pageNumber") Integer pageNumber,
                                        @RequestParam("pageSize") Integer pageSize,
                                        @RequestParam("sortField") String sortField,
                                        @RequestParam("sortDirection") String sortDirection,
                                        @RequestParam("searchQuery") String searchQuery,
                                        @RequestParam("address") String searchAddress,
                                        @RequestParam("purpose") String purpose,

                                        @RequestParam("type") String type,
                                        @RequestParam("availableFrom") String availableFrom,
                                        @RequestParam("minArea") Integer minArea,
                                        @RequestParam("maxArea") Integer maxArea
                                         ){
        // List<Property> allProperties=propertyService.findALl();
        Page<Property> paged=propertyService.pagedSearch(pageNumber, pageSize, sortField, sortDirection, 
                                                            searchQuery, searchAddress, purpose,  type, 
                                                             minArea, maxArea);
                                                        
        List<Property>  allProperties=paged.getContent();
        List<Property>  searchByCriteria=paged.getContent();
//        List<Property> searchByCriterias=propertyService.getSearchResults(pageNumber, pageSize, sortField, sortDirection,
//                                                                 searchQuery, searchAddress, purpose, type,
//                                                                 availableFrom, minArea, maxArea);

        for(int i=0; i<searchByCriteria.size(); i++){
            System.out.println("this is image list");
//            for(int j=0; j<searchByCriteria.get(i).getPicture().size(); j++){
//                System.out.println(searchByCriteria.get(i).getPicture().get(j).getFileName().length());
//            }
//            System.out.println(searchByCriteria.get(i).getPicture().get(0).getFileName());
        }
        model.addAttribute("allProperties", allProperties);
        model.addAttribute("searchQuery", searchQuery);
        model.addAttribute("allsearch", searchByCriteria);
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("maxPrice", 0);
        model.addAttribute("minPrice", propertyService.getMinPrice());
        model.addAttribute("all_properties", searchByCriteria);

//        model.addAttribute("all_properties", allProperties);
        return "frontoffice/list";
    }
    @GetMapping("/view/{id}")
    public String view(Model model, @PathVariable("id") Long id){
        Property property=propertyService.findById(id);
        List<Picture> imageFiles=pictureService.findPictureByPropertyId(id);
        System.out.println(imageFiles);
        for(Picture i:imageFiles){
            System.out.println(i.getFileName());
        }

        model.addAttribute("images", imageFiles);
        model.addAttribute("property", property);
        return "frontoffice/single_property_view";
    }

    
}
