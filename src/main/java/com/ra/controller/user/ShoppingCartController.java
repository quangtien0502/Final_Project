package com.ra.controller.user;

import com.ra.model.entity.ShoppingCart;
import com.ra.service.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/v1/user/shopping-cart")
public class ShoppingCartController {
    @Autowired
    private IShoppingCartService shoppingCartService;
    @GetMapping("")
    public String getAll(){
        List<ShoppingCart> shoppingCartList=shoppingCartService.getAll();
        return "user/index";
    }
}
