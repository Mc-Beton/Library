package com.library.dao;

import com.library.domain.BookCopy;
import com.library.domain.BookStatusType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface BookCopyDao extends CrudRepository<BookCopy, Long> {

    Optional<BookCopy> findByStatus(BookStatusType bookStatusType);

    @Override
    List<BookCopy> findAll();

    @Override
    BookCopy save(BookCopy bookCopy);

    @Override
    void deleteById(Long id);
}
