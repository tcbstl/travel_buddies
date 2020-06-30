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
        return "register";
    }

//This works!
//    @PostMapping(value="users/addNew")
//    public RedirectView addNew(User user, RedirectAttributes redir) {
//        userService.save(user);
//        RedirectView redirectView= new RedirectView("/login", true);
//            redir.addFlashAttribute("message", "Registration successful");
//            return redirectView;
//        }

    //Trying something new
    @PostMapping(value="register")
    public String addNew(@ModelAttribute @Valid User user,
                               Errors errors, Model model) {

//        if(errors.hasErrors()){
//            RedirectView redirectView= new RedirectView("/register", true);
//            redir.addFlashAttribute("message", "Registration unsuccessful");
////            model.addAttribute("message", "Registration unsuccessful");
//            return redirectView;
//        }

        if(errors.hasErrors()){
//            RedirectView redirectView= new RedirectView("/register", true);
//            redir.addFlashAttribute("message", "Registration unsuccessful");
            model.addAttribute("errorMsg", "Registration unsuccessful");
            return "register";
        }

        userService.save(user);
//        RedirectView redirectView= new RedirectView("/login", true);
//        redir.addFlashAttribute("message", "Registration successful");
        return "login";
    }

    }


