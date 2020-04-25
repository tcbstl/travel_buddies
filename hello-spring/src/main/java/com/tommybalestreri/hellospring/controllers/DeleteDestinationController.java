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

//    Optional<User> result = userRepository.findById(userId);
//    User user = result.get();
//        model.addAttribute("destinationList", user.getDestinationList());

    @GetMapping("deletedestination")
    public String displayDeleteEventForm(@RequestParam Integer destinationId, @RequestParam Integer userId, Model model) {
        model.addAttribute("title", "Delete Destinations");
        model.addAttribute("destinations", destinationRepository.findAll());
        Optional<User> result2 = userRepository.findById(userId);
        User user = result2.get();
        Optional<Destination> result = destinationRepository.findById(destinationId);
        Destination destination = result.get();
        model.addAttribute("destinationList", destination);
//        model.addAttribute("destinations", user.userDes)
//        return "redirect:?userId=" + user.getId();
        return "deletedestination?destinationId=" + destination.getId() + "userId=" +user.getId();
    }

    @PostMapping("deletedestination")
    public String processDeleteDestinationForm(@RequestParam Integer destinationId, @RequestParam Integer userId, Model model) {

//        if (destinationIds != null) {
//            for (int id : destinationIds) {
//                destinationRepository.deleteById(id);
//                EntityManager.em.re
//                getEntityManager().remove(id);
                Optional<Destination> result = destinationRepository.findById(destinationId);
                Destination destination = result.get();
//        UserPrincipal.removeDestination()
//                UserService.removeDes
                Optional<User> result2 = userRepository.findById(userId);
//                User user = this.user;
                User user = result2.get();
//                destination.removeUser();
//        user.removeDestination();
                user.removeDestination(destination);
//                user(destination);
//                Destination destination = destinationRepository.findById(id);
//              User.     removeDestination(deleteDestination);




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
