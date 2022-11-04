package com.example.bookstore.repository;

import com.example.bookstore.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    @Query(value = "select cart.* from cart join customer on customer.id = cart.customer_id where customer.id = :id", nativeQuery = true)
    List<Cart> findByCustomerId(@Param("id") Integer id);
}
