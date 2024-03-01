package com.ra.service;

import com.ra.model.entity.WishList;

import java.util.List;

public interface IWishListService {
    List<WishList> getAll();
    WishList save(WishList wishList);
    WishList findById(Integer id);
    void deleteById(Integer id);

}
