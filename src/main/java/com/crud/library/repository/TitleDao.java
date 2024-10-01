package com.crud.library.repository;

import com.crud.library.domain.Title;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface TitleDao extends CrudRepository<Title, Long> {

    Title findByTitle(String title);
    List<Title> findAll();
    Optional<Title> findById(Long id);
    Title save(Title title);
    void deleteById(Long id);

}
