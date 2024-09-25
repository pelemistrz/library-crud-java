package com.crud.library.dto;


import com.crud.library.domain.Borrow;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
public class ReaderDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOpenAccount;
//    private List<Borrow> borrowList;

    @Override
    public String toString() {
        return "ReaderDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOpenAccount=" + dateOpenAccount +
                '}';
    }
}
