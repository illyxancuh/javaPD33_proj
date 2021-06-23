package com.BookHouse.DTO;


import com.BookHouse.Domain.Book;
import com.BookHouse.Domain.BookRating;
import com.BookHouse.Domain.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRatingDTO {
    public BookRatingDTO(BookRating bookRating){
        this.id = bookRating.getId();
        this.book=bookRating.getBook();
        this.raiting=bookRating.getRaiting();
        this.user=bookRating.getUser();
    }

    private Integer id;

    private float raiting;

    private User user;

    private Book book;
}
