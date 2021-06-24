package com.BookHouse.Controller;


import com.BookHouse.DTO.BookDTO;
import com.BookHouse.DTO.GenreDTO;
import com.BookHouse.Domain.Book;
import com.BookHouse.Domain.Genre;
import com.BookHouse.Domain.User;
import com.BookHouse.Interface.IGenreService;
import com.github.fge.jsonpatch.JsonPatch;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("genre")
@AllArgsConstructor
public class GenreController {
    private final IGenreService genreService;

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Genre getGenreById(@PathVariable Integer id){
        return genreService.findById(id);
    }

    @PatchMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Genre> updateGenre(@PathVariable Integer id, @RequestBody JsonPatch patch){

        return genreService.update(id, patch);
    }

    @PostMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public GenreDTO addGenre(@RequestBody Genre genre){
        return genreService.add(genre);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteGenre(@PathVariable Integer id){
        genreService.deleteById(id);
    }
}
