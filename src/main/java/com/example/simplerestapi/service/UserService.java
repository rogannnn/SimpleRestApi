package com.example.simplerestapi.service;

import com.example.simplerestapi.exception.DuplicateUserName;
import com.example.simplerestapi.exception.ResourceNotFoundException;
import com.example.simplerestapi.model.User;


import java.util.List;

public interface UserService {
    User saveUser(User user);

    void updateUser(User user, long id) throws ResourceNotFoundException, DuplicateUserName;

    List<User> getAllUser();

    User findUserById(long id) throws ResourceNotFoundException;

    void deleteUser(long id) throws ResourceNotFoundException;

    Boolean existsByName(String name);


}
