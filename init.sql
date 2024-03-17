CREATE DATABASE project1;
USE project1;

CREATE TABLE users (
                       id BIGINT NOT NULL AUTO_INCREMENT,
                       username VARCHAR(255),
                       email VARCHAR(255),
                       password VARCHAR(255),
                       fullname VARCHAR(255),
                       address VARCHAR(255),
                       telephone VARCHAR(255),
                       gender BOOLEAN,
                       enabled BOOLEAN,
                       PRIMARY KEY (id)
);

CREATE TABLE role (
                      id BIGINT NOT NULL AUTO_INCREMENT,
                      name VARCHAR(255),
                      PRIMARY KEY (id)
);

CREATE TABLE users_roles (
                             id BIGINT NOT NULL AUTO_INCREMENT,
                             user_id BIGINT,
                             role_id BIGINT,
                             PRIMARY KEY (id),
                             FOREIGN KEY (user_id) REFERENCES users (id),
                             FOREIGN KEY (role_id) REFERENCES role (id)
);

CREATE TABLE categories (
                            id INT NOT NULL AUTO_INCREMENT,
                            category_name VARCHAR(255),
                            category_status BOOLEAN,
                            PRIMARY KEY (id)
);

CREATE TABLE products (
                          id INT NOT NULL AUTO_INCREMENT,
                          product_name VARCHAR(255),
                          description VARCHAR(255),
                          image VARCHAR(255),
                          price DOUBLE,
                          category_id INT,
                          PRIMARY KEY (id),
                          FOREIGN KEY (category_id) REFERENCES categories (id)
);

-- Tạo user role ADMIN (tài khoản: usertest1, mật khẩu: 123456)
INSERT INTO users (username, email, password, fullname, address, telephone, gender, enabled)
VALUES('usertest1', 'usertest1@gmail.com', '$2a$10$C98hqwVkInANxHROraUqJOHl.vjqkYqT39aDhOfvqV5pjAUqpLhHS','Robert', 'Hanoi','0123456789',1,1);

INSERT INTO role (name) VALUES ('ADMIN');

INSERT INTO users_roles (user_id, role_id) VALUES (1,1);

INSERT INTO categories (category_name, category_status)
VALUES
    ('Shirt',1),
    ('Trousers',1),
    ('Hat',1);

