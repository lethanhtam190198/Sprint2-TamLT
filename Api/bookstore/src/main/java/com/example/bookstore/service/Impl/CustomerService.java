package com.example.bookstore.service.Impl;

import com.example.bookstore.model.Customer;
import com.example.bookstore.repository.CustomerRepository;
import com.example.bookstore.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }
}
