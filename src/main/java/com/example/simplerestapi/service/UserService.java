package com.example.simplerestapi.service;

import com.example.simplerestapi.exception.ResourceNotFoundException;
import com.example.simplerestapi.model.User;


import java.util.List;

public interface UserService {
    User saveUser(User user);

    void updateUser(User user, long id) throws ResourceNotFoundException;

    List<User> getAllUser();

    User findUserById(long id) throws ResourceNotFoundException;

    void deleteUser(long id) throws ResourceNotFoundException;


}
