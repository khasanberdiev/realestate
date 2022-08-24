package com.example.realestate.controllers;

import com.example.realestate.models.Property;
import com.example.realestate.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/rest")
public class FilterRestController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/loadCoordinates")
    @ResponseBody
    public ModelAndView index (
                                @RequestParam("pageNumber") Integer pageNumber,
                                @RequestParam("pageSize") Integer pageSize,
                                @RequestParam("pageField") String pageField,
                                @RequestParam("sortDirection") String sortDirection,
                                @RequestParam("searchQuery") String searchQuery,
                               @RequestParam("searchAddress") String searchAddress,
                               @RequestParam("purpose") String purpose,
                               @RequestParam("type") String type,
                               @RequestParam("minArea") Integer minArea,
                               @RequestParam("maxArea") Integer maxArea) {

        ModelAndView modelAndView = new ModelAndView();
//        String availableFrom = null;
        List<Property> searchByCriteria=propertyService.getSearchResults(pageNumber, pageSize, pageField, sortDirection, searchQuery, searchAddress, purpose, type, null, minArea, maxArea);

        System.out.println(searchByCriteria);
        List<Property> list=propertyService.findALl();
        modelAndView.addObject("properties", list);

        modelAndView.setViewName("frontoffice/delete");
        return modelAndView;
    }

    @GetMapping("/loadBorderChangeData")
    @ResponseBody
    public ModelAndView index2 (
            @RequestParam("latitude1") Double latitude1,
            @RequestParam("latitude2") Double latitude2,
            @RequestParam("longitude1") Double longitude1,
            @RequestParam("longitude2") Double longitude2,
            @RequestParam("pageNumber") Integer pageNumber,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("sortField") String sortField,
            @RequestParam("sortDirection") String sortDirection,
            @RequestParam("searchQuery") String searchQuery,
            @RequestParam("searchAddress") String searchAddress,
            @RequestParam("purpose") String searchPurpose,
            @RequestParam("type") String type,
            @RequestParam("minArea") Integer minArea,
            @RequestParam("maxArea") Integer maxArea,
            @RequestParam("availableFrom") String availableFrom

            ) {
        Integer minPrice=0;
        ModelAndView modelAndView = new ModelAndView();
        List<Property> searchByCriteria=propertyService.filterByParams(latitude1, latitude2, longitude1, longitude2,
                pageNumber, pageSize, sortField, sortDirection, searchQuery, searchAddress, searchPurpose, type, availableFrom,
                minArea, maxArea,  minPrice);
        System.out.println("esarch criteria");
        System.out.println(searchByCriteria);
//        List<Property> list=propertyService.findALl();
        modelAndView.addObject("properties", searchByCriteria);

        modelAndView.setViewName("frontoffice/delete");
        return modelAndView;
    }


//    @GetMapping("/loadBorderChangeData")
//    @ResponseBody
//    public ModelAndView loadBorderChangeData (
////            @RequestParam("borders") String borders,
//            @RequestParam("pageNumber") Integer pageNumber,
//            @RequestParam("pageSize") Integer pageSize,
//            @RequestParam("pageField") String pageField,
//            @RequestParam("sortDirection") String sortDirection,
//            @RequestParam("searchQuery") String searchQuery,
//            @RequestParam("searchAddress") String searchAddress,
//            @RequestParam("purpose") String purpose,
//            @RequestParam("type") String type,
//            @RequestParam("minArea") Integer minArea,
//            @RequestParam("maxArea") Integer maxArea) {
//
//        ModelAndView modelAndView = new ModelAndView();
//        System.out.println("rest controller success");
////        String availableFrom = null;
//        List<Property> searchByCriteria=propertyService.getSearchResults(pageNumber, pageSize, pageField, sortDirection, searchQuery, searchAddress, purpose, type, null, minArea, maxArea);
//
//        System.out.println("hi rudopo");
//        List<Property> list=propertyService.findALl();
//        modelAndView.addObject("properties", list);
//
//        modelAndView.setViewName("frontoffice/delete");
//        return modelAndView;
//    }


}
