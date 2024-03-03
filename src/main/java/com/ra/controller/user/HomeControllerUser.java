package com.ra.controller.user;


import com.ra.model.entity.*;
import com.ra.service.ICategoryService;
import com.ra.service.IProductService;
import com.ra.service.IShoppingCartService;
import com.ra.service.IWishListService;
import com.ra.service.Imp.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/v1/user")
public class HomeControllerUser {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IProductService productService;

    @Autowired
    private IShoppingCartService shoppingCartService;

    @Autowired
    private IWishListService wishListService;

    @Autowired
    private CommonService commonService;

    @GetMapping("/home")
    public String home(Model model){
       List<Category> categoryList= categoryService.getAllEnable();
       List<Product> productList=productService.getAllEnable();
       List<ShoppingCart> shoppingCartList=shoppingCartService.getAll();
       List<WishList> wishListList=wishListService.getAll();
       List<Product> productInWishList=wishListList.stream().map(WishList::getProduct).toList();
       User user=commonService.findUserIdInContext();
       model.addAttribute("categoryList",categoryList);
       model.addAttribute("productList",productList);
       model.addAttribute("shoppingCartList",shoppingCartList);
       model.addAttribute("productInWishList",productInWishList);
       model.addAttribute("user",user);
        return "user/index";
    }
}
