package com.example.bookstore.controller;

import com.example.bookstore.dto.BookDto;
import com.example.bookstore.dto.BooksDto;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.Category;
import com.example.bookstore.model.Customer;
import com.example.bookstore.model.Discount;
import com.example.bookstore.service.IBookService;
import com.example.bookstore.service.ICategoryService;
import com.example.bookstore.service.ICustomerService;
import com.example.bookstore.service.IDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/public/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IDiscountService discountService;

    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public ResponseEntity<List<Book>> getAll() {
        List<Book> getList = bookService.findAll();
        if (getList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(getList, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Optional<Book>> detailBooks(@PathVariable int id) {
        Optional<Book> detailBooks = bookService.findById(id);
        if (detailBooks == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(detailBooks, HttpStatus.OK);
    }

    @GetMapping("/list2")
    public ResponseEntity<Page<Book>> getAll2(@RequestParam(name = "page", defaultValue = "0") int page) {
        Sort sort = Sort.by("price").descending();
        Page<Book> getList1 = bookService.findAllList8(PageRequest.of(page, 12, sort));
        if (getList1.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(getList1, HttpStatus.OK);
    }

    @GetMapping("/listAllBook")
    public ResponseEntity<Page<BookDto>> getList(@PageableDefault(value = 8) Pageable pageable,
                                                 @RequestParam Optional<String> keyCategory,
                                                 @RequestParam Optional<String> keyName,
                                                 @RequestParam Optional<String> keyAuthor) {
        String nameSearch1 = keyCategory.orElse("");
        String nameSearch2 = keyName.orElse("");
        String nameSearch3 = keyAuthor.orElse("");
        Page<BookDto> listAllBooks = bookService.findAllBooks(pageable, nameSearch1, nameSearch2, nameSearch3);
        if (listAllBooks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listAllBooks, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Book> create(@RequestBody Book book) {
        book.setStatus(false);
        bookService.save(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategory() {
        List<Category> listCategory = categoryService.findAllCategory();
        if (listCategory.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listCategory, HttpStatus.OK);
    }

    @GetMapping("/discount")
    public ResponseEntity<List<Discount>> getAllDiscount() {
        List<Discount> listDiscount = discountService.findAllDiscount();
        if (listDiscount.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listDiscount, HttpStatus.OK);
    }

    @PutMapping("delete/{id}")
    public ResponseEntity<Optional<Book>> deleteBook(@PathVariable Integer id) {
        Optional<Book> book = bookService.findById(id);
        if (!book.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        bookService.deleteBook(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> update(@PathVariable int id, @Valid @RequestBody BooksDto bookDto) {
        Optional<Book> book = bookService.findById(id);
        if (!book.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        book.get().setCode(bookDto.getCode());
        book.get().setAuthor(bookDto.getAuthor());
        book.get().setDescription(bookDto.getDescription());
        book.get().setDimension(bookDto.getDimension());
        book.get().setImage(bookDto.getImage());
        book.get().setName(bookDto.getName());
        book.get().setPrice(bookDto.getPrice());
        book.get().setPublisher(bookDto.getPublisher());
        book.get().setQuantity(bookDto.getQuantity());
        book.get().setReleaseDate(bookDto.getReleaseDate());
        book.get().setTotalPages(bookDto.getTotalPages());
        book.get().setTranslator(bookDto.getTranslator());
        book.get().setCategory(bookDto.getCategory());
        book.get().setDiscount(bookDto.getDiscount());
        bookService.save(book.get());
        return new ResponseEntity<>(book.get(), HttpStatus.OK);
    }
    @GetMapping("/categoryBook")
    public ResponseEntity<Page<Book>> getAll(Pageable pageable) {
        Page<Book> getList = bookService.vietnameseLiterature(pageable);
        if (getList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(getList, HttpStatus.OK);
    }
    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> customerList = customerService.findAllCustomer();
        if (customerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping("/check/{code}")
    public ResponseEntity<?> checkCode(@PathVariable("code") String code) {
        return new ResponseEntity<>(bookService.existCode(code), HttpStatus.OK);
    }
    @GetMapping("/categoryBooks")
    public ResponseEntity<Page<Book>> getCategoryVn(@RequestParam(defaultValue = "",required = false) String name,
                                                    @RequestParam(defaultValue = "0",required = false) Integer idCategory,
                                                    @PageableDefault(value = 8) Pageable pageable){
        Page<Book> listVn = bookService.getCategoryBook(pageable,idCategory,name);
        if (listVn.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listVn,HttpStatus.OK);
    }
}
