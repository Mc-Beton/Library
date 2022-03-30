package com.library.repository;

import com.library.domain.BookStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface BookStatusRepository extends CrudRepository<BookStatus, Long> {

    @Override
    List<BookStatus> findAll();

    @Override
    BookStatus save(BookStatus bookStatus);
}
