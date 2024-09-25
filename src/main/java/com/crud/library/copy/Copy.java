package com.crud.library.copy;

import com.crud.library.title.Title;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
@Entity
@Table(name="copies")
public class Copy {

    private Long id;
    private Title title;
    private Status status;

    public Copy(Title title, Status status) {
        this.title = title;
        this.status = status;
    }

    @Id
    @GeneratedValue
        public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name="title_id")
    public Title getTitle() {
        return title;
    }

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    public Status getStatus() {
        return status;
    }


//    private List<Borrow> borrowList;

//    @OneToMany(
//            targetEntity = Copy.class,
//            mappedBy = "copy",
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY
//    )
//    public List<Borrow> getBorrowList() {
//        return borrowList;
//    }
}
