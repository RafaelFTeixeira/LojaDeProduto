CREATE TABLE categoria (
   id  BIGSERIAL NOT NULL,
   nome VARCHAR(255),
   PRIMARY KEY (id)
);

INSERT INTO categoria(nome) VALUES('Moto');