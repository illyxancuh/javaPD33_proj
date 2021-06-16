package BookHouse.servise;

import BookHouse.domain.Book;
import BookHouse.exceptions.ItemNotFoundException;
import BookHouse.interfaces.IBookService;
import BookHouse.repos.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServise implements IBookService {
    private final BookRepository bookRepository;


    @Override
    public Book findById(Integer id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Book with id has not found!"));
        return book;
    }
}
