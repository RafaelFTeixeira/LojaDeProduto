CREATE TABLE produto (
   id BIGSERIAL NOT NULL,
   descricao VARCHAR(255),
   nome VARCHAR(120),
   preco NUMERIC(19, 2),
   quantidade int4,
   caminhoDaImagem VARCHAR(255),
   categoria_id int8,
   PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS produto
   add CONSTRAINT FKopu9jggwnamfv0c8k2ri3kx0a
   FOREIGN KEY (categoria_id)
   REFERENCES categoria;