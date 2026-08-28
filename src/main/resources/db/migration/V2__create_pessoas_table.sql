CREATE TABLE pessoas (
    id UUID PRIMARY KEY NOT NULL,
    nome_completo VARCHAR(50) NOT NULL,
    cpf_cnpj VARCHAR(14) NOT NULL UNIQUE
);
