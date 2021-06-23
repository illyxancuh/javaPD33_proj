package com.BookHouse.Controller;

import com.BookHouse.Domain.Book;
import com.BookHouse.Interface.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("book")
@AllArgsConstructor
public class BookController {
    private final IBookService bookService;

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable Integer id){
        return bookService.findById(id);
    }
}
