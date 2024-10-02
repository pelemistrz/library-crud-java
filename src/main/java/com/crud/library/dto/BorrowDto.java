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
    private Long readerId;
    private Long copyId;
    private Date borrowDate;
    private Date returnDate;



    @Override
    public String toString() {
        return "BorrowDto{" +
                "id=" + id +
                ", readerId=" + readerId +
                ", copyId=" + copyId +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
