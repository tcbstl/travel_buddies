//package com.tommybalestreri.hellospring.controllers;
//
//import com.tommybalestreri.hellospring.models.UserDto;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.context.request.WebRequest;
//
//public class RegistrationController {
//
//    @GetMapping("/registration")
//    public String showRegistrationForm(WebRequest request, Model model) {
//        UserDto userDto = new UserDto();
//        model.addAttribute("user", userDto);
//        return "registration";
//    }
//
//}
