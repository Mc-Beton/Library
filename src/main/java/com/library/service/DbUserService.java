package com.library.service;

import com.library.controller.BookNotFoundException;
import com.library.controller.UserNotFoundException;
import com.library.domain.User;
import com.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbUserService {

    @Autowired
    private UserRepository userRepository;

    List<User> getUsers() {return userRepository.findAll();}

    User saveNewUser(User user) {return userRepository.save(user);}

    User getUserById(Long id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}
