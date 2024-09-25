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
        Copy copy2 = new Copy(title, Status.CIRCULATION);
        //when
        title.getCopies().add(copy1);
        title.getCopies().add(copy2);
        titleDao.save(title);
        copyDao.save(copy1);
        copyDao.save(copy2);

        //then
        Long idCopy1 = copy1.getId();
        Long idCopy2 = copy2.getId();
        Long idTitle = title.getId();

        Optional<Copy> optionalCopy = copyDao.findById(idCopy1);
        assertTrue(optionalCopy.isPresent());

        //delete
        copyDao.deleteById(idCopy1);
        copyDao.deleteById(idCopy2);
        titleDao.deleteById(idTitle);

    }
}
