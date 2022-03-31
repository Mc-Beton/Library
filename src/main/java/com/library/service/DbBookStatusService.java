package com.library.service;

import com.library.domain.BookStatus;
import com.library.domain.BookStatusType;
import com.library.repository.BookCopyRepository;
import com.library.repository.BookStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbBookStatusService {

    @Autowired
    private BookStatusRepository bookStatusRepository;

    @Autowired
    private BookCopyRepository bookCopyRepository;

    public List<BookStatus> getAllStates() {return bookStatusRepository.findAll();}

    public BookStatus borrowBookCopy(final BookStatus bookStatus) {
        bookCopyRepository.findById(bookStatus.getBookCopy().getId());
        bookStatus.getBookCopy().setStatus(BookStatusType.NOT_AVAILABLE);
        bookCopyRepository.save(bookStatus.getBookCopy());
        return bookStatusRepository.save(bookStatus);
    }

    public void returnBookCopy(Long borrowedBookCopyId) {
        Optional<BookStatus> bookStatus = bookStatusRepository.findById(borrowedBookCopyId);
        BookStatus bookStatus1 = bookStatus.get();
        bookStatus1.getBookCopy().setStatus(BookStatusType.AVAILABLE);
        bookCopyRepository.save(bookStatus1.getBookCopy());
        bookStatus1.setReturnDate(LocalDate.now());
        bookStatusRepository.save(bookStatus1);
    }
}
