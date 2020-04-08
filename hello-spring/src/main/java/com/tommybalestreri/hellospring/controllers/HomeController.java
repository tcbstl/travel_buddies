package com.tommybalestreri.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController implements WebMvcConfigurer {

    private static List<String> destinations = new ArrayList<>();

    @GetMapping
    public String homepage(Model model) {
        model.addAttribute("destinations", destinations);
        return "home";
    }

    @PostMapping("home")
    public String addDestinationForm(@RequestParam String destination) {
        destinations.add(destination);
        return "redirect:";
    }

}
