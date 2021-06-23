package com.BookHouse.DTO;

import com.BookHouse.Domain.Genre;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenreDTO {
    public GenreDTO(Genre genre) {
        this.id = genre.getId();
        this.name= genre.getName();
    }

    private Integer id;

    private String name;
}
