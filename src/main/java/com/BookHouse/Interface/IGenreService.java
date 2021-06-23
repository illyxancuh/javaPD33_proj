package com.BookHouse.Interface;


import com.BookHouse.DTO.GenreDTO;
import com.BookHouse.Domain.Genre;

public interface IGenreService {
    Genre findById(Integer id);
    GenreDTO add(Genre genre);
}
