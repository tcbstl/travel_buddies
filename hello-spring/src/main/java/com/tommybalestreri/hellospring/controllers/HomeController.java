package com.tommybalestreri.hellospring.controllers;

import com.tommybalestreri.hellospring.data.DestinationRepository;
import com.tommybalestreri.hellospring.data.UserRepository;
import com.tommybalestreri.hellospring.models.Destination;
import com.tommybalestreri.hellospring.models.User;
import com.tommybalestreri.hellospring.models.dto.UserDestinationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Optional;

@Controller
public class HomeController implements WebMvcConfigurer {

        @Autowired
        private DestinationRepository destinationRepository;

        @Autowired
        private UserRepository userRepository;

    @GetMapping
    public String homepage(@RequestParam Integer userId, Model model) {
        Optional<User> result = userRepository.findById(userId);
        User user = result.get();
        model.addAttribute("destinationList", user.getDestinationList());
        model.addAttribute(new Destination());
        model.addAttribute("users",userRepository.findAll());
        return "home";
    }

    @PostMapping("home")
    public String addDestinationForm(@ModelAttribute User user, @ModelAttribute Destination newDestination, Model model) {
        destinationRepository.save(newDestination);
        model.addAttribute("user", user);
        return "addeddestination";
    }

    @GetMapping("delete")
    public String displayDeleteDestinationForm(Model model){
        model.addAttribute("title", "Delete Destination");
        model.addAttribute("destinations", destinationRepository.findAll());
        return "home/delete";
    }

    @PostMapping("delete")
    public String processDeleteUserForm(@RequestParam(required = false) int[] userIds){

        if (userIds != null) {
            for (int id : userIds) {
                userRepository.deleteById(id);
            }
        }

        return "redirect:";
    }

    @GetMapping("add-dto")
    public String displayAddDestinationAndUserForm(@RequestParam Integer userId, Model model) {
        Optional<User> result = userRepository.findById(userId);
        User user = result.get();
        model.addAttribute("title", "Add DTO " + user.getUsername());
        model.addAttribute("destinationList", destinationRepository.findAll());
        model.addAttribute("user", user);
        UserDestinationDTO userDestination = new UserDestinationDTO();
        userDestination.setUser(user);
        model.addAttribute("userDestination", userDestination);
        return "add-dto.html";
    }

    @PostMapping("add-dto")
    public String processAddDestinationAndUserForm(@ModelAttribute UserDestinationDTO userDestination, Model model){

        User user = userDestination.getUser();
        Destination destination = userDestination.getDestination();
        user.addDestination(destination);
            userRepository.save(user);

        return "redirect:?userId=" + user.getId();
    }



}
