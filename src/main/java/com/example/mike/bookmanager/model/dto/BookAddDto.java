package com.example.mike.bookmanager.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class BookAddDto {

    private String bookTitle;
    private String bookAuthor;
    private Integer bookPrice;

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public Integer getBookPrice() {
        return bookPrice;
    }
}
