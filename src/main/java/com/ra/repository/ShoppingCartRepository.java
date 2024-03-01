package com.ra.repository;

import com.ra.model.entity.Product;
import com.ra.model.entity.ShoppingCart;
import com.ra.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {

    List<ShoppingCart> findByUser(User user);

    Boolean existsByUserAndProduct(User user, Product product);

    ShoppingCart findByUserAndProduct(User user,Product product);

    void deleteShoppingCartsByUser(User user);
}
