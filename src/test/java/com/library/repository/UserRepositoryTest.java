package com.library.repository;

import com.library.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    void addNewUser() {
        //Given
        User user = new User("John", "Smith", LocalDate.of(2020, 1, 8));

        //When
        repository.save(user);

        //Then
        assertEquals(1, repository.findAll().size());

        //Clean up
        repository.deleteAll();
    }

}