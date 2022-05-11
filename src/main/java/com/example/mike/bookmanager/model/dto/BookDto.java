package com.example.mike.bookmanager.model.dto;

import lombok.Data;

@Data
public class BookDto {

    private Integer id;
    private String bookTitle;
    private String bookAuthor;
    private Double bookPrice;
}
