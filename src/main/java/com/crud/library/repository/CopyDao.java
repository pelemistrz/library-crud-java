package com.crud.library.repository;


import com.crud.library.domain.Copy;
import com.crud.library.domain.Status;
import com.crud.library.domain.Title;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface CopyDao extends CrudRepository<Copy, Long> {
    List<Copy> findAll();
    Optional<Copy> findById(Long id);
    Copy save(Copy copy);
    void deleteById(Long id);
    List<Copy> findAllByTitle(Title title);
    List<Copy> findAllByTitleAndStatus(Title title, Status status);

}
