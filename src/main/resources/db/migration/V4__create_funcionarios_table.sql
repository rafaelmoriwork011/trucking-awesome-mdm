CREATE TABLE funcionarios (
    id SERIAL PRIMARY KEY NOT NULL,
    pessoa_id INTEGER NOT NULL UNIQUE,
    cargo_id INTEGER NOT NULL,
    FOREIGN KEY (pessoa_id) REFERENCES pessoas(id),
    FOREIGN KEY (cargo_id) REFERENCES cargos(id)
);