
DROP DATABASE  IF EXISTS EMPLOYEEDB;
CREATE DATABASE EMPLOYEEDB;

DROP TABLE IF EXISTS employees;
CREATE TABLE EMPLOYEES(
	id_emp serial PRIMARY KEY,
	First_name char(30),
	Last_name char(30),
	Salary int,
	dept_id_fk int NOT null
);
DROP TABLE IF EXISTS Department;
CREATE TABLE DEPARTMENT(
	dept_id serial PRIMARY KEY,
	dept_name char(60)
);

ALTER TABLE Employees ADD CONSTRAINT dept_id_fk FOREIGN KEY 
(dept_id_fk) REFERENCES department (dept_id);

-- fill out department table

INSERT INTO department (dept_name)values('HR');
INSERT INTO department (dept_name)values('IT');
INSERT INTO department (dept_name)values('SOFTWARE');
INSERT INTO department (dept_name)values('CLEANING');

-- Fill out employees table

INSERT INTO employees (First_name, Last_name, salary, dept_id_fk)
values('ROY','AMED',35000,1);
INSERT INTO employees (First_name, Last_name, salary, dept_id_fk)
values('KYLE','DICKS',45000,2);
INSERT INTO employees (First_name, Last_name, salary, dept_id_fk)
values('KAT','JIL',80000,1);
INSERT INTO employees (First_name, Last_name, salary, dept_id_fk)
values('OWEN','CHRIS',45000,2);
INSERT INTO employees (First_name, Last_name, salary, dept_id_fk)
values('GRAY','FRED',25000,3);
INSERT INTO employees (First_name, Last_name, salary, dept_id_fk)
values('LIL','LEO',55000,3);
INSERT INTO employees (First_name, Last_name, salary, dept_id_fk)
values('KYLE','JOHN',30000,3);
INSERT INTO employees (First_name, Last_name, salary, dept_id_fk)
values('FREDDY','MUK',70000,3);
INSERT INTO employees (First_name, Last_name, salary, dept_id_fk)
values('BERTHE','ROME',50000,2);






--SQL query to fetch worker names with salaries >= 50000 and <= 100000

SELECT First_name, Last_name FROM employees
WHERE salary >= 50000 and salary<= 100000;

--SQL query to fetch the no. of workers for each department in the descending order.

SELECT count(*), dept_id_fk FROM employees GROUP BY (dept_id_fk);

--SQL query to fetch intersecting records of two tables.

SELECT*FROM Employees E INNER JOIN department d ON e.dept_id_fk=d.dept_id;

--SQL query to determine the 5th highest salary without using TOP or limit method

SELECT * FROM employees e ORDER BY salary DESC OFFSET 0 ROWS FETCH FIRST 5 ROWS ONLY;