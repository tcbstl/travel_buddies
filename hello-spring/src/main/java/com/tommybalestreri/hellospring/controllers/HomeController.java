package com.tommybalestreri.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController implements WebMvcConfigurer {

    //Basic homepage without any thymeleaf functionality
//        @GetMapping
//        public String homepage() {
//            return "home";
//        }

    //Attempting to add list of destinations
    @GetMapping
    public String homepage(Model model) {
        List<String> destinations = new ArrayList<>();
        destinations.add("Paris");
        destinations.add("St. Louis");
        destinations.add("Africa");
        model.addAttribute("destinations", destinations);
        return "home";
    }



//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String homepage(@RequestParam String destination, Model model) {
//        String enteredDestination = destination;
//        model.addAttribute("enteredDestination", enteredDestination);
//        return "home";
//    }


}
