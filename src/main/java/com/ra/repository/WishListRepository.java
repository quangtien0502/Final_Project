package com.ra.repository;

import com.ra.model.entity.User;
import com.ra.model.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishListRepository extends JpaRepository<WishList,Long> {
    List<WishList> getAllByUser(User user);
}
