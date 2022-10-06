package com.example.bookstore.service.Impl;

import com.example.bookstore.model.UserRole;
import com.example.bookstore.repository.UserRepository;
import com.example.bookstore.repository.UserRoleRepository;
import com.example.bookstore.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService implements IUserRoleService {

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }


    @Override
    public void save(UserRole userRole) {
        userRoleRepository.save(userRole.getAppRole().getId(), userRole.getAppUser().getId());
    }


    @Override
    public void deleteUserRole(int id) {
        userRoleRepository.deleteUserRole(id);
    }
}
