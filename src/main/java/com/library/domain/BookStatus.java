package com.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "BOOK_STATUS")
public class BookStatus {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private BookCopy bookCopy;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "RENTAL_DATE")
    private LocalDate rentalDate;

    @Column(name = "RETURN_DATE")
    private LocalDate returnDate;

    public BookStatus(BookCopy bookCopy, User user, LocalDate rentalDate, LocalDate returnDate) {
        this.bookCopy = bookCopy;
        this.user = user;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }

    public BookStatus(Long id, BookCopy bookCopy, User user, LocalDate rentalDate, LocalDate returnDate) {
        this.id =id;
        this.bookCopy = bookCopy;
        this.user = user;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }
}
