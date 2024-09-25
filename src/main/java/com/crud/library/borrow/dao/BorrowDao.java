package com.crud.library.borrow.dao;


import com.crud.library.domain.Borrow;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface BorrowDao extends CrudRepository<Borrow, Long> {
}
