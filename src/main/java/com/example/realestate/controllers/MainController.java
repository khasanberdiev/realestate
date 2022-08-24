package com.example.realestate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/backoffice")
public class MainController {
    
    @GetMapping({"", "/main"})
    public String index(Model model){

        return "backoffice/index";
    }

    @GetMapping("/view")
    public String view(Model model){

        return "backoffice/form";
    }

}
