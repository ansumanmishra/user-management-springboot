package com.user.usermanagement.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Service
@Getter @Setter
public class User {
    public String id;
    public String name;
    public String country;

    public User(String id, String name, String country)
    {
        this.id = id;
        this.name = name;
        this.country = country;
    }
}
