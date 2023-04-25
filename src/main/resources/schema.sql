CREATE SCHEMA if not exists MyTest;
USE MyTest;
CREATE TABLE if not exists customers (
    id            	smallint NOT NULL PRIMARY KEY, 			-- id
	name         	varchar(80)	NOT NULL, 				        -- name
	surname         varchar(80)	NOT NULL, 				        -- surname
	age		        int,				 			            -- age
	phone_number	varchar(16)); 						        -- phone number

CREATE TABLE if not exists orders (
    id            	smallint NOT NULL PRIMARY KEY, 			-- id
	date         	date	NOT NULL,	 				        -- name
	customer_id	    smallint,						            -- customer_id
	product_name	varchar(80), 						        -- product_name
	amount		    int,							            -- amount
	FOREIGN KEY (customer_id) REFERENCES customers (id));

INSERT INTO customers VALUES ('1', 'Иван', 'Иванов', '25', '+7-911-111-11-11');
INSERT INTO customers VALUES ('2', 'Сидр', 'Сидоров', '54', '+7-921-222-22-22');
INSERT INTO customers VALUES ('3', 'Петр', 'Петров', '33', '+7-910-333-33-33');
INSERT INTO customers VALUES ('4', 'Николай', 'Кабанов', '27', '+7-916-444-44-44');
INSERT INTO customers VALUES ('5', 'Алена', 'Фантомова', '25', '+7-923-555-55-55');

INSERT INTO orders VALUES ('1', '2023-01-01', '1', 'Памперсы', '5');
INSERT INTO orders VALUES ('2', '2022-12-01', '1', 'Доска 40', '100');
INSERT INTO orders VALUES ('3', '2020-11-15', '2', 'Гвоздь 100', '1000');
INSERT INTO orders VALUES ('4', '2019-03-21', '3', 'Лопата', '99');