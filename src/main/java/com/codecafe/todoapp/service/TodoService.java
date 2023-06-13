package com.codecafe.todoapp.service;

import com.codecafe.todoapp.entity.Todo;
import com.codecafe.todoapp.model.CreateTodoRequest;
import com.codecafe.todoapp.model.UpdateTodoRequest;
import com.codecafe.todoapp.repository.TodoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> fetchAllTodos() {
        return todoRepository.findAll();
    }

    public Todo fetchTodoById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid todo Id: " + id));
    }

    public Todo createTodo(CreateTodoRequest createTodoRequest) {
        Todo todo = Todo.builder()
                .title(createTodoRequest.getTitle())
                .description(createTodoRequest.getDescription())
                .targetDate(createTodoRequest.getTargetDate())
                .build();
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long id, UpdateTodoRequest UpdateTodoRequest) {
        Todo existingTodo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid todo Id: " + id));
        BeanUtils.copyProperties(UpdateTodoRequest, existingTodo, "id");
        return todoRepository.save(existingTodo);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

}
