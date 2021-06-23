package com.BookHouse.Service;

import com.BookHouse.DTO.BookDTO;
import com.BookHouse.DTO.UserDTO;
import com.BookHouse.Domain.Book;
import com.BookHouse.Domain.User;
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

    @Override
    public BookDTO add(Book book) {
        return new BookDTO(bookRepository.save(book));
    }
}
