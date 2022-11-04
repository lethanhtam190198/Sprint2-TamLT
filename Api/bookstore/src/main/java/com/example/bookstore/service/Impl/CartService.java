package com.example.bookstore.service.Impl;

import com.example.bookstore.model.Cart;
import com.example.bookstore.repository.CartRepository;
import com.example.bookstore.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartService implements ICartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> findByCustomerId(Integer id) {
        return cartRepository.findByCustomerId(id);
    }

    @Override
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }
}
