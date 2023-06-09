create database pharmosphere;
use pharmosphere;

CREATE TABLE Pharmacy(
    id int PRIMARY KEY AUTO_INCREMENT,
    pharmacy_name varchar(20) UNIQUE NOT NULL,
    password varchar(30),
    location varchar(100),
    CONSTRAINT non_empty_value CHECK (pharmacy_name <> ''),
    CONSTRAINT non_empty_value1 CHECK (password <> '')
);
CREATE TABLE Medicine
(
    id int PRIMARY KEY AUTO_INCREMENT,
    medicine_name varchar(30) UNIQUE NOT NULL,
    details varchar(100),
    CONSTRAINT non_empty_value2 CHECK (medicine_name <> '')
);
CREATE TABLE Substitute(
    medicine_id int,
    substitute_id int,
    FOREIGN KEY(medicine_id) REFERENCES Medicine(id),
    FOREIGN KEY(substitute_id) REFERENCES Medicine(id)
);
CREATE TABLE Customer
(
    id int PRIMARY KEY AUTO_INCREMENT,
    customer_name varchar(20) UNIQUE NOT NULL,
    phone_number varchar(12),
    CONSTRAINT non_empty_value3 CHECK (customer_name <> '')
);
CREATE TABLE Inventory(
    id int PRIMARY KEY AUTO_INCREMENT,
    pharmacy_id int,
    medicine_id int,
    quantity int,
    price int,
    expiry_date DATE,
    FOREIGN KEY(medicine_id) REFERENCES Medicine(id),
    FOREIGN KEY(pharmacy_id) REFERENCES Pharmacy(id)
);
CREATE TABLE Orders(
    id int PRIMARY KEY AUTO_INCREMENT,
    customer_id int,
    pharmacy_id int,
    order_date DATE,
    FOREIGN KEY(customer_id) REFERENCES Customer(id)
);
CREATE TABLE SellRecords(
    id int PRIMARY KEY AUTO_INCREMENT,
    order_id int,
    medicine_id int,
    price int,
    quantity int,
    FOREIGN KEY(order_id) REFERENCES Orders(id),
    FOREIGN KEY(medicine_id) REFERENCES Medicine(id)
);