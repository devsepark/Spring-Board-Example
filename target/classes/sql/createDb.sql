create database board;

use board;

create table user (
	id varchar(20) not null,
	password varchar(20),
	name varchar(20),
	email varchar(30),
	primary key (id)
	);
	
create table board_tip (
	id int NOT NULL AUTO_INCREMENT,
	title varchar(50),
	writer varchar(20),
	content varchar(4000),
	date datetime,
	primary key (id)
	);
	
	