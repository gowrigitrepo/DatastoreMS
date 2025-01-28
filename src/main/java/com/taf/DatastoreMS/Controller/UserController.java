package com.taf.DatastoreMS.Controller;

import com.taf.DatastoreMS.Model.User;
import com.taf.DatastoreMS.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveData(@RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok("Data saved successfully");
    }

    @GetMapping("fetch/{id}")
    public ResponseEntity<Optional<User>> fetchData(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateData(@PathVariable Long id,@RequestBody User user) {
        Optional<User> userToUpdate = userRepository.findById(id);
        if (userToUpdate.isPresent()) {
            User userData = userToUpdate.get();
            userData.setEmail(user.getEmail());
            userRepository.save(userData);
        } else {
            throw new RuntimeException("User not found with id to update" + id);
        }
        return ResponseEntity.ok("Data updated successfully");
    }

}
