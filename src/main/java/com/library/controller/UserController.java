package com.library.controller;

import com.library.controller.exceptions.UserNotFoundException;
import com.library.domain.User;
import com.library.domain.dto.UserDto;
import com.library.mapper.UserMapper;
import com.library.service.DbUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private DbUserService dbUserService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        List<User> users = dbUserService.getUsers();
        return ResponseEntity.ok(userMapper.mapToUserDtoList(users));
    }

    @GetMapping(value = "{userId}")
    public ResponseEntity<UserDto> getUsers(@PathVariable Long userId) throws UserNotFoundException {
        return ResponseEntity.ok(userMapper.mapToUserDto(dbUserService.getUserById(userId)));
    }

    @DeleteMapping(value = "{userId}")
    public ResponseEntity<Void> deleteUser(Long userId) throws UserNotFoundException {
        dbUserService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> newUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        dbUserService.saveNewUser(user);
        return ResponseEntity.ok().build();
    }
}
