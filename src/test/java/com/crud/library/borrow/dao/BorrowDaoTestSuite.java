package com.crud.library.borrow.dao;


import com.crud.library.domain.Copy;
import com.crud.library.domain.Status;
import com.crud.library.repository.BorrowDao;
import com.crud.library.repository.CopyDao;
import com.crud.library.domain.Borrow;
import com.crud.library.domain.Reader;
import com.crud.library.repository.ReaderDao;
import com.crud.library.domain.Title;
import com.crud.library.repository.TitleDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BorrowDaoTestSuite {
    @Autowired
    private BorrowDao borrowDao;
    @Autowired
    private CopyDao copyDao;
    @Autowired
    private TitleDao titleDao;
    @Autowired
    private ReaderDao readerDao;

    @Test
    void testBorrowDaoSave(){
        //given
        Title title = new Title("Karol May","Winnetou",2000);
        Copy copy = new Copy(title, Status.CIRCULATION);
        Reader reader = new Reader("Marcin", "Pajak");
        Borrow borrow = new Borrow(reader, copy);

        title.getCopies().add(copy);
        reader.getBorrowList().add(borrow);
        copy.getBorrowList().add(borrow);
        //when
        borrowDao.save(borrow);
        //then
        Long id = borrow.getId();
        Optional<Borrow> borrowed = borrowDao.findById(id);
        assertTrue(borrowed.isPresent());
        //delete
        borrowDao.deleteById(id);
    }
}
