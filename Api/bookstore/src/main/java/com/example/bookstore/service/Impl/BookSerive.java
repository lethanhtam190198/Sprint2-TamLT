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
        return bookRepository.vietnameseLiterature(pageable);
    }

    @Override
    public Page<Book> foreignLiterature(Pageable pageable) {
        return bookRepository.foreignLiterature(pageable);
    }

    @Override
    public Page<Book> children(Pageable pageable) {
        return bookRepository.children(pageable);
    }

    @Override
    public Page<Book> politicalNews(Pageable pageable) {
        return bookRepository.politicalNews(pageable);
    }

}
