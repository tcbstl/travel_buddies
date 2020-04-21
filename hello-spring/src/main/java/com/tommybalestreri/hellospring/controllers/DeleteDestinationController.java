package com.tommybalestreri.hellospring.controllers;

import com.tommybalestreri.hellospring.data.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteDestinationController {

    @Autowired
    private DestinationRepository destinationRepository;

//    @Autowired
//    private UserRepository userRepository;

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Destinations");
        model.addAttribute("destinations", destinationRepository.findAll());
        return "delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] destinationIds) {

        if (destinationIds != null) {
            for (int id : destinationIds) {
                destinationRepository.deleteById(id);
            }
        }

        return "destinationdeletesuccess";
    }

//    @GetMapping("delete")
//    public String displayDeleteDestinationForm(Model model){
//        model.addAttribute("title", "Delete Destination");
//        model.addAttribute("destinations", destinationRepository.findAll());
//        return "home/delete";
//    }
//
//    @PostMapping("delete")
//    public String processDeleteUserForm(@RequestParam(required = false) int[] userIds){
//
//        if (userIds != null) {
//            for (int id : userIds) {
//                userRepository.deleteById(id);
//            }
//        }
//
//        return "redirect:";
//    }









}
