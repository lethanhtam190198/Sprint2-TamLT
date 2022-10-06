package com.example.bookstore.service.Impl;

import com.example.bookstore.model.Category;
import com.example.bookstore.repository.CategoryRepository;
import com.example.bookstore.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }
}
