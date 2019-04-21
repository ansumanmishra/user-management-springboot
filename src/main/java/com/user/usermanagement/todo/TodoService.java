package com.user.usermanagement.todo;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    List<TodoDto> getAllTodos() {
        List<Todo> todoData = todoRepository.findAll();
        return todoData.stream().map(this::mapToDto).collect(toList());
    }

    private TodoDto mapToDto(Todo todo) {
        TodoDto todoDto = new TodoDto();
        todoDto.setId(todo.id);
        todoDto.setTitle(todo.title);
        todoDto.setDescription(todo.description);

        return todoDto;
    }

    ResponseEntity<Todo> getTodosById(String id) {
        return todoRepository.findById(id)
                .map(todo -> ResponseEntity.ok().body(todo))
                .orElse(ResponseEntity.notFound().build());
    }

    List<TodoDto> addTodo(Todo todo) {
        todo.setStatus("Active");
        todoRepository.insert(todo);
        return getAllTodos();
    }

    ResponseEntity<?> deleteTodo(String id) {
        return todoRepository.findById(id)
                .map(todo -> {
                    todoRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    ResponseEntity<Todo> editTodo(String id, Todo todo) {
        return todoRepository.findById(id)
                .map(todoData -> {
                    todoData.setTitle(todo.getTitle());
                    todo.setDescription(todo.getDescription());
                    Todo updatedTodo = todoRepository.save(todoData);
                    return ResponseEntity.ok().body(updatedTodo);
                }).orElse(ResponseEntity.notFound().build());
    }
}
