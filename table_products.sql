BEGIN;

DROP TABLE IF EXISTS products CASCADE;

CREATE TABLE products
(
    id          bigserial PRIMARY KEY,
    title       VARCHAR(255),
    description VARCHAR(255),
    image_link  VARCHAR(255),
    price       INT
);

INSERT INTO products(title, description, image_link, price)
VALUES ('T-shirt', 'This is t-shirt', ' ', 30),
       ('Hat', 'This is hat', ' ', 10),
       ('Socks', 'This is socks', ' ', 5),
       ('Chain', 'This is chain', ' ', 150),
       ('Jeans', 'This is jeans', ' ', 40);

COMMIT;