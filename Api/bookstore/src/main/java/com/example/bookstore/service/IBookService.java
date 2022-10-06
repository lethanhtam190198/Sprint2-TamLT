package com.example.bookstore.service;

import com.example.bookstore.dto.BookDto;
import com.example.bookstore.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book> findAll();

    Page<Book> findAllList8(Pageable pageable);

    Optional<Book> findById(Integer id);

    Page<BookDto> findAllBooks(Pageable pageable, String keyCategory, String keyName, String keyAuthor);

    void save(Book book);

    void deleteBook(int id);

    Page<Book>vietnameseLiterature(Pageable pageable);
    Page<Book>foreignLiterature(Pageable pageable);
    Page<Book>children(Pageable pageable);
    Page<Book>politicalNews(Pageable pageable);
}
