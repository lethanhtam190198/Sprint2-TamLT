package com.example.bookstore.service;

import com.example.bookstore.model.Cart;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICartService {
    List<Cart> findByCustomerId(Integer id);
    Cart save(Cart cart);
}
