package com.ra.controller.user;

import com.ra.model.entity.WishList;
import com.ra.service.IWishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/v1/user/wishlist")
public class WishListController {
    @Autowired
    private IWishListService wishListService;
    @GetMapping("")
    public String getAll(){
        List<WishList> wishListList=wishListService.getAll();
        return "user/wishlist";
    }
}
