package com.BookHouse.Service;



import com.BookHouse.DTO.BookDTO;
import com.BookHouse.DTO.GenreDTO;
import com.BookHouse.Domain.Book;
import com.BookHouse.Domain.Genre;
import com.BookHouse.Domain.User;
import com.BookHouse.Interface.IGenreService;
import com.BookHouse.Repos.GenreRepository;
import com.BookHouse.Utils.Patch;
import com.BookHouse.exception.ItemNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Genre> update(Integer id, JsonPatch patch) {
        Patch genrePatch = new Patch();
        try {
            Genre genre = genreRepository.findById(id)
                    .orElseThrow(() -> new ItemNotFoundException("Genre with id has not found"));
            Genre genrePatched = genrePatch.applyPatchToGenre(patch, genre);

            return ResponseEntity.ok(genrePatched);
        } catch (JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (ItemNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Override
    public GenreDTO add(Genre genre) {
        return new GenreDTO(genreRepository.save(genre));
    }

    @Override
    public void deleteById(Integer id){
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("User with id has not found"));
        genreRepository.delete(genre);
    }
}
