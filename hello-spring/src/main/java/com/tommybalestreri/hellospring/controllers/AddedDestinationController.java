package com.tommybalestreri.hellospring.controllers;

import com.tommybalestreri.hellospring.data.DestinationRepository;
import com.tommybalestreri.hellospring.data.UserRepository;
import com.tommybalestreri.hellospring.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddedDestinationController {

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("addeddestination")
    public String processDestinationPageAfter(User user, Model model){
        model.addAttribute("users", userRepository.findAll());
        return "addeddestination";
    }

    @PostMapping("addeddestination")
    public String submitDestinationPage(User user, Model model){
        model.addAttribute("users", userRepository.findAll());
        return "addeddestination";
    }

}
