package com.taf.DatastoreMS.Service.Interface;

import com.taf.DatastoreMS.Model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(Long userId);
    User addUser(User user);
    User updateUser(User user);
}
