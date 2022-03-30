package com.library.service;

import com.library.controller.BookCopyNotFoundException;
import com.library.domain.BookCopy;
import com.library.repository.BookCopyRepository;
import com.library.repository.BookRepository;
import com.library.repository.BookStatusRepository;
import com.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {

    private BookCopyRepository bookCopyRepository;
    private BookRepository bookRepository;
    private BookStatusRepository bookStatusRepository;
    private UserRepository userRepository;

    //BookCopy Repository
    public List<BookCopy> getAllTasks() {
        return bookCopyRepository.findAll();
    }

    public BookCopy getBookCopy(final Long bookCopyId) throws BookCopyNotFoundException {
        return bookCopyRepository.findById(bookCopyId).orElseThrow(BookCopyNotFoundException::new);
    }

    public BookCopy save(final BookCopy bookCopy) {
        return bookCopyRepository.save(bookCopy);
    }

    public void deleteById(final Long bookCopyId) {
        bookCopyRepository.deleteById(bookCopyId);
    }

    
}
