package com.library.service;

import com.library.domain.BookStatus;
import com.library.repository.BookStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbBookStatusService {

    private BookStatusRepository bookStatusRepository;

    List<BookStatus> getAllStates() {return bookStatusRepository.findAll();}

    BookStatus saveNewState(BookStatus bookStatus) {return bookStatusRepository.save(bookStatus);}
}
