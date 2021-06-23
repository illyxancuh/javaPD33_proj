package com.BookHouse.Domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "bookraiting")
@Data
public class BookRating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "Raiting")
    private float raiting;

    @OneToOne
    @JoinColumn(name = "id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "id", nullable = false)
    private Book book;
}
