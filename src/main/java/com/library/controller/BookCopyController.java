package com.library.controller;

import com.library.controller.exceptions.BookCopyNotFoundException;
import com.library.domain.BookCopy;
import com.library.domain.dto.BookCopyDto;
import com.library.mapper.BookCopyMapper;
import com.library.service.DbBookCopyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/book")
@RequiredArgsConstructor
public class BookCopyController {

    @Autowired
    private DbBookCopyService dbBookCopyService;

    @Autowired
    private BookCopyMapper bookCopyMapper;

    @GetMapping("/copies")
    public ResponseEntity<List<BookCopyDto>> getAllCopies() {
        List<BookCopy> copyList = dbBookCopyService.getAllCopies();
        return ResponseEntity.ok(bookCopyMapper.mapToBookCopyDtoList(copyList));
    }

    @GetMapping(value = "copies/{copyId}")
    public ResponseEntity<List<BookCopyDto>> getCopies(@PathVariable Long bookId) throws BookCopyNotFoundException {
        List<BookCopy> copyList = dbBookCopyService.getCopiesOfBook(bookId);
        return ResponseEntity.ok(bookCopyMapper.mapToBookCopyDtoList(copyList));
    }

    @GetMapping(value = "copy/{copyId}")
    public ResponseEntity<BookCopyDto> getCopy(@PathVariable Long copyId) throws BookCopyNotFoundException {
        return ResponseEntity.ok(bookCopyMapper.mapToBookCopyDto(dbBookCopyService.getBookCopy(copyId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addNewCopy(@RequestBody BookCopyDto bookCopyDto) {
        BookCopy bookCopy = bookCopyMapper.mapToBookCopy(bookCopyDto);
        dbBookCopyService.saveBookCopy(bookCopy);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "copy/{copyId}")
    public ResponseEntity<Void> deleteCopy(@PathVariable Long copyId) throws BookCopyNotFoundException {
        dbBookCopyService.deleteBookCopy(copyId);
        return ResponseEntity.ok().build();
    }
}
