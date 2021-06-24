package com.BookHouse.Interface;

import com.BookHouse.DTO.BookRatingDTO;
import com.BookHouse.Domain.Book;
import com.BookHouse.Domain.BookRating;
import com.github.fge.jsonpatch.JsonPatch;
import org.springframework.http.ResponseEntity;

public interface IBookRatingService {
    BookRating findById(Integer id);
    BookRatingDTO add(BookRating bookRating);
    ResponseEntity<BookRating> update(Integer id, JsonPatch patch);
}
