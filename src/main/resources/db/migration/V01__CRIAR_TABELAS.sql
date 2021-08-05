CREATE TABLE pedido (
	codigo INT AUTO_INCREMENT,
    descricao VARCHAR(255) NOT NULL,
    status VARCHAR(20) NOT NULL,
	quantidade INT NOT NULL,
	quantidade_apv INT,    
    data_pedido DATE,
    data_vencimento DATE,
    PRIMARY KEY (codigo)
);
