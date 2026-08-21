CREATE TABLE clientes (
    id SERIAL PRIMARY KEY NOT NULL,
    pessoa_id INTEGER NOT NULL UNIQUE,
    filial_id INTEGER NOT NULL,
    FOREIGN KEY (pessoa_id) REFERENCES pessoas(id),
    FOREIGN KEY (filial_id) REFERENCES filiais(id)
);