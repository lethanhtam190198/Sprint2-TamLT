package com.example.bookstore.dto;

import java.util.List;

public class HistoryDto {
    private Integer id;
    private String name;
    private String address;
    private String phone;
    private List<CartDto> cartDtoList;

    public HistoryDto() {
    }

    public HistoryDto(Integer id, String name, String address, String phone, List<CartDto> cartDtoList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.cartDtoList = cartDtoList;
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

    public List<CartDto> getCartDtoList() {
        return cartDtoList;
    }

    public void setCartDtoList(List<CartDto> cartDtoList) {
        this.cartDtoList = cartDtoList;
    }
}
