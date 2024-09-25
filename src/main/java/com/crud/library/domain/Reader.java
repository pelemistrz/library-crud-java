package com.crud.library.domain;

//import com.crud.library.domain.Borrow;
//import com.crud.library.domain.Copy;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity(name="readers")
public class Reader {
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOpenAccount;
    private List<Borrow> borrowList = new ArrayList<>();

    public Reader(Long id, String firstName, String lastName, Date dateOpenAccount) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOpenAccount = dateOpenAccount;
    }

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

    @OneToMany(
            targetEntity = Borrow.class,
            mappedBy = "reader",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Borrow> getBorrowList() {
        return borrowList;
    }


}
