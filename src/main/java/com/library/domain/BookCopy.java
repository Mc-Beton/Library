package com.library.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "bookEgz")
public class BookCopy {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "STATUS")
    private BookStatusType status;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    public Book book;
}
