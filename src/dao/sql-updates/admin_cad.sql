CREATE TABLE admin_cad(
login varchar(20) NOT NULL UNIQUE, senha varchar(20) NOT NULL, ativo boolean DEFAULT true
);