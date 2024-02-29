package com.ra.service;

import com.ra.model.entity.Role;

import java.util.List;

public interface IRoleService {
    Role findByRoleName(String name);
    List<Role> getAll();
}
