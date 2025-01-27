package com.taf.DatastoreMS.Controller;

import com.taf.DatastoreMS.Model.User;
import com.taf.DatastoreMS.Model.Flight;
import com.taf.DatastoreMS.Model.User;
import com.taf.DatastoreMS.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class UserController {
    @Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    public User updateUser(@RequestBody User user) {
        return userRepository.save(user);
    }

}
