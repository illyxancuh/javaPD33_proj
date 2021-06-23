package com.BookHouse.Repos;

import com.BookHouse.Domain.BookRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRatingRepository extends JpaRepository<BookRating, Integer> {
    Optional<BookRating> findById(Integer id);
}
