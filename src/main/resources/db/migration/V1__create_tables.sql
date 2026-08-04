CREATE TABLE categories (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,
    code VARCHAR(255)
);

CREATE TABLE products (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price NUMERIC(10,2) NOT NULL CHECK(price >= 0),
    inventory_quantity NUMERIC(10,3) NOT NULL CHECK(inventory_quantity >= 0),
    barcode VARCHAR(50) UNIQUE NOT NULL,
    category_id INTEGER NOT NULL,

    CONSTRAINT fk_product_category
    FOREIGN KEY (category_id)
    REFERENCES categories(id)
);

CREATE TABLE sales (
    id UUID PRIMARY KEY,
    date TIMESTAMP NOT NULL,
    total NUMERIC(10,2) NOT NULL CHECK(total >= 0)
);

CREATE TABLE sale_items (
    id BIGSERIAL PRIMARY KEY,
    quantity NUMERIC(10,3) NOT NULL CHECK(quantity > 0),
    unit_price NUMERIC(10,2) NOT NULL,
    subtotal NUMERIC(10,2) NOT NULL,

    sale_id UUID NOT NULL,
    product_id BIGINT NOT NULL,

    CONSTRAINT fk_sale_item_sale
    FOREIGN KEY (sale_id)
    REFERENCES sales(id),

    CONSTRAINT fk_sale_item_product
    FOREIGN KEY (product_id)
    REFERENCES products(id)
);
