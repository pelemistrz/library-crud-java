package com.crud.library.repository;


import com.crud.library.domain.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface ReaderDao extends CrudRepository<Reader, Long> {
    List<Reader> findAll();
    Optional<Reader> findById(Long id);
    Reader save(Reader reader);
}
