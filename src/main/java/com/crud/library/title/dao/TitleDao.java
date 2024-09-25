package com.crud.library.title.dao;

import com.crud.library.title.Title;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface TitleDao extends CrudRepository<Title, Long> {
}
