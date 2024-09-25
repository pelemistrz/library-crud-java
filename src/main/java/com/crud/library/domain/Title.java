package com.crud.library.domain;


import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Entity
@Table(name="titles")
public class Title {
  
    private Long id;
    private String title;
    private String author;
    private Integer publishYear;
    private List<Copy> copies = new ArrayList<>();

    public Title( String author,String title, Integer publishYear) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
    }

    @Id
    @NotNull
    @GeneratedValue
    public Long getId() {
        return id;
    }
    @Column(name="title", unique = true)
    public String getTitle() {
        return title;
    }
    @Column(name="author")
    public String getAuthor() {
        return author;
    }    @Column(name="publish_year")

    public Integer getPublishYear() {
        return publishYear;
    }

    @OneToMany(
            targetEntity = Copy.class,
            mappedBy = "title",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Copy> getCopies() {
        return copies;
    }
}
