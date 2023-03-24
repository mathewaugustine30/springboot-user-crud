package com.mathew.user.springbootcrud.service;

import com.mathew.user.springbootcrud.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    Optional<User> getUser(Long userId);

    User updateUser(Long id, User user);

    User deleteUser(Long userId);

    List<User> getAllUsers();




}
