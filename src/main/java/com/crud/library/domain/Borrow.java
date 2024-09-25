//package com.crud.library.domain;
//
//
//import com.crud.library.reader.Reader;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//
//import java.util.Date;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity(name="borrows")
//public class Borrow {
//    private Long id;
//    private Reader reader;
//    private Copy copy;
//    private Date borrowDate;
//    private Date returnDate;
//
//    @Id
//
//    @GeneratedValue
//    public Long getId() {
//        return id;
//    }
//
////    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
////    @JoinColumn(name="reader_id")
////    public Reader getReader() {
////        return reader;
////    }
//
////    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
////    @Column(name="copy_id")
////    public Copy getCopy() {
////        return copy;
////    }
//
//    public Date getBorrowDate() {
//        return borrowDate;
//    }
//
//    public Date getReturnDate() {
//        return returnDate;
//    }
//}
