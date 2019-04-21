package com.user.usermanagement.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/todos")
    public List<Todo> getTodos() {
        return todoService.getAllTodos();
    }

    @RequestMapping("/todos/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable String id) {
        return todoService.getTodosById(id);
    }

    @RequestMapping(value = "/todos", method = RequestMethod.POST)
    public List<Todo> addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }

    @RequestMapping(value = "/todos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteTodo(@PathVariable String id) {
        return todoService.deleteTodo(id);
    }

    @RequestMapping(value = "/todos/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Todo> editTodo(@RequestBody Todo todo, @PathVariable String id) {
        return todoService.editTodo(id, todo);
    }
}
