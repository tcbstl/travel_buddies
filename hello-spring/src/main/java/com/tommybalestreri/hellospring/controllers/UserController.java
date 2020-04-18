package com.tommybalestreri.hellospring.controllers;

import com.tommybalestreri.hellospring.data.UserService;
import com.tommybalestreri.hellospring.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    @Autowired private UserService userService;

    @GetMapping("users")
    public String findAll(Model model) {
        return "user";
    }

    @PostMapping(value="users/addNew")
    public RedirectView addNew(User user, RedirectAttributes redir) {
        userService.save(user);
        RedirectView redirectView= new RedirectView("/login", true);
            redir.addFlashAttribute("message", "Registration successful");
            return redirectView;
        }

    }


