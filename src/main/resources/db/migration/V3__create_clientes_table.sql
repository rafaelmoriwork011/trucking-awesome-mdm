CREATE TABLE clientes (
    id SERIAL PRIMARY KEY NOT NULL,
    pessoa_id INTEGER NOT NULL UNIQUE,
    FOREIGN KEY (pessoa_id) REFERENCES pessoas(id)
);