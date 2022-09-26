package com.example.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<UserRoles> userRoles;


    @OneToMany(mappedBy = "users")
    @JsonIgnore
    private List<Customer> customers;

    public Users() {
    }

    public Users(Integer id, String userName, String password, List<UserRoles> userRoles, List<Customer> customers) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.userRoles = userRoles;
        this.customers = customers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserRoles> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRoles> userRoles) {
        this.userRoles = userRoles;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
