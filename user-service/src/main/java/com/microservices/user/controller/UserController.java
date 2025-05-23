package com.microservices.user.controller;

import com.microservices.user.VO.ResponseTemplateVO;
import com.microservices.user.entity.User;
import com.microservices.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Inside getUserWithDepartment of UserController");
        return userService.getUserWithDepartment(userId);
    }

    @GetMapping("/")
    public List<User> getAllUsers() {
        log.info("Inside getAllUsers of UserController");
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long userId, @RequestBody User user) {
        log.info("Inside updateUser of UserController");
        return userService.updateUser(userId, user);
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable("id") Long userId) {
        log.info("Inside deleteUser of UserController");
        return userService.deleteUser(userId);
    }
}

//test comment