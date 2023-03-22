package com.example.simplerestapi.controller;

import com.example.simplerestapi.exception.ResourceNotFoundException;
import com.example.simplerestapi.model.User;
import com.example.simplerestapi.request.UserRequest;
import com.example.simplerestapi.service.UserService;
import com.example.simplerestapi.dto.UserDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody @Valid UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        log.info("Create new user name : {} ",user.getName());
        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById (@PathVariable("id") long id) throws ResourceNotFoundException {
        return new ResponseEntity<User>(userService.findUserById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@RequestBody @Valid UserRequest userRequest, @PathVariable("id") long id) throws ResourceNotFoundException {
        User user = new User();
        user.setName(userRequest.getName());
        userService.updateUser(user,id);
        log.info("Update user with id {}",user.getName());
        return new ResponseEntity<String>("User update successfully!",HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) throws ResourceNotFoundException {
        userService.deleteUser(id);
        log.info("Delete user with id {}",id);
        return new ResponseEntity<String>("User delete successfully!",HttpStatus.OK);
    }

}
