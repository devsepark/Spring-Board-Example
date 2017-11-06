create database board;

use board;

create table user (
	id varchar(20) not null,
	password varchar(20),
	name varchar(20),
	email varchar(30),
	date datetime,
	primary key (id)
	);
	
CREATE TABLE `board_tip` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(50) NULL DEFAULT NULL,
	`writer` VARCHAR(20) NULL DEFAULT NULL,
	`content` VARCHAR(4000) NULL DEFAULT NULL,
	`date` DATETIME NULL DEFAULT NULL,
	`hit` INT(11) NULL DEFAULT '0',
	`isdeleted` TINYINT(2) NULL DEFAULT '0',
	PRIMARY KEY (`id`)
)
	
CREATE TABLE `board_tip_reply` (
	`boardid` INT(11) NOT NULL,
	`replyid` INT(11) NOT NULL,
	`writer` VARCHAR(20) NOT NULL,
	`content` VARCHAR(500) NULL DEFAULT NULL,
	`date` DATETIME NULL DEFAULT NULL,
	`isdeleted` TINYINT(2) NULL DEFAULT '0',
	PRIMARY KEY (`replyid`)
)