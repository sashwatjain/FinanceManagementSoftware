CREATE DATABASE finance_management;

USE finance_management;

 CREATE TABLE users (
    ->     id INT AUTO_INCREMENT PRIMARY KEY,
    ->     name VARCHAR(255) NOT NULL,
    ->     phone VARCHAR(20) NOT NULL,
    ->     email VARCHAR(255) NOT NULL,
    ->     username VARCHAR(50) NOT NULL,
    ->     password VARCHAR(255) NOT NULL,
    ->     address VARCHAR(500) NOT NULL,
    ->     card_type VARCHAR(20) NOT NULL,
    ->     bank VARCHAR(100) NOT NULL,
    ->     account_number VARCHAR(50) NOT NULL,
    ->     ifsc_code VARCHAR(20) NOT NULL,
    ->     activated BOOLEAN DEFAULT FALSE
    -> );

CREATE TABLE products (
    ->     id INT AUTO_INCREMENT PRIMARY KEY,
    ->     name VARCHAR(255) NOT NULL,
    ->     description TEXT,
    ->     cost DECIMAL(10, 2) NOT NULL
    -> );

 CREATE TABLE admin (
    ->     id INT AUTO_INCREMENT PRIMARY KEY,
    ->     username VARCHAR(50) NOT NULL,
    ->     password VARCHAR(255) NOT NULL
    -> );

INSERT INTO admin (username, password)
    -> VALUES ('admin', 'adminpass');

 alter table users ;
 ALTER TABLE users ADD Balance DOUBLE;


 UPDATE users
    -> SET Balance = CASE
    ->     WHEN card_type = 'Gold' THEN FLOOR(RAND() * (50000 - 40000 + 1)) + 40000
    ->     WHEN card_type = 'Titanium' THEN FLOOR(RAND() * (100000 - 80000 + 1)) + 80000
    ->     ELSE 0 -- Default value for other CardTypes
    -> END;


