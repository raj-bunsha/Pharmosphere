create database pharmosphere;
use pharmosphere;

CREATE TABLE Pharmacy(
    id int PRIMARY KEY,
    pharmacy_name varchar(20),
    password varchar(30),
    location varchar(100)
);
CREATE TABLE Medicine
(
    id int PRIMARY KEY,
    medicine_name varchar(30),
    details varchar(100),
);
CREATE TABLE Substitute(
    medicine_id int,
    substitute_id int,
);
CREATE TABLE Customer
(
    id int PRIMARY KEY,
    customer_name varchar(20),
    phone_number varchar(12)
);
CREATE TABLE Inventory(
    id int PRIMARY KEY,
    pharmacy_id int,
    medicine_id int,
    quantity int,
    price int,
    expiry_date DATE,
    FOREIGN KEY(medicine_id) REFERENCES Medicine(id),
    FOREIGN KEY(pharmacy_id) REFERENCES Pharmacy(id)
);
CREATE TABLE Orders(
    id int PRIMARY KEY,
    customer_id int,
    pharmacy_id int,
    order_date DATE,
    FOREIGN KEY(customer_id) REFERENCES Customer(id)
);
CREATE TABLE SellRecords(
    id int PRIMARY KEY,
    order_id int,
    medicine_id int,
    price int,
    quantity int,
    FOREIGN KEY(order_id) REFERENCES Orders(id),
);