CREATE DATABASE IF NOT EXISTS sample;
USE sample;



CREATE TABLE customer(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    ADDRESS VARCHAR(100) NOT NULL
);