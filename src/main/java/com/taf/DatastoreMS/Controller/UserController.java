package com.taf.DatastoreMS.Controller;

import com.taf.DatastoreMS.Model.User;
import com.taf.DatastoreMS.Model.Flight;
import com.taf.DatastoreMS.Model.User;
import com.taf.DatastoreMS.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/{userId}")
    public Optional<User> getUserById(@PathVariable Long userId) {
        return userServiceImpl.getUserById(userId);
    }

    @PostMapping("/register")
    public User addUser(@RequestBody User user) {
        return userServiceImpl.addUser(user);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId,@RequestBody User user) {
        return userServiceImpl.updateUser(user);
    }
}
