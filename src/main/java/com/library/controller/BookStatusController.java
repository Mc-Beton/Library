package com.library.controller;

import com.library.controller.exceptions.BookStatusNotFoundException;
import com.library.domain.BookStatus;
import com.library.domain.dto.BookStatusDto;
import com.library.mapper.BookStatusMapper;
import com.library.service.DbBookStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/borrow")
@RequiredArgsConstructor
public class BookStatusController {

    @Autowired
    private DbBookStatusService dbBookStatusService;

    @Autowired
    private BookStatusMapper bookStatusMapper;

    @GetMapping("/all")
    public ResponseEntity<List<BookStatusDto>> getAll() {
        List<BookStatus> list = dbBookStatusService.getAllStates();
        return ResponseEntity.ok(bookStatusMapper.mapToBookStatusDtoList(list));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> borrowBook(@RequestBody BookStatusDto bookStatusDto) {
        BookStatus bookStatus = bookStatusMapper.mapToBookStatus(bookStatusDto);
        dbBookStatusService.borrowBookCopy(bookStatus);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<BookStatusDto> returnBook(@RequestBody BookStatusDto bookStatusDto) {
        BookStatus bookStatus = bookStatusMapper.mapToBookStatus(bookStatusDto);
        dbBookStatusService.returnBookCopy(bookStatus.getId());
        return ResponseEntity.ok().build();
    }
}
