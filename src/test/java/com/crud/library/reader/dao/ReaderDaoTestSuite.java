package com.crud.library.reader.dao;


import com.crud.library.domain.Reader;
import com.crud.library.repository.ReaderDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ReaderDaoTestSuite {
    @Autowired
    private ReaderDao readerDao;

    @Test
    void testReaderDaoSave(){
        //given
        Reader reader = new Reader("Zbyszek","Pajak");
        //when
        readerDao.save(reader);
        //then
        Long id = reader.getId();
        Optional<Reader> read = readerDao.findById(id);
        assertTrue(read.isPresent());
        //finally
        readerDao.deleteById(id);
    }
}
