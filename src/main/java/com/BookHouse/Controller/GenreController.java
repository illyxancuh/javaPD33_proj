package com.BookHouse.Controller;


import com.BookHouse.Domain.Genre;
import com.BookHouse.Interface.IGenreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
}
