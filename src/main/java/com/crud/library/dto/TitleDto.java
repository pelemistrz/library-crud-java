package com.crud.library.dto;

import com.crud.library.domain.Copy;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Getter
public class TitleDto {
    private Long id;
    private String title;
    private String author;
    private Integer publishYear;
//    private List<Copy> copies;


}
