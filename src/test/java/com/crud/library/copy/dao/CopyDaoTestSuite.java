package com.crud.library.copy.dao;

import com.crud.library.domain.Copy;
import com.crud.library.domain.Status;
import com.crud.library.repository.CopyDao;
import com.crud.library.domain.Title;
import com.crud.library.repository.TitleDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        Title title1 = new Title("Tolkien","LORD",2000);

        Copy copy1 = new Copy(title1, Status.AVALAIBLE);
        Copy copy2 = new Copy(title1, Status.LOST);

        //when
        title1.getCopies().add(copy1);
        title1.getCopies().add(copy2);
        copyDao.save(copy1);
        copyDao.save(copy2);

        //then
        Long idCopy1 = copy1.getId();
        Long idCopy2 = copy2.getId();

        List<Copy> optionalCopy = copyDao.findAllByTitle(title1);
        assertEquals(2, optionalCopy.size());

        //delete
//        copyDao.deleteById(idCopy1);
//        copyDao.deleteById(idCopy2);
    }
}
