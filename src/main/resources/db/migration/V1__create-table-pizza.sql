-- V1__Create_Pizza_Table.sql
CREATE TABLE IF NOT EXISTS Pizza (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    avaliable BOOLEAN NOT NULL,
    flavor VARCHAR(50) NOT NULL,
    size VARCHAR(50) NOT NULL
);

