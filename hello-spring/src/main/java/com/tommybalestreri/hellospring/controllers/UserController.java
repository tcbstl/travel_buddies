package com.tommybalestreri.hellospring.controllers;

import com.tommybalestreri.hellospring.data.UserService;
import com.tommybalestreri.hellospring.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired private UserService userService;

    @GetMapping("users")
    public String findAll(Model model) {
        return "user";
    }

    @GetMapping("register")
    public String register(Model model) {
        model.addAttribute(new User());
        return "register";
    }

    @PostMapping(value="register")
    public String addNew(@ModelAttribute @Valid User user,
                               Errors errors, Model model) {

        if(errors.hasErrors()){
            return "register";
        }

        userService.save(user);
        return "login";
    }

    }


