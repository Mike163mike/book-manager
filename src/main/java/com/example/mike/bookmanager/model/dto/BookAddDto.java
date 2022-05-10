package com.example.mike.bookmanager.model.dto;

import lombok.*;

@Data
public class BookAddDto {

    private String bookTitle;
    private String bookAuthor;
    private Integer bookPrice;
}
