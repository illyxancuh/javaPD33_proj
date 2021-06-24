package com.BookHouse.Service;


import com.BookHouse.DTO.BookDTO;
import com.BookHouse.DTO.BookRatingDTO;
import com.BookHouse.Domain.Book;
import com.BookHouse.Domain.BookRating;

import com.BookHouse.Domain.User;
import com.BookHouse.Interface.IBookRatingService;
import com.BookHouse.Repos.BookRatingRepository;
import com.BookHouse.Utils.Patch;
import com.BookHouse.exception.ItemNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookRatingService implements IBookRatingService {
    private final BookRatingRepository bookRatingRepository;


    @Override
    public BookRating findById(Integer id) {
        BookRating bookRating = bookRatingRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Book with id has not found!"));
        return bookRating;
    }

    @Override
    public ResponseEntity<BookRating> update(Integer id, JsonPatch patch) {
        Patch bookRatingPatch = new Patch();
        try {
            BookRating bookRating = bookRatingRepository.findById(id)
                    .orElseThrow(() -> new ItemNotFoundException("BookRating with id has not found"));
            BookRating bookRatingPatched = bookRatingPatch.applyPatchToBookRating(patch, bookRating);

            return ResponseEntity.ok(bookRatingPatched);
        } catch (JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (ItemNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Override
    public BookRatingDTO add(BookRating bookRating) {
        return new BookRatingDTO(bookRatingRepository.save(bookRating));
    }

    @Override
    public void deleteById(Integer id){
        BookRating bookrating = bookRatingRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("User with id has not found"));
        bookRatingRepository.delete(bookrating);
    }
}
