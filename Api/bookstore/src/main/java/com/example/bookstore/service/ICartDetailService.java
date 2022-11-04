package com.example.bookstore.service;

import com.example.bookstore.model.CartDetail;

import java.util.List;

public interface ICartDetailService {
    List<CartDetail> findAllCartDetail(Integer id);
    CartDetail save(CartDetail cartDetail);
}
