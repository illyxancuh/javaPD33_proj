package com.BookHouse.Service;

import com.BookHouse.DTO.BookDTO;
import com.BookHouse.DTO.UserDTO;
import com.BookHouse.Domain.Book;
import com.BookHouse.Domain.User;
import com.BookHouse.Utils.Patch;
import com.BookHouse.exception.ItemNotFoundException;
import com.BookHouse.Interface.IBookService;
import com.BookHouse.Repos.BookRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Book> update(Integer id, JsonPatch patch) {
        Patch bookPatch = new Patch();
        try {
            Book book = bookRepository.findById(id)
                    .orElseThrow(() -> new ItemNotFoundException("Book with id has not found"));
            Book bookPatched = bookPatch.applyPatchToBook(patch, book);

            return ResponseEntity.ok(bookPatched);
        } catch (JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (ItemNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Override
    public BookDTO add(Book book) {
        return new BookDTO(bookRepository.save(book));
    }
}
