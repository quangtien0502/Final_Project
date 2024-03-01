package com.ra.controller;

import com.ra.model.entity.User;
import com.ra.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/permitAll")
public class AuthController {
    @Autowired
    private IUserService userService;

    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }


    @GetMapping("/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "admin/sign-up";
    }


    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user) {
        userService.handleRegister(user);
        return "redirect:/permitAll/login";
    }
}
