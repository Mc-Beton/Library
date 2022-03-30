package com.library.repository;

import com.library.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookStatusRepositoryTest {

    @Autowired
    private BookStatusRepository bookStatusRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookCopyRepository bookCopyRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void borrowABook() {
        //Given
        User user = new User("John", "Smith", LocalDate.of(2000, 8, 10));
        Book book = new Book("Title1", "Author1", 2000);
        BookCopy bookCopy = new BookCopy(BookStatusType.AVAILABLE, book);
        BookStatus bookStatus = new BookStatus(bookCopy, user, LocalDate.of(2002, 8,11), LocalDate.of(2002, 9, 11));

        //when
        userRepository.save(user);
        bookRepository.save(book);
        bookCopyRepository.save(bookCopy);
        bookStatusRepository.save(bookStatus);

        //Then
        assertEquals(1, bookStatusRepository.findAll().size());

        //Clean up
        bookStatusRepository.deleteAll();;
        bookCopyRepository.deleteAll();
        bookRepository.deleteAll();
        userRepository.deleteAll();
    }

}