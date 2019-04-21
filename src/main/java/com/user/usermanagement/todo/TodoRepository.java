package com.user.usermanagement.todo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo, String> {
    // List<Todo> findAllById(String id);
    // List<Todo> findBy_id(ObjectId _id);
}
