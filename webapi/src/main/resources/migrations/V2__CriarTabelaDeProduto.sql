CREATE TABLE produto (
   id BIGSERIAL NOT NULL,
   descricao VARCHAR(255),
   nome VARCHAR(120),
   preco NUMERIC(19, 2),
   quantidade int4,
   caminho_da_imagem VARCHAR(255),
   categoria_id int8,
   PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS produto
   add CONSTRAINT FKopu9jggwnamfv0c8k2ri3kx0a
   FOREIGN KEY (categoria_id)
   REFERENCES categoria;


INSERT INTO produto(nome, descricao, preco, quantidade, caminho_da_imagem, categoria_id)
	VALUES('FAZER 250', 'YAMAHA FAZER 250', 15499, 3, '',
		  (SELECT id FROM categoria LIMIT 1));

INSERT INTO produto(nome, descricao, preco, quantidade, caminho_da_imagem, categoria_id)
	VALUES('CB 500', 'HONDA CB 500CC', 23899, 2, '',
		  (SELECT id FROM categoria LIMIT 1));