package com.himanshupatankar.dbproject.daos;

import com.himanshupatankar.dbproject.models.Experiment;
import com.himanshupatankar.dbproject.models.Scientist;
import com.himanshupatankar.dbproject.repositories.UserRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserRestOrmDao {
    @Autowired
    UserRestRepository userRepository;

    @PostMapping("/api/users")
    public Scientist createUser(@RequestBody Scientist user) {
        return userRepository.save(user);
    }
    
    @GetMapping("/api/users")
    public List<Scientist> findAllUsers() {
        return userRepository.findAllUsers();
    }
    
    @GetMapping("/api/users/{userId}")
    public Scientist findUserById(
            @PathVariable("userId") Integer id) {
        return userRepository.findUserById(id);
    }




    
    @PutMapping("/api/users/{userId}")
    public Scientist updateUser(
            @PathVariable("userId") Integer id,
            @RequestBody Scientist userUpdates) {
        Scientist user = userRepository.findUserById(id);
        user.setFirstName(userUpdates.getFirstName());
        user.setLastName(userUpdates.getLastName());
        user.setUsername(userUpdates.getUsername());
        user.setPassword(userUpdates.getPassword());
        user.setEmail(userUpdates.getEmail());
        user.setRole(userUpdates.getRole());
        return userRepository.save(user);
    }
    
    @DeleteMapping("/api/users/{userId}")
    public void deleteUser(
            @PathVariable("userId") Integer id) {
        userRepository.deleteById(id);
    }
}