package com.user.usermanagement.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private ArrayList<User> users = new ArrayList<>(Arrays.asList(
            new User("1", "John", "USA"),
            new User("2", "Jack", "Switzerland"),
            new User("3", "Smith", "France")
    ));

    List<User> getAllUsers() {
        return users;
    }

    List<User> getUsersById(String id) {
        return users.stream().filter(user -> user.getId().equals(id)).collect(Collectors.toList());
    }


    public List<User> addUser(User user) {
        users.add(user);
        return users;
    }
}
