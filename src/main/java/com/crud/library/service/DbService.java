package com.crud.library.service;


import com.crud.library.domain.Reader;
import com.crud.library.dto.ReaderDto;
import com.crud.library.errors.ReaderNotFoundException;
import com.crud.library.repository.ReaderDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class DbService {
    private final ReaderDao readerDao;


    public List<Reader> getAllReaders() {
        return readerDao.findAll();
    }
    public Reader getReader(Long id) throws ReaderNotFoundException{
        return readerDao.findById(id).orElseThrow(ReaderNotFoundException::new);
    }


}
