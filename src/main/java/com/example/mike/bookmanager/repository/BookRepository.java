package com.example.mike.bookmanager.repository;

import com.example.mike.bookmanager.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
