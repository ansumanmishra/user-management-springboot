package com.user.usermanagement.todo.dao;

import com.user.usermanagement.todo.entity.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TodoRepository extends MongoRepository<Todo, String> {
     List<Todo> findAllById(String id);
}
