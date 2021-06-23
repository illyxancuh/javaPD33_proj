package com.BookHouse.Service;



import com.BookHouse.DTO.BookDTO;
import com.BookHouse.DTO.GenreDTO;
import com.BookHouse.Domain.Book;
import com.BookHouse.Domain.Genre;
import com.BookHouse.Interface.IGenreService;
import com.BookHouse.Repos.GenreRepository;
import com.BookHouse.exception.ItemNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GenreService implements IGenreService {
    private final GenreRepository genreRepository;


    @Override
    public Genre findById(Integer id) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Book with id has not found!"));
        return genre;
    }

    @Override
    public GenreDTO add(Genre genre) {
        return new GenreDTO(genreRepository.save(genre));
    }
}
