CREATE TABLE pedidos (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  data_hora datetime NOT NULL,
  status varchar(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE produtos (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  nome varchar(255) NOT NULL,
  preco decimal(19,2) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE item_do_pedido (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  quantidade int(11) NOT NULL,
  pedido_id bigint(20) NOT NULL,
  produto_id bigint(20) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (pedido_id) REFERENCES pedidos(id),
  FOREIGN KEY (produto_id) REFERENCES produtos(id)
);

