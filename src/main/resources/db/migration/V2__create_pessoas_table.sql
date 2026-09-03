CREATE TABLE pessoas (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome_completo VARCHAR(50) NOT NULL,
    cpf_cnpj VARCHAR(14) NOT NULL UNIQUE
);
