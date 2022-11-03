CREATE TABLE Customer(
Cust_id int(11) NOT NULL AUTO_INCREMENT,
name VARCHAR(40) NOT NULL,
email VARCHAR(40) NOT NULL,
number VARCHAR(40) NOT NULL,
PRIMARY KEY (Cust_id)
);

CREATE TABLE Order(
Order_id int(11) NOT NULL AUTO_INCREMENT,
item VARCHAR(40) NOT NULL,
qunt int(11) NOT NULL
);

CREATE TABLE CustOrder(
Cust_id int(11),
Order_id int(11),
PRIMARY KEY (Cust_id, Order_id),
CONSTRAINT Cust_Order_FK
    FOREIGN KEY (Cust_id)
    REFERENCES Customer (Cust_id),
CONSTRAINT Cust_Order_FK
    FOREIGN KEY (Order_id)
    REFERENCES Order (Order_id),
);


