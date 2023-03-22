package com.example.simplerestapi.controller;

import com.example.simplerestapi.exception.ResourceNotFoundException;
import com.example.simplerestapi.model.User;
import com.example.simplerestapi.service.UserService;
import dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
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
    public ResponseEntity<String> updateUser(@RequestBody UserDTO userDTO, @PathVariable("id") long id) throws ResourceNotFoundException {
        User user = new User();
        user.setName(userDTO.getName());
        userService.updateUser(user,id);
        return new ResponseEntity<String>("User update successfully!",HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) throws ResourceNotFoundException {
        userService.deleteUser(id);
        return new ResponseEntity<String>("User delete successfully!",HttpStatus.OK);
    }

}
