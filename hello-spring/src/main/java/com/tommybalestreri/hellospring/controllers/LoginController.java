package com.tommybalestreri.hellospring.controllers;

import com.tommybalestreri.hellospring.data.DestinationRepository;
import com.tommybalestreri.hellospring.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController implements WebMvcConfigurer {

        @Autowired
        private DestinationRepository destinationRepository;

        @Autowired
        private UserRepository userRepository;

        @GetMapping("login")
        public String login() {
                return "login";
        }

        public void doGet(HttpServletRequest request, HttpServletResponse response) {

                response.setContentType("text/html");
                request.getParameter("username");
        }

//    @GetMapping
//    public String homepage(@RequestParam Integer userId, Model model) {
//        Optional<User> result = userRepository.findById(userId);
//        User user = result.get();
//        model.addAttribute("destinationList", user.getDestinationList());
//        model.addAttribute(new Destination());
//        model.addAttribute("users",userRepository.findAll());
//        return "home";
//    }
//
//    @PostMapping("home")
//    public String addDestinationForm(@RequestParam Integer userId, @ModelAttribute User user, @ModelAttribute Destination newDestination, Model model) {
//        destinationRepository.save(newDestination);
//        model.addAttribute("user", user);
//        return "addeddestination";
//    }
//
//    @GetMapping("add-dto")
//    public String displayAddDestinationAndUserForm(@RequestParam Integer userId, Model model) {
//        Optional<User> result = userRepository.findById(userId);
//        User user = result.get();
//        model.addAttribute("title", "Add DTO " + user.getUsername());
//        model.addAttribute("destinationList", destinationRepository.findAll());
//        model.addAttribute("user", user);
//        UserDestinationDTO userDestination = new UserDestinationDTO();
//        userDestination.setUser(user);
//        model.addAttribute("userDestination", userDestination);
//        return "add-dto.html";
//    }
//
//    @PostMapping("add-dto")
//    public String processAddDestinationAndUserForm(@ModelAttribute UserDestinationDTO userDestination, Model model){
//
//        User user = userDestination.getUser();
//        Destination destination = userDestination.getDestination();
//        user.addDestination(destination);
//            userRepository.save(user);
//
//        return "redirect:?userId=" + user.getId();
//    }

}
