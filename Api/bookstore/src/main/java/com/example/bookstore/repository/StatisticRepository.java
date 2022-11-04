package com.example.bookstore.repository;

import com.example.bookstore.dto.StatisticDto;
import com.example.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface StatisticRepository extends JpaRepository<Book, Integer> {
    @Query(value = "select book.name as name, sum(cd.quantity) as sumQuantity" +
            " from book join cart_detail cd on book.id = cd.book_id" +
            " join cart c on cd.cart_id = c.id" +
            " where c.date_create between :start_date and :end_date" +
            " group by cd.book_id yorder by sum(cd.quantity)" +
            " desc limit 10", nativeQuery = true)
    List<StatisticDto> getSellingBookTop10(@Param("start_date") String start_date,
                                           @Param("end_date") String end_date);
}
