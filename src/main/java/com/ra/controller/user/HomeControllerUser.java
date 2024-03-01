package com.ra.controller.user;


import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.service.ICategoryService;
import com.ra.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/v1/user")
public class HomeControllerUser {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IProductService productService;

    @GetMapping("/home")
    public String home(Model model){
       List<Category> categoryList= categoryService.getAllEnable();
       List<Product> productList=productService.getAllEnable();
       model.addAttribute("categoryList",categoryList);
       model.addAttribute("productList",productList);
        return "user/index";
    }
}
