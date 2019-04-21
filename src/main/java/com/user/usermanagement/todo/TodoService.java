package com.user.usermanagement.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    private List<Todo> todos = new ArrayList<>(Arrays.asList(
            new Todo("1", "Gym", "Workout in Gym"),
            new Todo("2", "Shopping", "Shop Vegetables")
    ));

    List<Todo> getAllTodos() {
        return todos;
    }

    List<Todo> getTodosById(String id) {
        return todos.stream().filter(todo -> todo.getId().equals(id)).collect(Collectors.toList());
    }

    List<Todo> addTodo(Todo todo) {
        todoRepository.insert(todo);
        return todoRepository.findAll();
    }

    List<Todo> deleteTodo(String id) {
        todos.removeIf(users -> users.getId().equals(id));
        return todos;
    }

    List<Todo> editTodo(String id, Todo todo) {
        for (int i = 0; i < todos.size(); i++) {
            Todo tempTodo = todos.get(i);
            if(tempTodo.getId().equals(id)) {
                todos.set(i, todo);
            }
        }
        return todos;
    }
}
