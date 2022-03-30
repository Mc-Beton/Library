package com.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "bookEgz")
public class BookCopy {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "STATUS")
    private BookStatusType status;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    public BookCopy(BookStatusType status, Book book) {
        this.status = status;
        this.book = book;
    }
}
