package com.BookHouse.Interface;

import com.BookHouse.DTO.BookDTO;
import com.BookHouse.Domain.Book;
import com.BookHouse.Domain.User;

public interface IBookService {
    Book findById(Integer id);
    BookDTO add(Book book);
}
