package com.example.mike.bookmanager.model.mapper;

import com.example.mike.bookmanager.model.Book;
import com.example.mike.bookmanager.model.dto.BookDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDto map(Book book);
    Book map(BookDto bookDto);
}
