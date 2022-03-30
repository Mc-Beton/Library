package com.library.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookStatusDto {

    private Long id;
    private Long bookCopyId;
    private Long userId;
    private LocalDate rentalDate;
    private LocalDate returnDate;

}
