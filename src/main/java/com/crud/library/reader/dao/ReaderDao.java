package com.crud.library.reader.dao;


import com.crud.library.reader.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ReaderDao extends CrudRepository<Reader, Long> {
}
