package com.example.mike.bookmanager.service;

import com.example.mike.bookmanager.exception.AppException;
import com.example.mike.bookmanager.model.Book;
import com.example.mike.bookmanager.repository.BookRepository;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class BookServiceImpl implements BookService {

    private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(Book book) {
        repository.save(book);
        log.debug("Book " + book.getBookTitle() + " saved successfully");
    }

    @Override
    public void updateBook(Integer id, Book book) {
        Book oldBook = repository.findById(id).orElseThrow(() -> new AppException("The book with id = " + id + " don't exist"));
        Book newBook = new Book(id, book.getBookTitle(), book.getBookAuthor(), book.getBookPrice());
        repository.save(newBook);
        log.debug("Book " + book.getBookTitle() + " updated successfully");
    }

    @Override
    public void removeBook(Integer id) {
        repository.deleteById(id);
        log.debug("Book with id = " + id + " deleted successfully");
    }

    @Override
    public Book getBookById(Integer id) {
        log.debug("Trying to find book with id = " + id);
        return repository.findById(id).orElseThrow(() -> new AppException("This book is not here"));

    }

    @Override
    public List<Book> listBooks() {
        log.debug("Trying to get all books");
        return (List<Book>) repository.findAll();
    }
}
