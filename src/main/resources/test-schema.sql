drop table if exists customer CASCADE;
create table customer 
(
	id integer not null auto_increment, 
	account integer, 
	address varchar(255), 
	dob varchar(15), 
	email varchar(255), 
	first_name varchar(255), 
	last_name varchar(255), 
	nationality varchar(255), 
	password varchar(255), 
	starting_balance integer, 
	username varchar(255), 
	primary key (id)
);