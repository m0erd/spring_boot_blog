package com.springboot.project.blog.controller;

import com.springboot.project.blog.dto_data_transfer_object.UserDto;
import com.springboot.project.blog.model.User;
import com.springboot.project.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/user/{Id}")
    public UserDto getUserById(@PathVariable Long Id) {
        User user = userService.getUserById(Id);
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody UserDto user) {
        userService.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserDto userDto) {
        try {
            String result = userService.loginUser(userDto);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }



}
