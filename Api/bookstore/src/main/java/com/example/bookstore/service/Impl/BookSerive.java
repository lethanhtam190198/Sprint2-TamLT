package com.example.bookstore.service.Impl;

import com.example.bookstore.dto.BookDto;
import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookSerive implements IBookService {

    @Autowired
    private BookRepository bookRepository;


    @Override
    public List<Book> findAll() {
        return bookRepository.findAllList1();
    }

    @Override
    public Page<Book> findAllList8(Pageable pageable) {
        return bookRepository.findAllList8(pageable);
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return bookRepository.findByIdBook(id);
    }

    @Override
    public Page<BookDto> findAllBooks(Pageable pageable, String keyCategory, String keyName, String keyAuthor) {
        return bookRepository.findAllBook(pageable, "%" + keyCategory + "%", "%" + keyName + "%", "%" + keyAuthor + "%");
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteBook(id);
    }

    @Override
    public Page<Book> vietnameseLiterature(Pageable pageable) {
        return bookRepository.categoryBook(pageable);
    }

    @Override
    public Boolean existCode(String code) {
        return code.equals(bookRepository.checkCode(code));
    }

    @Override
    public Page<Book> getCategoryBook(Pageable pageable, Integer idCategory, String name) {
        return bookRepository.getCategoryBook(pageable,idCategory,name);
    }

}
