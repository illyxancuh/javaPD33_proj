package com.BookHouse.Service;


import com.BookHouse.DTO.BookDTO;
import com.BookHouse.DTO.BookRatingDTO;
import com.BookHouse.Domain.Book;
import com.BookHouse.Domain.BookRating;

import com.BookHouse.Interface.IBookRatingService;
import com.BookHouse.Repos.BookRatingRepository;
import com.BookHouse.exception.ItemNotFoundException;
import lombok.AllArgsConstructor;
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
    public BookRatingDTO add(BookRating bookRating) {
        return new BookRatingDTO(bookRatingRepository.save(bookRating));
    }
}
