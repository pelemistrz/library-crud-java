package com.crud.library.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CopyDto {
    private Long id;
    private String title;
    private String status;

    @Override
    public String toString() {
        return "CopyDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
