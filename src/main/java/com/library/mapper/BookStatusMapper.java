package com.library.mapper;

import com.library.domain.BookStatus;
import com.library.domain.dto.BookStatusDto;
import com.library.repository.BookCopyRepository;
import com.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookStatusMapper {

    @Autowired
    private BookCopyRepository bookCopyRepository;

    @Autowired
    private UserRepository userRepository;

    public BookStatus mapToBookStatus(final BookStatusDto bookStatusDto) {
        return new BookStatus(
                bookStatusDto.getId(),
                bookCopyRepository.findById(bookStatusDto.getBookCopyId()).get(),
                userRepository.findById(bookStatusDto.getUserId()).get(),
                bookStatusDto.getRentalDate(),
                bookStatusDto.getReturnDate());
    }

    public BookStatusDto mapToBookStatusDto(final BookStatus bookStatus) {
        return new BookStatusDto(
                bookStatus.getId(),
                bookStatus.getBookCopy().getId(),
                bookStatus.getUser().getId(),
                bookStatus.getRentalDate(),
                bookStatus.getReturnDate());
    }

    public List<BookStatusDto> mapToBookStatusDtoList(final List<BookStatus> statusList) {
        return statusList.stream()
                .map(status -> new BookStatusDto(status.getId(), status.getBookCopy().getId(), status.getUser().getId(),status.getRentalDate(),status.getReturnDate()))
                .collect(Collectors.toList());
    }
}
