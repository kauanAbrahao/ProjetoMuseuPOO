CREATE TABLE visita_cad(
dataref date PRIMARY KEY , valorPago varchar(20), cpf varchar(12), FOREIGN KEY (cpf) REFERENCES visitante_cad(cpf), quantidade int
);