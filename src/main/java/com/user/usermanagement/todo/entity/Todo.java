package com.user.usermanagement.todo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "todo")
@Data
public class Todo {
    @Id
    public String id;

    public String todoTitle;
    public String description;
    public String status;
}
