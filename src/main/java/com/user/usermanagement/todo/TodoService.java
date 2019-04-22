package com.user.usermanagement.todo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
class TodoService {

    private final TodoRepository todoRepository;

    public List<TodoDto> getAllTodos() {
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

    public List<TodoDto> getTodosById(String id) {
        return todoRepository.findAllById(id)
                .stream()
                .map(this::mapToDto).collect(toList());
    }

    public List<TodoDto> addTodo(Todo todo) {
        todo.setStatus("Active");
        todoRepository.insert(todo);
        return getAllTodos();
    }

    public List<TodoDto> deleteTodo(String id) {
        todoRepository.deleteById(id);
        return getAllTodos();
    }

    List<TodoDto> editTodo(String id, Todo todo) {
        todoRepository.save(todo);
        return getAllTodos();
    }
}
