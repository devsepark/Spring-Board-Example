create database board;

use board;

CREATE TABLE `board` (
	`groupid` VARCHAR(20) NOT NULL,
	`articleid` INT(11) NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(50) NULL DEFAULT NULL,
	`writer` VARCHAR(20) NULL DEFAULT NULL,
	`content` VARCHAR(4000) NULL DEFAULT NULL,
	`date` DATETIME NULL DEFAULT NULL,
	`hit` INT(11) NULL DEFAULT '0',
	`isdeleted` TINYINT(1) NULL DEFAULT '0',
	PRIMARY KEY (`id`)
)
	
CREATE TABLE `board_comment` (
	`boardid` INT(11) NOT NULL,
	`commentid` INT(11) NOT NULL,
	`writer` VARCHAR(20) NOT NULL,
	`content` VARCHAR(500) NULL DEFAULT NULL,
	`date` DATETIME NULL DEFAULT NULL,
	`isdeleted` TINYINT(1) NULL DEFAULT '0',
	PRIMARY KEY (`commentid`)
)
	
CREATE TABLE `board_file` (
	`fileid` INT(20) NOT NULL AUTO_INCREMENT,
	`boardid` INT(20) NULL DEFAULT NULL,
	`filename` VARCHAR(150) NULL DEFAULT NULL,
	`realname` VARCHAR(50) NULL DEFAULT NULL,
	`filesize` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`fileid`)
)

CREATE TABLE `board_group` (
	`id` VARCHAR(20) NOT NULL,
	`name` VARCHAR(20) NULL DEFAULT NULL,
	`parent` VARCHAR(20) NULL DEFAULT NULL,
	`isdeleted` TINYINT(1) NULL DEFAULT NULL,
	`isavailable` TINYINT(1) NULL DEFAULT NULL,
	`iscommentable` TINYINT(1) NULL DEFAULT NULL,
	`readonly` TINYINT(1) NULL DEFAULT NULL,
	`date` DATETIME NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)

CREATE TABLE `user` (
	`id` VARCHAR(20) NOT NULL,
	`password` VARCHAR(20) NULL DEFAULT NULL,
	`name` VARCHAR(20) NULL DEFAULT NULL,
	`email` VARCHAR(30) NULL DEFAULT NULL,
	`date` DATETIME NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)