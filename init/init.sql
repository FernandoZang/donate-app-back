-- Em PostgreSQL, você seleciona o banco de dados desejado ao se conectar.
-- Caso precise criar o banco de dados SANEM:
--   CREATE DATABASE sanem;
-- Então, conecte-se a ele com: \c sanem

-- Tabela CIDADE
CREATE TABLE CIDADE (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

-- Tabela USUARIO
CREATE TABLE USUARIO (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    login VARCHAR(150) NOT NULL,
    senha VARCHAR(150) NOT NULL,
    cpf VARCHAR(20) NOT NULL,
    email VARCHAR(50),
    fone VARCHAR(50),
    uf VARCHAR(2) NOT NULL,
    bairro VARCHAR(255) NOT NULL,
    logradouro VARCHAR(255) NOT NULL,
    logradouro_tipo VARCHAR(255) NOT NULL,
    numero VARCHAR(255) NOT NULL,
    complemento VARCHAR(255),
    status VARCHAR(50) NOT NULL,
    active VARCHAR(50) NOT NULL,
    cod_cidade INT NOT NULL,
    constraint usuario_login_key unique (login),
    FOREIGN KEY (cod_cidade) REFERENCES CIDADE(id)
);

-- Tabela BENEFICIARIO
CREATE TABLE BENEFICIARIO (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    cpf VARCHAR(20),
    email VARCHAR(50),
    fone VARCHAR(50),
    tipo VARCHAR(50) NOT NULL,
    uf VARCHAR(2) NOT NULL,
    bairro VARCHAR(255),
    logradouro VARCHAR(255),
    logradouro_tipo VARCHAR(255),
    numero VARCHAR(255),
    complemento VARCHAR(255),
    status VARCHAR(50) NOT NULL,
    active VARCHAR(50) NOT NULL,
    observacao VARCHAR(500),
    cod_cidade INT NOT NULL,
    FOREIGN KEY (cod_cidade) REFERENCES CIDADE(id)
);

-- Tabela REGRA_ACESSO
CREATE TABLE REGRA_ACESSO (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL
    constraint regra_acesso_nome_key unique (nome)
);

-- Tabela USUARIO_REGRA_ACESSO (tabela de relacionamento muitos para muitos)
CREATE TABLE USUARIO_REGRA_ACESSO (
    usuario_id INT NOT NULL,
    regra_id INT NOT NULL,
    PRIMARY KEY (usuario_id, regra_id),
    FOREIGN KEY (usuario_id) REFERENCES USUARIO(id),
    FOREIGN KEY (regra_id) REFERENCES REGRA_ACESSO(id)
);

-- Tabela PRODUTO
CREATE TABLE PRODUTO (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(100) NOT NULL,
    quantidade INT NOT NULL,
    tipo VARCHAR(100) NOT NULL,
    tamanho VARCHAR(100) NOT NULL
);

-- Tabela DISTRIBUICAO
CREATE TABLE DISTRIBUICAO (
    cod_usuario INT NOT NULL,
    cod_produto INT NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    quantidade INT NOT NULL,
    data TIMESTAMP NOT NULL,
    PRIMARY KEY (cod_usuario, cod_produto),
    FOREIGN KEY (cod_usuario) REFERENCES USUARIO(id),
    FOREIGN KEY (cod_produto) REFERENCES PRODUTO(id)
);

-- Tabela HISTORICO
CREATE TABLE HISTORICO (
    cod_produto INT NOT NULL,
    cod_usuario INT NOT NULL,
    quantidade INT NOT NULL,
    tipo_movimento VARCHAR(2) NOT NULL,
    PRIMARY KEY (cod_produto, cod_usuario),
    FOREIGN KEY (cod_produto) REFERENCES PRODUTO(id),
    FOREIGN KEY (cod_usuario) REFERENCES USUARIO(id)
);

-- Inserts

INSERT INTO CIDADE (nome) VALUES ('CASCAVEL');

INSERT INTO REGRA_ACESSO (nome) VALUES ('SYS');
INSERT INTO REGRA_ACESSO (nome) VALUES ('ADMIN');
INSERT INTO REGRA_ACESSO (nome) VALUES ('GERENTE');
INSERT INTO REGRA_ACESSO (nome) VALUES ('ATENDENTE');

INSERT INTO USUARIO (nome, login, senha, cpf, email, fone, tipo, uf, bairro, logradouro, logradouro_tipo, numero, complemento, status, active, cod_cidade)
VALUES ('SYSTEM', 'SYS', '$2a$10$4a6gh/Y6S4t.N7S8a.gCZ.IELIdLFtiLa/U0GL9IsnaaY8TvtbZ3S', 'NOT', 'system@hotmail.com', 'NOT', 'SYSTEM', 'BR', 'NOT', 'NOT', 'NOT', 'NOT', 'NOT', 'ATIVO', 'TRUE', 1);

INSERT INTO USUARIO_REGRA_ACESSO (usuario_id, regra_id) VALUES (1, 1);