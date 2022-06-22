package com.thoughtworks.todo.todo;

import javax.persistence.Entity;

@Entity
public class Todo {
    private boolean completed;
    private String description;
    private String title;

    public Todo(String title, String description, boolean completed) {
        this.title = title;
        this.description = description;
        this.completed = completed;
    }
}
