package com.library.service;

import com.library.controller.exceptions.BookCopyNotFoundException;
import com.library.domain.Book;
import com.library.domain.BookCopy;
import com.library.domain.BookStatusType;
import com.library.repository.BookCopyRepository;
import com.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbBookCopyService {

    @Autowired
    private BookCopyRepository bookCopyRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<BookCopy> getAllCopies() {
        return bookCopyRepository.findAll();
    }

    public List<BookCopy> getCopiesOfBook(final Long bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        return bookCopyRepository.findByBook(book);
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

    public BookCopy setBookCopyStatus(final Long bookCopyId, BookStatusType bookStatusType) {
        Optional<BookCopy> bookCopy = bookCopyRepository.findById(bookCopyId);
        BookCopy bookCopy1 = bookCopy.get();
        bookCopy1.setStatus(bookStatusType);
        return bookCopyRepository.save(bookCopy1);
    }
}
