CREATE TABLE IF NOT EXISTS pessoa (
    id bigint generated BY DEFAULT AS identity,
    cpf VARCHAR(255) NOT NULL,
    data_nascimento DATE NULL,
    email VARCHAR(50) NOT NULL,
    endereco VARCHAR(100) NOT NULL,
    primeiro_nome VARCHAR(50) NOT NULL,
    segundo_nome VARCHAR(80) NOT NULL,
    sexo VARCHAR(9) NOT NULL,
    PRIMARY KEY(id)
);