package com.example.bookstore.service;

import com.example.bookstore.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAllCategory();
}
