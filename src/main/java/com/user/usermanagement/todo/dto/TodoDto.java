package com.user.usermanagement.todo.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TodoDto {
    private String id;

    @NotNull(message = "Title should not be blank")
    private String title;
    private String description;
}
