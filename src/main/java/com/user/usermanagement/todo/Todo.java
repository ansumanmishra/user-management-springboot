package com.user.usermanagement.todo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "todo")
@Data
public class Todo {
    @Id
    public String id;
    public String title;
    public String description;
}
