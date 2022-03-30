package com.library.service;

import com.library.controller.BookNotFoundException;
import com.library.domain.Book;
import com.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbBookService {

    private BookRepository bookRepository;

    public List<Book> getAllBooks() {return bookRepository.findAll();}

    public Book getBookById(Long bookId) throws BookNotFoundException {return bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);}

    public Book saveBook(Book book) {return bookRepository.save(book);}

    public void deleteBook(Long id) {bookRepository.deleteById(id);}
}
