package com.example.bookstore.repository;

import com.example.bookstore.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer" +
            " join app_user on customer.user_id=app_user.id " +
            " where username =:username", nativeQuery = true)
    Optional<Customer> findByCustomer(@Param("username")String username);

    @Query(value = "select customer.* from customer join app_user on app_user.id = customer.user_id where app_user.username = :username", nativeQuery = true)
    Customer findHistoryByUsername(@Param("username") String username);

    @Query(value = "select * from customer" +
            " join app_user on customer.user_id=app_user.id " +
            " where username =:username", nativeQuery = true)
    Customer findByUsername(@Param("username")String username);
}
