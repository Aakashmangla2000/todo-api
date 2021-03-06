package com.thoughtworks.todo.todo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TodoServiceTest {

    @Autowired
    private TodoRepository todoRepository;

    @AfterEach
    void clearRepository(){
        todoRepository.deleteAll();
    }

    @Test
    void getAllTodos() {
        Todo todo1 = new Todo("Title", "Description", false);
        todoRepository.save(todo1);
        TodoService todoService = new TodoService(todoRepository);

        Todo lastTodo = todoService.getAllTodos().get(todoService.getAllTodos().size() - 1);

        assertEquals(todo1.getTitle(), lastTodo.getTitle());
        assertEquals(todo1.getDescription(), lastTodo.getDescription());
        assertEquals(todo1.isCompleted(), lastTodo.isCompleted());
        assertEquals(todo1.getId(), lastTodo.getId());
    }

    @Test
    void saveATodo() {
        TodoService todoService = new TodoService(todoRepository);
        Todo todo1 = new Todo("Title", "Description", false);

        todoService.addTodo(todo1);

        assertEquals(1.0,todoRepository.count());
    }
}
