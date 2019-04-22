package com.user.usermanagement.todo;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<TodoDto> getTodos() {
        return todoService.getAllTodos();
    }

    @RequestMapping("/todos/{id}")
    public List<TodoDto> getTodoById(@PathVariable String id) {
        return todoService.getTodosById(id);
    }

    @RequestMapping(value = "/todos", method = RequestMethod.POST)
    public List<TodoDto> addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }

    @RequestMapping(value = "/todos/{id}", method = RequestMethod.DELETE)
    public List<TodoDto> deleteTodo(@PathVariable String id) {
        return todoService.deleteTodo(id);
    }

    @RequestMapping(value = "/todos/{id}", method = RequestMethod.PUT)
    public List<TodoDto> editTodo(@RequestBody Todo todo, @PathVariable String id) {
        return todoService.editTodo(id, todo);
    }
}
