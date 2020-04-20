package com.tommybalestreri.hellospring.controllers;

import com.tommybalestreri.hellospring.data.DestinationRepository;
import com.tommybalestreri.hellospring.data.UserRepository;
import com.tommybalestreri.hellospring.models.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class DestinationController {

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private UserRepository userRepository;

//    @GetMapping("destination")
//    public String processDestinationPage(User user, Model model){
//        model.addAttribute("users", userRepository.findAll());
//        return "destination";
//    }

//    @GetMapping("destination")
//    public String destinationPage(@RequestParam Integer userId, Model model) {
//        Optional<User> result = userRepository.findById(userId);
//        User user = result.get();
//        model.addAttribute("destinationList", user.getDestinationList());
//        model.addAttribute(new Destination());
//        model.addAttribute("users",userRepository.findAll());
//        return "destination";
//    }

    @GetMapping("destination")
    public String destinationPage(@RequestParam Integer destinationId, Model model) {
        Optional<Destination> result = destinationRepository.findById(destinationId);
        Destination destination = result.get();
        model.addAttribute("userList", destination.getUserList());
        model.addAttribute(new Destination());
        model.addAttribute("destinations",destinationRepository.findAll());
        return "destination";
    }




//    @PostMapping
//    public String submitSuccessPage(User user, Model model){
//        model.addAttribute("users", userRepository.findAll());
//        return "";
//    }
}
