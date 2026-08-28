CREATE TABLE clientes (
    id UUID PRIMARY KEY NOT NULL,
    pessoa_id UUID NOT NULL UNIQUE,
    filial_id UUID NOT NULL,
    FOREIGN KEY (pessoa_id) REFERENCES pessoas(id),
    FOREIGN KEY (filial_id) REFERENCES filiais(id)
);