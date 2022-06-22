package com.thoughtworks.todo.todo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

    @Bean
    public CommandLineRunner setup(TodoRepository todoRepository) {
        return (args) -> {
            todoRepository.save(new Todo("Title1", "Description1", false));
            todoRepository.save(new Todo("Title2", "Description2", true));
            todoRepository.save(new Todo("Title3", "Description3", false));
        };
    }

}
