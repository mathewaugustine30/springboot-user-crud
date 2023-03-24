package com.mathew.user.springbootcrud.service;

import com.mathew.user.springbootcrud.domain.User;
import com.mathew.user.springbootcrud.exception.UserNotFoundException;
import com.mathew.user.springbootcrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUser(Long userId) {

        Optional<User> user = userRepository.findById(userId);
        if(!user.isPresent()){
            throw new UserNotFoundException(userId);
        }else{
            return userRepository.findById(userId);
        }
    }

    @Override
    public User updateUser(Long userId, User user) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(!userOptional.isPresent()){
            throw new UserNotFoundException(userId);
        }else{
           User userRetrieved = userOptional.get();
            userRetrieved.setName(user.getName());
            userRetrieved.setEmail(user.getEmail());
            return userRepository.save(userRetrieved);
        }
    }

    @Override
    public User deleteUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException(userId);
        } else {
            userRepository.deleteById(userId);
        }
        return userOptional.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
