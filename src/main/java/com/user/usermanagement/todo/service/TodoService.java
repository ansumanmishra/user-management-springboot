package com.user.usermanagement.todo.service;

import com.user.usermanagement.todo.dao.TodoRepository;
import com.user.usermanagement.todo.dto.TodoDto;
import com.user.usermanagement.todo.entity.Todo;
import com.user.usermanagement.todo.mapper.TodoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    public List<TodoDto> getAllTodos() {
        List<Todo> todoData = todoRepository.findAll();
        return todoData.stream().map(this::mapToDto).collect(toList());
    }

    private TodoDto mapToDto(Todo todo) {
        return todoMapper.mapToDto(todo);
    }

    public List<TodoDto> getTodosById(String id) {
        return todoRepository.findAllById(id)
                .stream()
                .map(this::mapToDto).collect(toList());
    }

    public List<TodoDto> addTodo(TodoDto todo) {
        Todo todoData = setTodoData(todo);
        todoRepository.insert(todoData);
        return getAllTodos();
    }

    public List<TodoDto> deleteTodo(String id) {
        todoRepository.deleteById(id);
        return getAllTodos();
    }

    public List<TodoDto> editTodo(String id, TodoDto todo) {
        Todo todoData = setTodoData(todo);
        todoRepository.save(todoData);
        return getAllTodos();
    }

    private Todo setTodoData(TodoDto todo) {
        return todoMapper.mapToEntity(todo);
        /*
        Todo todoData = new Todo();
        todoData.setStatus("Active");
        todoData.setId(todo.getId());
        todoData.setTodoTitle(todo.getTitle());
        todoData.setDescription(todo.getDescription());

        return todoData;
        */
    }
}
