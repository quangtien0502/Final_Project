package com.ra.service.Imp;

import com.ra.model.entity.Role;
import com.ra.repository.RoleRepository;
import com.ra.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role findByRoleName(String name) {
        return roleRepository.findByName(name).orElseThrow(()->new RuntimeException("No Role Found With This Name"));
    }

    @Override
    public List<Role> getAll() {
        return null;
    }
}
