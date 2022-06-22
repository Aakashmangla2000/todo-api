package com.thoughtworks.todo.todo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class TodoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private TodoService todoService;

    @Test
    void whenGetRequest_thenReturnAllTodos() throws Exception {
        List<Todo> todoList = List.of(new Todo("Title", "Description", false));
        when(todoService.getAllTodos()).thenReturn(todoList);

        ResultActions result = mockMvc.perform(get("/api/todos")
                .contentType(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(equalTo(todoList.size()))));
    }

    @Test
    void whenPostRequest_thenReturnSameObject() throws Exception {
        Todo todo = new Todo("Title", "Description", false);
        when(todoService.addTodo(any(Todo.class))).thenReturn(todo);
        ObjectMapper objectMapper = new ObjectMapper();
        String todoJson = objectMapper.writeValueAsString(todo);

        ResultActions result = mockMvc.perform(post("/api/todos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(todoJson)
        );

        result.andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Title"))
                .andExpect(jsonPath("$.description").value("Description"))
                .andExpect(jsonPath("$.completed").value(false));
    }
}
