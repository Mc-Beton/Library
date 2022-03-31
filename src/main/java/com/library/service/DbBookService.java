package com.library.service;

import com.library.controller.exceptions.BookNotFoundException;
import com.library.domain.Book;
import com.library.repository.BookCopyRepository;
import com.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbBookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookCopyRepository bookCopyRepository;

    public List<Book> getAllBooks() {return bookRepository.findAll();}

    public Book getBookById(Long bookId) throws BookNotFoundException {return bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);}

    public Book saveBook(Book book) {return bookRepository.save(book);}

    public void deleteBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        Book book1 = book.get();
        bookCopyRepository.deleteALLByBook(book1);
        bookRepository.deleteById(id);
    }
}
