package com.example.bookstore.dto;

import java.util.List;

public class CartDto {
    private String dateCreate;
    private Integer id;
    private List<CartDetailDto> cartDetailDtoList;

    public CartDto() {
    }

    public CartDto(String dateCreate, Integer id) {
        this.dateCreate = dateCreate;
        this.id = id;
    }

    public CartDto(String dateCreate, Integer id, List<CartDetailDto> cartDetailDtoList) {
        this.dateCreate = dateCreate;
        this.id = id;
        this.cartDetailDtoList = cartDetailDtoList;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<CartDetailDto> getCartDetailDtoList() {
        return cartDetailDtoList;
    }

    public void setCartDetailDtoList(List<CartDetailDto> cartDetailDtoList) {
        this.cartDetailDtoList = cartDetailDtoList;
    }
}
