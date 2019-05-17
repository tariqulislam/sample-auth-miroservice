package com.mainul35.restControllers;

import com.mainul35.model.User;
import com.mainul35.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") final String userId) {
        return userRepository.findById(userId).get();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user){
        userRepository.save(user);
    }
}
