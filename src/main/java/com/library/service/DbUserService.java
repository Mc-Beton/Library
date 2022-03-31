package com.library.service;

import com.library.controller.exceptions.UserNotFoundException;
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

    public List<User> getUsers() {return userRepository.findAll();}

    public User saveNewUser(User user) {return userRepository.save(user);}

    public User getUserById(Long id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
