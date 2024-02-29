package com.ra.controller.user;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/user")
public class HomeControllerUser {
    @GetMapping("/home")
    public String home(){
        return "user/index";
    }
}
