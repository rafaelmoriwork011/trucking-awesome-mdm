CREATE TABLE cargos (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    descricao VARCHAR(30) NOT NULL UNIQUE
);