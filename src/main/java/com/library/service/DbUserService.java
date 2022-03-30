package com.library.service;

import com.library.controller.BookNotFoundException;
import com.library.controller.UserNotFoundException;
import com.library.domain.User;
import com.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbUserService {

    private UserRepository userRepository;

    List<User> getUsers() {return userRepository.findAll();}

    User saveNewUser(User user) {return userRepository.save(user);}

    User getUser(Long id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}
