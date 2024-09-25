package com.crud.library.copy.dao;

import com.crud.library.copy.Copy;
import com.crud.library.copy.Status;
import com.crud.library.title.Title;
import com.crud.library.title.dao.TitleDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CopyDaoTestSuite {
    @Autowired
    private CopyDao copyDao;
    @Autowired
    private TitleDao titleDao;

    @Test
    public void testCopyDaoSave() {
        //Given
        Title title = new Title("Tolkien","LORD",2000);
        Copy copy1 = new Copy(title, Status.LOST);

        //when
        title.getCopies().add(copy1);
        copyDao.save(copy1);

        //then
        Long idCopy1 = copy1.getId();

        Optional<Copy> optionalCopy = copyDao.findById(idCopy1);
        assertTrue(optionalCopy.isPresent());

        //delete
        copyDao.deleteById(idCopy1);

    }
}
