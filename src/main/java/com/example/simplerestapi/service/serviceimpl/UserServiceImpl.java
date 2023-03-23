package com.example.simplerestapi.service.serviceimpl;

import com.example.simplerestapi.exception.DuplicateUserName;
import com.example.simplerestapi.exception.ResourceNotFoundException;
import com.example.simplerestapi.model.User;
import com.example.simplerestapi.repository.UserRepository;
import com.example.simplerestapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User saveUser(User user){
            return userRepository.save(user);
    }

    @Override
    public void updateUser(User user, long id) throws ResourceNotFoundException, DuplicateUserName {
        User existingUser = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User","id",id))  ;
        existingUser.setName(user.getName());
        if(userRepository.existsByName(existingUser.getName())) throw new DuplicateUserName("Can't not update, username already used");
        userRepository.save(existingUser);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(long id) throws ResourceNotFoundException {
        Optional<User> user = userRepository.findById(id);
//        if(user.isPresent()){
//            return user.get();
//        }
//        else {
//            throw new ResourceNotFoundException("User","id",id);
//        }
        return userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User","id",id)
        );
    }

    @Override
    public void deleteUser(long id) throws ResourceNotFoundException {
        userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User","id",id));
        userRepository.deleteById(id);
    }

    @Override
    public Boolean existsByName(String name) {
        return userRepository.existsByName(name);
    }
}
