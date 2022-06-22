package com.thoughtworks.todo.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    ResponseEntity<List<Todo>> getAllToDos() {
        return new ResponseEntity<>(todoService.getAllTodos(), HttpStatus.OK);
    }

    @PostMapping("/todos")
    ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
        return new ResponseEntity<>(todoService.addTodo(todo), HttpStatus.CREATED);
    }
}
