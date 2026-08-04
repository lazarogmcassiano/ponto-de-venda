CREATE TABLE roles (

    id UUID PRIMARY KEY,

    name VARCHAR(50) NOT NULL UNIQUE

);


INSERT INTO roles(id,name)
VALUES
(gen_random_uuid(),'ADMIN'),
(gen_random_uuid(),'MANAGER'),
(gen_random_uuid(),'CASHIER');

CREATE TABLE permissions (

    id UUID PRIMARY KEY,

    name VARCHAR(100) NOT NULL UNIQUE

);


INSERT INTO permissions(id,name)
VALUES

(gen_random_uuid(),'USER_CREATE'),
(gen_random_uuid(),'USER_UPDATE'),

(gen_random_uuid(),'SALE_CREATE'),
(gen_random_uuid(),'SALE_CANCEL'),

(gen_random_uuid(),'PRODUCT_CREATE'),
(gen_random_uuid(),'PRODUCT_UPDATE'),

(gen_random_uuid(),'REPORT_VIEW');

CREATE TABLE users (

    id UUID PRIMARY KEY,

    name VARCHAR(150) NOT NULL,

    barcode VARCHAR(50) NOT NULL UNIQUE,

    password VARCHAR(255) NOT NULL,

    active BOOLEAN NOT NULL DEFAULT TRUE,

    role_id UUID NOT NULL,

    CONSTRAINT fk_user_role
    FOREIGN KEY(role_id)
    REFERENCES roles(id)

);

CREATE TABLE role_permissions (

    role_id UUID NOT NULL,

    permission_id UUID NOT NULL,


    PRIMARY KEY(role_id,permission_id),


    FOREIGN KEY(role_id)
    REFERENCES roles(id),


    FOREIGN KEY(permission_id)
    REFERENCES permissions(id)

);

CREATE TABLE user_permissions (

    user_id UUID NOT NULL,

    permission_id UUID NOT NULL,


    PRIMARY KEY(user_id,permission_id),


    FOREIGN KEY(user_id)
    REFERENCES users(id),


    FOREIGN KEY(permission_id)
    REFERENCES permissions(id)

);

CREATE TABLE clients (
    id UUID PRIMARY KEY,

    name VARCHAR(70) NOT NULL,

    cpf VARCHAR(20),

    phone_number VARCHAR(20),

    email VARCHAR(100)
);

