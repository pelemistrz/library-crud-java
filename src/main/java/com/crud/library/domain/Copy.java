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
@Table(name="copies")
public class Copy {

    private Long id;
    private Title title;
    private Status status;
    private List<Borrow> borrowList = new ArrayList<>();


    public Copy(Title title, Status status) {
        this.title = title;
        this.status = status;
    }

    public Copy(Long id, Title title, Status status) {
        this.id = id;
        this.title = title;
        this.status = status;
    }

    @Id
    @GeneratedValue
        public Long getId() {
        return id;
    }

    @NotNull
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name="title_id")
    public Title getTitle() {
        return title;
    }

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    public Status getStatus() {
        return status;
    }

    @OneToMany(
            targetEntity = Borrow.class,
            mappedBy = "copy",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Borrow> getBorrowList() {
        return borrowList;
    }
}
