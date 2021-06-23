package com.BookHouse.Interface;

import com.BookHouse.Domain.BookRating;

public interface IBookRatingService {
    BookRating findById(Integer id);
}
