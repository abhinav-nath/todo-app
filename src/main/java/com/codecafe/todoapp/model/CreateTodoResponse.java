package com.codecafe.todoapp.model;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTodoResponse {
    private Long id;
    private String title;
    private String description;
    private LocalDate targetDate;
}