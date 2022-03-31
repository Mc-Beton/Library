package com.library.repository;

import com.library.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    void addNewBook() {
        //Given
        Book book = new Book("Title1", "Author1", 2000);

        //When
        repository.save(book);

        //Then
        assertEquals(1, repository.findAll().size());

        //Clean up
        repository.deleteAll();
    }

}