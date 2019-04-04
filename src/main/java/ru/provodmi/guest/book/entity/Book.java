package ru.provodmi.guest.book.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Long id;
    private String author;
    private String title;
    private String year;
}