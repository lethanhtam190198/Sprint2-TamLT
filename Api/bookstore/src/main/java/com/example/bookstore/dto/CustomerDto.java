package com.example.bookstore.dto;

import com.example.bookstore.model.AppUser;

import javax.validation.constraints.NotNull;

public class CustomerDto {
    private Integer id;
    @NotNull
    private String name;
    private String birthday;
    private Integer gender;
    private String address;
    private String phone;
    @NotNull
    public String email;
    private Boolean status;
    private AppUser username;

    public CustomerDto() {
    }

    public CustomerDto(Integer id, String name, String birthday, Integer gender, String address, String phone, String email, Boolean status, AppUser username) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public AppUser getUsername() {
        return username;
    }

    public void setUsername(AppUser username) {
        this.username = username;
    }
}
