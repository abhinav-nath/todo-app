package com.codecafe.todoapp.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTodoResponse {
    private Long id;
    private String title;
    private String description;
    private LocalDate targetDate;
    private LocalDate endDate;
}