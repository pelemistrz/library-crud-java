package com.crud.library.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name="titles")
public class Title {
    @Id
    @NotNull
    @GeneratedValue
    private Long id;

    @Column(name="title")
    private String title;
    @Column(name="author")
    private String author;
    @Column(name="publish_year")
    private Integer publishYear;
}
