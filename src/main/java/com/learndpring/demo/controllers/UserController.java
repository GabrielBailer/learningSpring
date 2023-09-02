package com.learndpring.demo.controllers;

import com.learndpring.demo.entities.User;
import com.learndpring.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepository repository;
    @GetMapping
    public List<User> findAll(){
        List<User> request = repository.findAll();
        return  request;
    }
    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id){
        User request = repository.findById(id).orElse(null);
        return request;
    }

    @PostMapping
    public User insert(@RequestBody User user){
        User request = repository.save(user);
        return request;
    }
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
