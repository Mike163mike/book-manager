package com.example.mike.bookmanager.model.mapper;

import com.example.mike.bookmanager.model.Book;
import com.example.mike.bookmanager.model.dto.BookAddDto;
import com.example.mike.bookmanager.model.dto.BookDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDto mapToBookDto(Book book);
    Book map(BookDto bookDto);
    BookAddDto mapToBookAddDto(Book book);
    Book map(BookAddDto bookAddDto);
}
