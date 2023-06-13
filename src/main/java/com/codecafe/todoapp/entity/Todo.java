package com.codecafe.todoapp.entity;

import com.codecafe.todoapp.model.CreateTodoResponse;
import com.codecafe.todoapp.model.UpdateTodoResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private LocalDate targetDate;

    private LocalDate endDate;

    public CreateTodoResponse toCreateTodoResponse() {
        return CreateTodoResponse.builder()
                .id(id)
                .title(title)
                .description(description)
                .targetDate(targetDate)
                .build();
    }

    public UpdateTodoResponse toUpdateTodoResponse() {
        return UpdateTodoResponse.builder()
                .id(id)
                .title(title)
                .description(description)
                .targetDate(targetDate)
                .endDate(endDate)
                .build();
    }

}