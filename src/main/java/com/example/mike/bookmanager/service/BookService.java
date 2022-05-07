package com.example.mike.bookmanager.service;

import com.example.mike.bookmanager.model.Book;

import java.util.List;

public interface BookService {

    public void add(Book book);

    public void updateBook(Book book);

    public void removeBook(Integer id);

    public Book getBookById(Integer id);

    public List<Book> listBooks();
}
