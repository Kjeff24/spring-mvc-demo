package org.example.controllers;

import org.example.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RestApiController {

    @GetMapping
    public User Hello(){
        return new User("Test User", 14);
    }
}
