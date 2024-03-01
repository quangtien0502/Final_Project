package com.ra.service;

import com.ra.model.entity.Address;
import com.ra.model.entity.Orders;
import com.ra.model.entity.ShoppingCart;

import java.util.List;

public interface IShoppingCartService {
    List<ShoppingCart> getAll();
    ShoppingCart save(ShoppingCart shoppingCart);

    ShoppingCart findById(Long id);
    void deleteOneProductById(Long id);

    void deleteAllProductInShoppingCartOfUser();

    Orders checkout(Address address);

}
