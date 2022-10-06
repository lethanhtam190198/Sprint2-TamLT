package com.example.bookstore.service.Impl;

import com.example.bookstore.model.Discount;
import com.example.bookstore.repository.DiscountRepository;
import com.example.bookstore.service.IDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService implements IDiscountService {
    @Autowired
    private DiscountRepository discountRepository;
    @Override
    public List<Discount> findAllDiscount() {
        return discountRepository.findAll();
    }
}
