package com.taf.DatastoreMS.Controller;

import com.taf.DatastoreMS.Model.User;
import com.taf.DatastoreMS.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/datastore")
public class DataStoreController {
    @Autowired
    private final UserRepository userRepository;

    public DataStoreController(UserRepository userRepository) {
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

}
