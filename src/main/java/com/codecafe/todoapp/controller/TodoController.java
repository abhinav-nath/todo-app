package com.codecafe.todoapp.controller;

import com.codecafe.todoapp.dto.TodoDTO;
import com.codecafe.todoapp.entity.Todo;
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
    public Todo createTodo(@RequestBody TodoDTO todoDTO) {
        System.out.println("call to create TODO with request: " + todoDTO);
        return todoService.createTodo(todoDTO);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo updatedTodo) {
        return todoService.updateTodo(id, updatedTodo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }

}