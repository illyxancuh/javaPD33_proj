package com.BookHouse.Interface;

import com.BookHouse.DTO.BookDTO;
import com.BookHouse.Domain.Book;
import com.BookHouse.Domain.User;
import com.github.fge.jsonpatch.JsonPatch;
import org.springframework.http.ResponseEntity;

public interface IBookService {
    Book findById(Integer id);
    BookDTO add(Book book);
    ResponseEntity<Book> update(Integer id, JsonPatch patch);
}
