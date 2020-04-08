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

    private static List<String> destinations = new ArrayList<>();

    //Attempting to add list of destinations
    @GetMapping
    public String homepage(Model model) {
        model.addAttribute("destinations", destinations);
        return "home";
    }

    @PostMapping("home")
    public String addDestinationForm(@RequestParam String destination) {
        destinations.add(destination);
//        return "home";
        return "redirect:";
    }



//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String homepage(@RequestParam String destination, Model model) {
//        String enteredDestination = destination;
//        model.addAttribute("enteredDestination", enteredDestination);
//        return "home";
//    }


}
