CREATE TABLE pedidos (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  valor decimal(19,2) NOT NULL,
   nome varchar(100) DEFAULT NULL,
  data_hora datetime NOT NULL,
  status varchar(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE item_do_pedido (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  descricao varchar(255) DEFAULT NULL,
  quantidade int(11) NOT NULL,
  pedido_id bigint(20) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (pedido_id) REFERENCES pedidos(id)
);