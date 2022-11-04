package com.example.bookstore.controller;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.Customer;
import com.example.bookstore.service.Impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/public/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/detail/{username}")
    public ResponseEntity<Optional<Customer>> detailCustomer(@PathVariable String username) {
        Optional<Customer> customersDetail = customerService.findByCustomer(username);
        if (!customersDetail.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customersDetail, HttpStatus.OK);
    }
}
