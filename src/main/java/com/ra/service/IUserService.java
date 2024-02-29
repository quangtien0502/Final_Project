package com.ra.service;

import com.ra.model.entity.User;
import java.util.List;

public interface IUserService {
    User handleRegister(User user);
    User getAll();
    User findById(Long id);
    void delete(Long id);
    User save(User users);
    User findByUsername(String username);
    List<User> SearchByFullName(String keyword);
}
