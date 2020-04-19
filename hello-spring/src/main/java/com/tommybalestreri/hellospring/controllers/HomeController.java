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

//    private static List<String> destinations = new ArrayList<>();
//    private static List<Destination> destinations = new ArrayList<>();

//    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//    User user = (User)authentication.getPrincipal();
//    int userId = user.getId();

    @GetMapping
    public String homepage(@RequestParam Integer userId, Model model) {
        Optional<User> result = userRepository.findById(userId);
        User user = result.get();
//        model.addAttribute("destinations", DestinationData.getAll());
//        model.addAttribute("destinations", destinationRepository.findAll());
        model.addAttribute("destinations", destinationRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("destinationList", user.getDestinationList());
        model.addAttribute(new Destination());
        return "home";
//        return "home?userId=" + user.getId();
    }

//    @GetMapping
//    public String homepage(Model model) {
////        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
////        User.getPrincipal();
////        userRepository.findAll();
////        UserPrincipal user1 = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////        Integer userId = UserPrincipal.getId();
////        String userpassword = UserPrincipal.get
////        Optional<User> result = userRepository.findByUsername(UserPrincipal.getUsername());
////        User user = result.get();
////        model.addAttribute("destinations", DestinationData.getAll());
////        model.addAttribute("destinations", destinationRepository.findAll());
//        model.addAttribute("destinations", destinationRepository.findAll());
//        model.addAttribute("users", userRepository.findAll());
//        model.addAttribute("destinationList", user.getDestinationList());
//        model.addAttribute(new Destination());
////        return "home";
//        return "home?userId=" + user.getId();
//    }

    @PostMapping("home")
    public String addDestinationForm(@ModelAttribute Destination newDestination) {
//        User user = userDestination.getUser();
//        public String addDestinationForm(@RequestParam String destination) {
//        DestinationData.add(new Destination(destination));
//        DestinationData.add(newDestination);
        destinationRepository.save(newDestination);
        return "redirect:";
//        return "redirect:home?userId=" + user.getId();
    }

//    @GetMapping("detail")
//    public String displayUserDetails(@RequestParam Integer userId, Model model){
//        Optional<User> result = userRepository.findById(userId);
//
//        if (result.isEmpty()) {
//            model.addAttribute("title", "Invalid User Id: " + userId);
//        } else {
//            User user = result.get();
//            model.addAttribute("title", user.getUsername() + " Details");
//            model.addAttribute("user", user);
//        }
//
//        return "user/detail";
//    }



    @GetMapping("delete")
    public String displayDeleteDestinationForm(Model model){
        model.addAttribute("title", "Delete Destination");
//        model.addAttribute("destinations", DestinationData.getAll());
        model.addAttribute("destinations", destinationRepository.findAll());
        return "home/delete";
    }

//    @PostMapping("delete")
//    public String processDeleteDestinationForm(@RequestParam(required = false) int[] destinationIds){
//
//        if (destinationIds != null) {
//            for (int id : destinationIds) {
////                DestinationData.remove(id);
//                destinationRepository.deleteById(id);
//            }
//        }
//
//        return "redirect:";
//
//    }

    @PostMapping("delete")
    public String processDeleteUserForm(@RequestParam(required = false) int[] userIds){

        if (userIds != null) {
            for (int id : userIds) {
//                DestinationData.remove(id);
                userRepository.deleteById(id);
            }
        }

        return "redirect:";

    }

    // responds to home/add-dto?userId=X
    @GetMapping("add-dto")
    public String displayAddDestinationAndUserForm(@RequestParam Integer userId, Model model) {
        Optional<User> result = userRepository.findById(userId);
        User user = result.get();
        model.addAttribute("title", "Add DTO " + user.getUsername());
        model.addAttribute("destinationList", destinationRepository.findAll());
        model.addAttribute("user", user);
//        model.addAttribute("userDestination", new UserDestinationDTO());

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

        return "redirect:add-dto?userId=" + user.getId();
    }






}
