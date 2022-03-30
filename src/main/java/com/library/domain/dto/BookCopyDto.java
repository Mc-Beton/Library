package com.library.domain.dto;

import com.library.domain.BookStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCopyDto {

    private Long id;
    private Long bookId;
    private BookStatus bookStatus;
}
