package com.BookHouse.DTO;

import com.BookHouse.Domain.Book;
import lombok.Getter;
import lombok.Setter;

import java.sql.Blob;
import java.util.Date;

@Getter
@Setter
public class BookDTO {
    public BookDTO(Book book) {
        this.id = book.getId();
        this.author = book.getAuthor();
        this.date = book.getDate();
        this.description = book.getDescription();
        this.fileURL = book.getFileURL();
        this.photo = book.getPhoto();
        this.name = book.getName();
    }

    private Integer id;
    private String name;
    private String author;
    private Date date;
    private Blob photo;
    private String description;
    private String fileURL;
}
