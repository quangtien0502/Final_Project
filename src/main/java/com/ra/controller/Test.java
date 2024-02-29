package com.ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class Test {
    @RequestMapping("/v1/admin/home")
    public String test(){
        return "admin/index";
    }

    @RequestMapping("/test1")
    public String test1(){
        return "admin/add-new-product";
    }
}
