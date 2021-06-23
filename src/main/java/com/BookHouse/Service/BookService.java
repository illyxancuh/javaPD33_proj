package com.BookHouse.Service;

import com.BookHouse.Domain.Book;
import com.BookHouse.exception.ItemNotFoundException;
import com.BookHouse.Interface.IBookService;
import com.BookHouse.Repos.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService implements IBookService {
    private final BookRepository bookRepository;


    @Override
    public Book findById(Integer id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Book with id has not found!"));
        return book;
    }
}
