package com.ra.service.Imp;

import com.ra.model.entity.Role;
import com.ra.model.entity.User;
import com.ra.repository.UserRepository;
import com.ra.service.IRoleService;
import com.ra.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User handleRegister(User user) {

        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("username is exists");
        }

        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findByRoleName("ROLE_USER"));

        User users = User.builder()
                .fullName(user.getFullName())
                .username(user.getUsername())
                .password(passwordEncoder.encode(user.getPassword()))
                .email(user.getEmail())
                .image(user.getImage())
                .phone(user.getPhone())
                .status(true)
                .roles(roles)
                .build();
        userRepository.save(users);
        return users;
    }

    @Override
    public User getAll() {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public User save(User users) {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public List<User> SearchByFullName(String keyword) {
        return null;
    }
}
