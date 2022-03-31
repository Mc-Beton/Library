package com.library.controller;

import com.library.controller.exceptions.BookNotFoundException;
import com.library.domain.Book;
import com.library.domain.dto.BookDto;
import com.library.mapper.BookMapper;
import com.library.service.DbBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/books")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private DbBookService dbBookService;

    @Autowired
    private BookMapper bookMapper;

    @GetMapping
    public ResponseEntity<List<BookDto>> getBooks() {
        List<Book> books = dbBookService.getAllBooks();
        return ResponseEntity.ok(bookMapper.mapToBookDtoList(books));
    }

    @GetMapping(value = "{bookId}")
    public ResponseEntity<BookDto> getBook(@PathVariable Long bookId) throws BookNotFoundException {
        return ResponseEntity.ok(bookMapper.mapToBookDto(dbBookService.getBookById(bookId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addBook(@RequestBody BookDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        dbBookService.saveBook(book);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{bookId}")
    public ResponseEntity<Void> deleteBook( Long bookId) throws BookNotFoundException {
        dbBookService.deleteBook(bookId);
        return ResponseEntity.ok().build();
    }
}
