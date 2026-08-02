CREATE DATABASE bloodconnect;

USE bloodconnect;

CREATE TABLE donors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    blood_group VARCHAR(5) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    email VARCHAR(100),
    city VARCHAR(50) NOT NULL,
    last_donation DATE,
    availability VARCHAR(20) DEFAULT 'Available'
);