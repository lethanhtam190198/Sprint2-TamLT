package com.example.bookstore.repository;

import com.example.bookstore.model.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartDetailRepository extends JpaRepository<CartDetail, Integer> {
    @Query(value = "select cart_detail.*, book.* from cart_detail join cart on cart.id = cart_detail.cart_id join book on book.id = cart_detail.book_id where cart_id = :id", nativeQuery = true)
    List<CartDetail> findCartDetail(@Param("id") Integer id);
}
