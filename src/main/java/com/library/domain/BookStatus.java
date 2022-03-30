package com.library.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity(name = "OPERATION")
public class BookStatus {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "BOOK_ID")
    private BookCopy bookCopyId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User userId;

    @Column(name = "RENTAL_DATE")
    private LocalDate rentalDate;

    @Column(name = "RETURN_DATE")
    private LocalDate returnDate;
}
