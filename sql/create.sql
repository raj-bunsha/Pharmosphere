create database project;
use project;
CREATE TABLE Medicine
(
    id int PRIMARY KEY,
    medicine_name varchar(30),
    details varchar(100),
);

CREATE TABLE Substitute(
    Medicine_id int,
    Substitute_id int,
);
CREATE TABLE 
    FOREIGN KEY(Medicine_id) REFERENCES Substitute(id)

CREATE TABLE Customer
(
    id int PRIMARY KEY,
    customer_name varchar(20),
    phone_number varchar(12)
);
CREATE TABLE Inventory(
    id int PRIMARY KEY,
    pharma_id int,
    medicine_id int,
    quantity int,
    price int,
    expiry_date DATE,
    manufacturer_id int,
    FOREIGN KEY(medicine_id) REFERENCES Medicine(id),
);
CREATE TABLE Orders(
    id int PRIMARY KEY,
    customer_id int,
    medicine_id int,
    order_date DATE,
    total_price int,
    FOREIGN KEY(customer_id) REFERENCES Customer(id),
    FOREIGN KEY(medicine_id) REFERENCES Inventory(id)
);

CREATE TABLE SellRecords(
    id int PRIMARY KEY,
    order_id int,
    FOREIGN KEY(order_id) REFERENCES Orders(id)
);