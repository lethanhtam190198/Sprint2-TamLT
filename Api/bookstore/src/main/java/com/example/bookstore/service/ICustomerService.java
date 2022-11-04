package com.example.bookstore.service;

import com.example.bookstore.model.Customer;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer>findAllCustomer();
    Optional<Customer> findByCustomer(String username);
    Customer findHistoryByUsername(String username);
    Customer findByUsername(String username);
}
