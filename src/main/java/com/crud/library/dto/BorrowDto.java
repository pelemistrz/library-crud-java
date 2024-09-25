package com.crud.library.dto;

import com.crud.library.domain.Copy;
import com.crud.library.domain.Reader;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class BorrowDto {
    private Long id;
    private Reader reader;
    private Copy copy;
    private Date borrowDate;
    private Date returnDate;
}
