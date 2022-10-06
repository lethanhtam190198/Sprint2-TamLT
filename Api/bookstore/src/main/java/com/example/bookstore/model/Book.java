package com.example.bookstore.model;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String code;
    private String description;
    private String dimension;
    private String image;
    private String publisher;
    private Integer quantity;
    private String releaseDate;
    private Double price;
    private Integer totalPages;
    private String translator;
    private boolean status;
    private String author;

    @ManyToOne
    @JoinColumn(name = "discount", referencedColumnName = "id")
    private Discount discount;

    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "id")
    private Category category;

    public Book() {
    }

    public Book(Integer id, String name, String code, String description, String dimension, String image, String publisher, Integer quantity, String releaseDate, double price, Integer totalPages, String translator, boolean status, String author, Discount discount, Category category) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.dimension = dimension;
        this.image = image;
        this.publisher = publisher;
        this.quantity = quantity;
        this.releaseDate = releaseDate;
        this.price = price;
        this.totalPages = totalPages;
        this.translator = translator;
        this.status = status;
        this.author = author;
        this.discount = discount;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
