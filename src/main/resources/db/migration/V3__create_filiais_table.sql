CREATE TABLE filiais (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    sigla VARCHAR(3) NOT NULL UNIQUE
);