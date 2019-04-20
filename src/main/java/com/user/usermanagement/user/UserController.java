package com.user.usermanagement.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping("/users/{id}")
    public List<User> getUsersById(@PathVariable String id) {
        return userService.getUsersById(id);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public List<User> getUsersById(@RequestBody User user) {
        return userService.addUser(user);
    }
}