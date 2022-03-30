package com.library.dao;

import com.library.domain.BookStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface BookStatusDao extends CrudRepository<BookStatus, Long> {

    @Override
    List<BookStatus> findAll();

    @Override
    BookStatus save(BookStatus bookStatus);
}
