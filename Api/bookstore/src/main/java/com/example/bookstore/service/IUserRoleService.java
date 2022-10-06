package com.example.bookstore.service;


import com.example.bookstore.model.UserRole;

import java.util.List;

public interface IUserRoleService {

    List<UserRole> findAll();

    void save(UserRole userRole);

    void deleteUserRole(int id);

}
