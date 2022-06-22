package com.thoughtworks.todo.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    public List<Todo> findAll() {
        return new ArrayList<>();
    }
}
