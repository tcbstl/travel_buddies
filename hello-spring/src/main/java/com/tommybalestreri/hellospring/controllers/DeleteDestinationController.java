package com.tommybalestreri.hellospring.controllers;

import com.tommybalestreri.hellospring.data.DestinationRepository;
import com.tommybalestreri.hellospring.data.UserRepository;
import com.tommybalestreri.hellospring.models.Destination;
import com.tommybalestreri.hellospring.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class DeleteDestinationController {

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("deletedestination")
    public String displayDeleteEventForm(@RequestParam(name="destinationId") String destinationId, @RequestParam(name="userId") String userId, Model model) {
        int destinationToInt = Integer.parseInt(destinationId);
        int userToInt = Integer.parseInt(userId);
        model.addAttribute("title", "Delete Destinations");
        model.addAttribute("destinations", destinationRepository.findAll());
        Optional<User> result2 = userRepository.findById(userToInt);
        User user = result2.get();
        Optional<Destination> result = destinationRepository.findById(destinationToInt);
        Destination destination = result.get();
        model.addAttribute("destinationList", destination);
        model.addAttribute("user",user);
        return "deletedestination";
    }

    @PostMapping("deletedestination")
    public String processDeleteDestinationForm(@RequestParam String destinationId, @RequestParam String userId, Model model) {
        int destinationToInt = Integer.parseInt(destinationId);
        int userToInt = Integer.parseInt(userId);
        Optional<Destination> result = destinationRepository.findById(destinationToInt);
        Destination destination = result.get();
        Optional<User> result2 = userRepository.findById(userToInt);
        User user = result2.get();
        user.removeDestination(destination);
        destinationRepository.deleteById(destinationToInt);

        return "destinationdeletesuccess";
    }

}
