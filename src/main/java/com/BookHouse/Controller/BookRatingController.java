package com.BookHouse.Controller;

import com.BookHouse.Domain.BookRating;
import com.BookHouse.Interface.IBookRatingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
}
