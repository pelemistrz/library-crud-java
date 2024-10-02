package com.crud.library.repository;


import com.crud.library.domain.Borrow;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface BorrowDao extends CrudRepository<Borrow, Long> {
    List<Borrow> findAll();
    Optional<Borrow> findById(Long id);
    Borrow save(Borrow borrow);
    void deleteById(Long id);

}
