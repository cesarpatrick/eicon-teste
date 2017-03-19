CREATE SCHEMA eicon;

CREATE TABLE eicon.cliente (
  id int(11) NOT NULL,
  nome varchar(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE eicon.pedido (
  id int(11) NOT NULL,
  data datetime NOT NULL,
  nome varchar(255) NOT NULL,
  quantidade int(11) NOT NULL,
  valorTotal double NOT NULL,
  valorUnitario double NOT NULL,
  cliente_id int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_jvfwgjbqjdp5sk1qto0trgpla (cliente_id),
  CONSTRAINT FK_jvfwgjbqjdp5sk1qto0trgpla FOREIGN KEY (cliente_id) REFERENCES cliente (id)
);

INSERT INTO eicon.cliente (id, nome) VALUES ('1', 'Tiago da silva');
INSERT INTO eicon.cliente (id, nome) VALUES ('2', 'João José');
INSERT INTO eicon.cliente (id, nome) VALUES ('3', 'Paula Felipa de Souza');
INSERT INTO eicon.cliente (id, nome) VALUES ('4', 'Cesar Gouveia');
INSERT INTO eicon.cliente (id, nome) VALUES ('5', 'Adriana Ribeiro');
INSERT INTO eicon.cliente (id, nome) VALUES ('6', 'Amanda Medeiros');
INSERT INTO eicon.cliente (id, nome) VALUES ('7', 'Rômulo Alves');
INSERT INTO eicon.cliente (id, nome) VALUES ('8', 'Ivonete Santos');
INSERT INTO eicon.cliente (id, nome) VALUES ('9', 'Jhonis Souza');
INSERT INTO eicon.cliente (id, nome) VALUES ('10', 'Reynaldo Junior');
