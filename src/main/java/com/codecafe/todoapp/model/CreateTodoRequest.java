package com.codecafe.todoapp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class CreateTodoRequest {
    private String title;
    private String description;
    private LocalDate targetDate;
}