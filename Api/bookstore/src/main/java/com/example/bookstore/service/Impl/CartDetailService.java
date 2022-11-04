package com.example.bookstore.service.Impl;

import com.example.bookstore.model.CartDetail;
import com.example.bookstore.repository.CartDetailRepository;
import com.example.bookstore.service.ICartDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartDetailService implements ICartDetailService {

    @Autowired
    private CartDetailRepository cartDetailRepository;

    @Override
    public List<CartDetail> findAllCartDetail(Integer id) {
        return cartDetailRepository.findCartDetail(id);
    }

    @Override
    public CartDetail save(CartDetail cartDetail) {
        return cartDetailRepository.save(cartDetail);
    }
}
