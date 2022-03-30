package com.library.dao;

import com.library.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Long> {

    @Override
    List<User> findAll();

    @Override
    User save(User user);

    @Override
    void deleteById(Long id);
}
