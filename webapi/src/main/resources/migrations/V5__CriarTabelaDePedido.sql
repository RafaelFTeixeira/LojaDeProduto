CREATE TABLE pedido (
    id BIGSERIAL NOT NULL,
    data_de_criacao TIMESTAMP,
    situacao int4,
    cliente_id int8,
    PRIMARY KEY (id)
);

CREATE TABLE pedido_item (
    id BIGSERIAL NOT NULL,
    quantidade int4,
    total NUMERIC(19, 2),
    valor NUMERIC(19, 2),
    pedido_id int8,
    produto_id int8,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS pedido
  add CONSTRAINT FK30s8j2ktpay6of18lbyqn3632
  FOREIGN KEY (cliente_id)
  REFERENCES cliente;

ALTER TABLE IF EXISTS pedido_item
  add CONSTRAINT FKeyouxfvoi291lpo5168e6wpej
  FOREIGN KEY (pedido_id)
  REFERENCES pedido;

ALTER TABLE IF EXISTS pedido_item
  add CONSTRAINT FK8eyfr31j751fjws2y012awmpg
  FOREIGN KEY (produto_id)
  REFERENCES produto;