CREATE TABLE jogos (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       nome VARCHAR(255) NOT NULL,
                       descricao TEXT,
                       datalancamento DATE,
                       developer_id BIGINT,
                       genero VARCHAR(255),
                       urlCapa VARCHAR(255),
                       FOREIGN KEY (developer_id) REFERENCES dev(id)
);

CREATE TABLE jogo_console (
                              jogo_id BIGINT,
                              console_id BIGINT,
                              FOREIGN KEY (jogo_id) REFERENCES jogos(id),
                              FOREIGN KEY (console_id) REFERENCES console(id),
                              PRIMARY KEY (jogo_id, console_id)
);