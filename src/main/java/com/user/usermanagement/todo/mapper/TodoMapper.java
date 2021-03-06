package com.user.usermanagement.todo.mapper;

import com.user.usermanagement.todo.dto.TodoDto;
import com.user.usermanagement.todo.entity.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface TodoMapper {

    @Mappings({
            @Mapping(target = "title", source = "todoTitle")
    })
    TodoDto mapToDto(Todo todo);

    @Mappings({
        @Mapping(target = "todoTitle", source = "title"),
        @Mapping(target = "status", defaultValue = "Active", ignore = true)
    })
    Todo mapToEntity(TodoDto todoDto);
}
