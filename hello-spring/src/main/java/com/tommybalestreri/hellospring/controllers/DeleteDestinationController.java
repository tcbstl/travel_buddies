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
//        model.addAttribute("destinations", user.userDes)
//        return "redirect:?userId=" + user.getId();
//        return "deletedestination?destinationId=" + destination.getId() + "userId=" +user.getId();
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
//        destination.removeUser(user);
//        user.getDestinationList().remove(destination);
//        user.removeDestination();
        destinationRepository.deleteById(destinationToInt);
//        DestinationListRepository.deleteById(destinationToInt);
//        user.getDestinationList().remove(destination);
//        user.getDestinationList().remove(destination);
//        UserDestinationDTO.delete()


//        if (destinationIds != null) {
//            for (int id : destinationIds) {
//                destinationRepository.deleteById(id);
//                EntityManager.em.re
//                getEntityManager().remove(id);

//        UserPrincipal.removeDestination()
//                UserService.removeDes

//                User user = this.user;

//                destination.removeUser();
//        user.removeDestination();

//                destination.remove
//                user(destination);
//                Destination destination = destinationRepository.findById(id);
//              User.     removeDestination(deleteDestination);

//        model.addAttribute("destinationList", destination);
//        model.addAttribute("user",user);


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
