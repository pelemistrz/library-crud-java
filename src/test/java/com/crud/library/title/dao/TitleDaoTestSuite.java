package com.crud.library.title.dao;


import com.crud.library.title.Title;
import jakarta.persistence.Access;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TitleDaoTestSuite {
    @Autowired
    private TitleDao titleDao;

    @Test
    void testReaderDaoSave(){
        //given
        Title title = new Title("Karol May","Winnetou",2000);
        //when
        titleDao.save(title);
        //then
        Long id = title.getId();
        Optional<Title> read = titleDao.findById(id);
        assertTrue(read.isPresent());
        //finally
          titleDao.deleteById(id);
    }
}
