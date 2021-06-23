package com.BookHouse.Interface;

import com.BookHouse.Domain.Book;

public interface IBookService {
    Book findById(Integer id);
}
