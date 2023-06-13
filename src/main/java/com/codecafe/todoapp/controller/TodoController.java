package com.codecafe.todoapp.controller;

import com.codecafe.todoapp.model.CreateTodoRequest;
import com.codecafe.todoapp.entity.Todo;
import com.codecafe.todoapp.model.CreateTodoResponse;
import com.codecafe.todoapp.model.UpdateTodoRequest;
import com.codecafe.todoapp.model.UpdateTodoResponse;
import com.codecafe.todoapp.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.fetchAllTodos();
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id) {
        return todoService.fetchTodoById(id);
    }

    @PostMapping
    public CreateTodoResponse createTodo(@RequestBody CreateTodoRequest createTodoRequest) {
        System.out.println("call to create TODO with request: " + createTodoRequest);
        return todoService.createTodo(createTodoRequest).toCreateTodoResponse();
    }

    @PutMapping("/{id}")
    public UpdateTodoResponse updateTodo(@PathVariable Long id, @RequestBody UpdateTodoRequest updatedTodo) {
        return todoService.updateTodo(id, updatedTodo).toUpdateTodoResponse();
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }

}