package com.crud.library.service;


import com.crud.library.domain.Reader;
import com.crud.library.domain.Title;
import com.crud.library.dto.ReaderDto;
import com.crud.library.errors.ReaderNotFoundException;
import com.crud.library.errors.TitleNotFoundException;
import com.crud.library.repository.ReaderDao;
import com.crud.library.repository.TitleDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class DbService {
    private final ReaderDao readerDao;
    private final TitleDao titleDao;

    //Readers
    public List<Reader> getAllReaders() {
        return readerDao.findAll();
    }
    public Reader getReader(Long id) throws ReaderNotFoundException{
        return readerDao.findById(id).orElseThrow(ReaderNotFoundException::new);
    }
    public Reader saveReader(Reader reader) {
        return readerDao.save(reader);
    }
    public void deleteReaderById(Long id){
        readerDao.deleteById(id);
    }
    //Titles
    public List<Title> getAllTitles() {
        return titleDao.findAll();
    }
    public Title getTitle(Long id) throws TitleNotFoundException {
        return titleDao.findById(id).orElseThrow(TitleNotFoundException::new);
    }
    public Title saveTitle(Title title) {
        return titleDao.save(title);
    }
    public void deleteTitleById(Long id){
        titleDao.deleteById(id);
    }
}
