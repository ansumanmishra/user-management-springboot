package com.user.usermanagement.todo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Service
@Getter @Setter
public class Todo {
    @Id
    public String id;
    public String title;
    public String description;

    public Todo(String id, String title, String description)
    {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
