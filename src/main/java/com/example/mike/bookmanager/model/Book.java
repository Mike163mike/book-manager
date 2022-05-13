package com.example.mike.bookmanager.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
//@Getter
//@Setter
@ToString
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @NotEmpty(message = "This field should not be empty.")
    @Size(min = 1, max = 20, message = "Max length of the field is 20 letters.")
    @Column(name = "book_title")
    private String bookTitle;
    @NotEmpty(message = "This field should not be empty.")
    @Size(min = 1, max = 20, message = "Max length of the field is 20 letters.")
    @Column(name = "book_author")
    private String bookAuthor;
    @Column(name = "book_price")
    private Double bookPrice;

    public Book() {
    }

    public Book(Integer id, String bookTitle, String bookAuthor, Double bookPrice) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
    }

    public Book(String bookTitle, String bookAuthor, Double bookPrice) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
    }

    public Integer getId() {
        return id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Book book = (Book) o;
        return id != null && Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
