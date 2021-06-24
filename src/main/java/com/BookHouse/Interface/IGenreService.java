package com.BookHouse.Interface;


import com.BookHouse.DTO.GenreDTO;
import com.BookHouse.Domain.Genre;
import com.BookHouse.Domain.User;
import com.github.fge.jsonpatch.JsonPatch;
import org.springframework.http.ResponseEntity;

public interface IGenreService {
    Genre findById(Integer id);
    GenreDTO add(Genre genre);
    ResponseEntity<Genre> update(Integer id, JsonPatch patch);
    void deleteById(Integer id);
}
