package com.library.mapper;

import com.library.domain.BookCopy;
import com.library.domain.dto.BookCopyDto;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookCopyMapper {

    @Autowired
    private BookRepository bookRepository;

    public BookCopy mapToBookCopy(final BookCopyDto bookCopyDto) {
        return new BookCopy(
                bookCopyDto.getId(),
                bookCopyDto.getBookStatusType(),
                bookRepository.findById(bookCopyDto.getBookId()).get()
        );
    }

    public BookCopyDto mapToBookCopyDto(final BookCopy bookCopy) {
        return new BookCopyDto(
                bookCopy.getId(),
                bookCopy.getBook().getId(),
                bookCopy.getStatus()
        );
    }

    public List<BookCopyDto> mapToBookCopyDtoList(final List<BookCopy> copyList) {
        return copyList.stream()
                .map(copy -> new BookCopyDto(copy.getId(), copy.getBook().getId(), copy.getStatus()))
                .collect(Collectors.toList());
    }
}
