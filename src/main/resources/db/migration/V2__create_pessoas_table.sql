CREATE TABLE pessoas (
    id SERIAL PRIMARY KEY NOT NULL,
    nome_completo VARCHAR(50) NOT NULL,
    cpf_cnpj VARCHAR(14) NOT NULL UNIQUE
);
