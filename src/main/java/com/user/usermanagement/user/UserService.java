package com.user.usermanagement.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private List<User> users = new ArrayList<>(Arrays.asList(
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

    List<User> addUser(User user) {
        List<User> isExistUser = users.stream().filter(x -> x.getId().equals(user.getId())).collect(Collectors.toList());
        if (isExistUser.size() < 1) {
            users.add(user);
        }
        return users;
    }
}
