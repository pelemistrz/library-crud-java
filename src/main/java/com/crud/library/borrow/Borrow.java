package com.crud.library.domain;


import com.crud.library.copy.Copy;
import com.crud.library.reader.Reader;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@NoArgsConstructor
@Entity
@Table(name="borrows")
public class Borrow {

    private Long id;
    private Reader reader;
    private Copy copy;
    private Date borrowDate;
    private Date returnDate;

    public Borrow(Reader reader, Copy copy) {
        this.reader = reader;
        this.copy = copy;
        this.borrowDate = new Date();
        this.returnDate = null;
    }
    @Id
    @GeneratedValue
    @Column(name="id")
    public Long getId() {
        return id;
    }

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name="reader_id")
    public Reader getReader() {
        return reader;
    }

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name="copy_id")
    public Copy getCopy() {
        return copy;
    }

    @Column(name="borrow_date")
    public Date getBorrowDate() {
        return borrowDate;
    }
    @Column(name="return_date")
    public Date getReturnDate() {
        return returnDate;
    }
}
