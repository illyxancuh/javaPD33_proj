package com.BookHouse.Interface;


import com.BookHouse.Domain.Genre;

public interface IGenreService {
    Genre findById(Integer id);
}
