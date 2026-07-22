CREATE TABLE categoria (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    codigo VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE produto (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    preco NUMERIC(10,2) NOT NULL CHECK(preco >= 0),
    estoque INTEGER NOT NULL,
    codigo_barra VARCHAR(50) UNIQUE NOT NULL,
    categoria_id INTEGER NOT NULL,

    CONSTRAINT fk_produto_categoria
    FOREIGN KEY (categoria_id)
    REFERENCES categoria(id)
);

CREATE TABLE venda (
    id BIGSERIAL PRIMARY KEY,
    data TIMESTAMP NOT NULL,
    total NUMERIC(10,2) NOT NULL
);

CREATE TABLE item_venda (
    id BIGSERIAL PRIMARY KEY,
    quantidade INTEGER NOT NULL,
    preco_unitario NUMERIC(10,2) NOT NULL,
    subtotal NUMERIC(10,2) NOT NULL,

    venda_id BIGINT NOT NULL,
    produto_id BIGINT NOT NULL,

    CONSTRAINT fk_item_venda
    FOREIGN KEY (venda_id)
    REFERENCES venda(id),

    CONSTRAINT fk_item_produto
    FOREIGN KEY (produto_id)
    REFERENCES produto(id)
);

