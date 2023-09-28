package com.example.springproject;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping
    public String getUser() {
        return "HTTPS GET Request";
    }

    @PostMapping
    public String createUser() {
        return "HTTPS POST Request";
    }

    @PutMapping
    public String updateUser() {
        return "HTTPS PUT Request";
    }

    @DeleteMapping
    public String deleteUser() {
        return "HTTPS DELETE Request";
    }
}
