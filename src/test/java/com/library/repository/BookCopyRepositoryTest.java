package com.library.repository;

import com.library.domain.Book;
import com.library.domain.BookCopy;
import com.library.domain.BookStatusType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookCopyRepositoryTest {

    @Autowired
    private BookCopyRepository repository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    void saveNewCopy() {
        //Given
        Book book = new Book("Title1", "Author1", 2000);
        BookCopy bookCopy1 = new BookCopy(BookStatusType.AVAILABLE, book);
        BookCopy bookCopy2 = new BookCopy(BookStatusType.NOT_AVAILABLE, book);

        //When
        bookRepository.save(book);
        repository.save(bookCopy1);
        repository.save(bookCopy2);

        //Then
        assertEquals(2, repository.findAll().size());

        //Clean up
        repository.deleteALLByBook(book);
        bookRepository.deleteAll();
    }

}