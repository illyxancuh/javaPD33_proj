package BookHouse.interfaces;

import BookHouse.domain.Book;

public interface IBookService {
    Book findById(Integer id);
}
