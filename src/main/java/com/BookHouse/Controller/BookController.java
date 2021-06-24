package com.BookHouse.Controller;

import com.BookHouse.DTO.BookDTO;
import com.BookHouse.DTO.UserDTO;
import com.BookHouse.Domain.Book;
import com.BookHouse.Domain.User;
import com.BookHouse.Interface.IBookService;
import com.github.fge.jsonpatch.JsonPatch;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO addBook(@RequestBody Book book){
        return bookService.add(book);
    }

    @PatchMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Book> updateBook(@PathVariable Integer id, @RequestBody JsonPatch patch){

        return bookService.update(id, patch);
    }
}
