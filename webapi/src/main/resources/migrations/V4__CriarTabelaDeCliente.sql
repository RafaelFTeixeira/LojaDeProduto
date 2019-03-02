CREATE TABLE cliente (
    id  BIGSERIAL NOT NULL,
    email VARCHAR(255),
    nome VARCHAR(255),
    senha VARCHAR(255),
    endereco_id int8,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS cliente
    ADD CONSTRAINT FK64nr9yt889by5lufr1boo5i4s
    FOREIGN KEY (endereco_id)
    REFERENCES endereco;
    
INSERT INTO cliente(email, nome, senha, endereco_id)
	VALUES('teste@email.com', 'Rafael Teixeira', '98765', (SELECT id FROM Endereco LIMIT 1));