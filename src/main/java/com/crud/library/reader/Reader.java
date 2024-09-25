package com.crud.library.reader;

//import com.crud.library.domain.Borrow;
//import com.crud.library.domain.Copy;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@NoArgsConstructor
@Setter
@Entity(name="readers")
public class Reader {
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOpenAccount;
//    private List<Borrow> borrowList;

    public Reader(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOpenAccount = new Date();
    }

    @Id
    @GeneratedValue
    @Column(name="id",unique=true)
    public Long getId() {
        return id;
    }

    @Column(name="first_name")
    public String getFirstName() {
        return firstName;
    }

    @Column(name="last_name")
    public String getLastName() {
        return lastName;
    }

    @Column(name="date_open_account")
    public Date getDateOpenAccount() {
        return dateOpenAccount;
    }

    //    public void setBorrowList(List<Borrow> borrowList) {
//        this.borrowList = borrowList;
//    }
//
//    @OneToMany(
//            targetEntity = Copy.class,
//            mappedBy = "reader",
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY
//    )
//    public List<Borrow> getBorrowList() {
//        return borrowList;
//    }
}
