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
public class SuccessController {

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("success")
    public String processSuccessPageAfter(User user, Model model){
        model.addAttribute("users", userRepository.findAll());
        return "success";
    }

    @PostMapping
    public String submitSuccessPage(User user, Model model){
        model.addAttribute("users", userRepository.findAll());
        return "";
    }

}
