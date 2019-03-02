CREATE TABLE endereco (
    id BIGSERIAL NOT NULL,
    bairro VARCHAR(255),
    cep VARCHAR(8),
    cidade VARCHAR(255),
    estado VARCHAR(2),
    rua VARCHAR(255),
    PRIMARY KEY (id)
);

    
INSERT INTO endereco(bairro, cep, cidade, estado, rua)
	VALUES('Jardim TV Morena', '79050261', 'Campo Grande', 'MS', 'Rua Spipe Calarge');