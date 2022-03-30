package com.library.service;

import com.library.controller.BookCopyNotFoundException;
import com.library.domain.BookCopy;
import com.library.domain.BookStatusType;
import com.library.repository.BookCopyRepository;
import com.library.repository.BookRepository;
import com.library.repository.BookStatusRepository;
import com.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbBookCopyService {

    @Autowired
    private BookCopyRepository bookCopyRepository;

    public List<BookCopy> getAllTasks() {
        return bookCopyRepository.findAll();
    }

    public BookCopy getBookCopy(final Long bookCopyId) throws BookCopyNotFoundException {
        return bookCopyRepository.findById(bookCopyId).orElseThrow(BookCopyNotFoundException::new);
    }

    public BookCopy saveBookCopy(final BookCopy bookCopy) {
        return bookCopyRepository.save(bookCopy);
    }

    public void deleteBookCopy(final Long bookCopyId) {
        bookCopyRepository.deleteById(bookCopyId);
    }

    public Optional<BookCopy> findByStatus(final BookStatusType bookStatusType) {
        return bookCopyRepository.findByStatus(bookStatusType);
    }

}
