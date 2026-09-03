CREATE TABLE funcionarios (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    pessoa_id UUID NOT NULL UNIQUE,
    cargo_id UUID NOT NULL,
    filial_id UUID NOT NULL,
    FOREIGN KEY (pessoa_id) REFERENCES pessoas(id),
    FOREIGN KEY (cargo_id) REFERENCES cargos(id),
    FOREIGN KEY (filial_id) REFERENCES filiais(id)
);