
--- BEGINNING
DROP SCHEMA IF EXISTS sep3_database CASCADE ;
CREATE SCHEMA sep3_database;
SET SCHEMA 'sep3_database';

--- DOMAINS



--- TABLES
CREATE TABLE users (
    id INTEGER PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(50),
    photo VARCHAR(50),
    firstname VARCHAR(50),
    lastname VARCHAR(50),
    securityLevel VARCHAR(50),
    role VARCHAR(50)
);


INSERT INTO users VALUES (1,'Ionut','12345','default.png','Baicoianu','Ionut','4','Admin');

