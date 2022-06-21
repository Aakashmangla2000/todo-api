CREATE TABLE TodoList (
    id SERIAL PRIMARY KEY,
    title varchar(100)
);

CREATE TABLE Todo (
    id SERIAL,
    title  varchar(100),
    description  varchar(255),
    completed boolean,
    todolist INT,
    PRIMARY KEY(id),
    FOREIGN KEY(todolist)
    REFERENCES TodoList(id)
);