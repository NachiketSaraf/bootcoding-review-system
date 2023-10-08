package com.bootcoding.review.review.system.controller;

import com.bootcoding.review.review.system.model.User;
import com.bootcoding.review.review.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/health/check")
    public String healthCheckup(){
        return "<h1>ahaam bramhasami</h1>";
    }

    @PostMapping("/user")
    public String createUser(@RequestBody User user){
     userService.save(user);
        return "suceess";
    }

}
