package com.ra.service;

import com.ra.model.entity.Orders;
import com.ra.model.entity.User;
import com.ra.model.enums.OrderStatus;

import java.util.List;

public interface IUserService {
    User handleRegister(User user);
    User getAll();
    User findById(Long id);
    void delete(Long id);
    User save(User users);
    User findByUsername(String username);
    List<User> SearchByFullName(String keyword);
    String updatePassword(String oldPassword,String newPassword);

    List<User> findUserByFullName(String keyword);

    User findByUserName(String userName);

    List<Orders> orderedHistory(OrderStatus orderStatus);

    String changeUserStatus(Long userId);
}
