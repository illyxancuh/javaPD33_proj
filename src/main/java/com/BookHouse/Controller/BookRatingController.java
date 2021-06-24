package com.BookHouse.Controller;

import com.BookHouse.DTO.BookRatingDTO;
import com.BookHouse.DTO.GenreDTO;
import com.BookHouse.Domain.BookRating;
import com.BookHouse.Domain.Genre;
import com.BookHouse.Domain.User;
import com.BookHouse.Interface.IBookRatingService;
import com.github.fge.jsonpatch.JsonPatch;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bookraiting")
@AllArgsConstructor
public class BookRatingController {
    private final IBookRatingService bookRatingService;

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookRating getBookRatingById(@PathVariable Integer id){
        return bookRatingService.findById(id);
    }

    @PatchMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<BookRating> updateBookRating(@PathVariable Integer id, @RequestBody JsonPatch patch){

        return bookRatingService.update(id, patch);
    }

    @PostMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public BookRatingDTO addBookRating(@RequestBody BookRating bookRating){
        return bookRatingService.add(bookRating);
    }
}
