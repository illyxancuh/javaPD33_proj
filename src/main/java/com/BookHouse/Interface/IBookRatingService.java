package com.BookHouse.Interface;

import com.BookHouse.DTO.BookRatingDTO;
import com.BookHouse.Domain.BookRating;

public interface IBookRatingService {
    BookRating findById(Integer id);
    BookRatingDTO add(BookRating bookRating);
}
