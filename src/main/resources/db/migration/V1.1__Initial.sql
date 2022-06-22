CREATE TABLE todo (
    id SERIAL,
    title  varchar(100),
    description  varchar(255),
    completed boolean,
    PRIMARY KEY(id)
);