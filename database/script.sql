CREATE TABLE tarefas (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255),
    descricao VARCHAR(255),
    status VARCHAR(255),
    observacoes VARCHAR(255),
    data_criacao TIMESTAMP,
    data_atualizacao TIMESTAMP
);