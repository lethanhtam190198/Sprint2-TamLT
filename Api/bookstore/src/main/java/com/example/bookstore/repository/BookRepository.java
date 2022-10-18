package com.example.bookstore.repository;

import com.example.bookstore.dto.BookDto;
import com.example.bookstore.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "select book.* from book " +
            " join discount on book.discount = discount.id " +
            " where book.`status` =0 " +
            " order by discount.`percent` desc limit 6 ", nativeQuery = true)
    List<Book> findAllList1();


    @Query(value = "select * from book where status = 0 and id =:id", nativeQuery = true)
    Optional<Book> findByIdBook(@Param("id") Integer id);


    @Query(value = "select * from book where status = 0", nativeQuery = true)
    Page<Book> findAllList8(Pageable pageable);

    @Query(value = "select b.id,b.author,b.code, b.description, b.dimension, b.image, b.name, b.price, b.publisher, b.quantity , b.release_date, b.status, b.total_pages as totalPages, b.translator, c.name as category, d.percent as discount " +
            " from book b " +
            " join category c on b.category = c.id " +
            " join discount d on b.discount = d.id " +
            " where status =0 and c.name like :keyCategory and b.name like :keyName and b.author like :keyAuthor order by `id` desc", nativeQuery = true,
            countQuery = "select count(*) from(select b.id,b.author,b.code,b.description,b.dimension,b.image,b.name,b.price,b.publisher,b.quantity,b.release_date,b.status,b.total_pages as totalPages,b.translator,c.name as category,d.percent as discount " +
                    " from book b" +
                    " join category c on b.category = c.id " +
                    " join discount d on b.discount = d.id " +
                    " where status =0 and c.name like :keyCategory and b.name like :keyName and b.author like :keyAuthor order by `id` desc) as abc")
    Page<BookDto> findAllBook(Pageable pageable, @Param("keyCategory") String keyCategory, @Param("keyName") String keyName, @Param("keyAuthor") String keyAuthor);

    @Modifying
    @Query(value = "update book set status = 1 where `id` = :id", nativeQuery = true)
    void deleteBook(int id);

    @Query(value = "select * from book where status = 0 and category =1", nativeQuery = true)
    Page<Book> categoryBook(Pageable pageable);

    @Query(value = "select * from book where code=:code" ,nativeQuery = true)
    List<Book> checkCode(@Param("code")String code);

    @Query(value = "select * from book where status = 0 and category =:idCategory and name =:name", nativeQuery = true)
    Page<Book> getCategoryBook(Pageable pageable,@Param("idCategory") Integer idCategory,@Param("name") String name);
}
