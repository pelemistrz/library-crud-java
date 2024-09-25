package com.crud.library.copy.dao;


import com.crud.library.copy.Copy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CopyDao extends CrudRepository<Copy, Long> {
}
