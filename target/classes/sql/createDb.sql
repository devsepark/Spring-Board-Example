create database board;								#board 데이터베이스 생성

use board;											#board 데이터베이스 사용

CREATE TABLE `board_article` (						#게시판 테이블
	`group_id` VARCHAR(11) NOT NULL,				#게시판 그룹id
	`id` INT(11) NOT NULL AUTO_INCREMENT,			#게시글 id, auto_increment
	`title` VARCHAR(50) NULL DEFAULT NULL,			#게시글 제목
	`writer` VARCHAR(20) NULL DEFAULT NULL,			#게시글 작성자
	`content` VARCHAR(4000) NULL DEFAULT NULL,		#게시글 내용
	`date` DATETIME NULL DEFAULT NULL,				#게시글 작성일자
	`hit` INT(11) NULL DEFAULT '0',					#게시글 조회수
	`deleted` TINYINT(1) NULL DEFAULT '0',		#게시글 삭제여부
	PRIMARY KEY (`id`)								#기본키는 게시글 id
);
	
CREATE TABLE `board_comment` (						#게시판 댓글 테이블
	`article_id` INT(11) NOT NULL,						
	`id` INT(11) NOT NULL,					
	`writer` VARCHAR(20) NOT NULL,					
	`content` VARCHAR(500) NULL DEFAULT NULL,		
	`date` DATETIME NULL DEFAULT NULL,				
	`deleted` TINYINT(1) NULL DEFAULT '0',		
	PRIMARY KEY (`id`)						
);
	
CREATE TABLE `board_file` (
	`id` INT(20) NOT NULL AUTO_INCREMENT,			#파일 id
	`name` VARCHAR(150) NULL DEFAULT NULL,			#파일명 (첨부 시, 이름)
	`storage_name` VARCHAR(150) NULL DEFAULT NULL,  #파일명 (서버에 저장되는 이름)
	`path` VARCHAR(255) NULL DEFAULT NULL,
	`type` VARCHAR(50) NULL DEFAULT NULL,
	`size` INT(11) NULL DEFAULT NULL,
	`date` DATETIME NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)

CREATE TABLE `board_group` (						#게시판 그룹 테이블
	`id` INT(11) NOT NULL AUTO_INCREMENT,			#게시판 그룹 id (1~)
	`simple_name` VARCHAR(20) NOT NULL,				#게시판 그룹 명 (ex:tip)
	`detailed_name` VARCHAR(20) NULL DEFAULT NULL,	#게시판 그룹 명 (팁n강의 게시판)
	`child` varchar(50) NULL DEFAULT NULL,			#자식 게시판 id
	`deleted` TINYINT(1) NULL DEFAULT NULL,			#삭제여부 0:삭제안함 1:삭제됨
	`available` TINYINT(1) NULL DEFAULT NULL,		#가능여부 0:불가능 1:가능
	`commentable` TINYINT(1) NULL DEFAULT NULL,		#댓글가능여부 0:불가능 1:가능
	`writable` TINYINT(1) NULL DEFAULT NULL,		#쓰기가능여부 0:글쓰기불가 1:글쓰기가능
	`date` DATETIME NULL DEFAULT NULL,				#게시판 생성일자
	PRIMARY KEY (`id`)
);

CREATE TABLE `user` (
	`id` VARCHAR(20) NOT NULL,
	`password` VARCHAR(255) NULL DEFAULT NULL,
	`name` VARCHAR(20) NOT NULL,
	`email` VARCHAR(30) NULL DEFAULT NULL,
	`date` DATETIME NULL DEFAULT NULL,
	`authority` VARCHAR(30) NULL DEFAULT 'role_user',
	`enabled` TINYINT(1) NULL DEFAULT '1',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `name` (`name`)
)

#게시판 그룹 생성

INSERT INTO 
`board`.`board_group` (`id`, `simple_name`, `detailed_name`, `parent`, `deleted`, `available`, `commentable`, `writable`, `date`) 
VALUES 
('1', 'qna', 'QnA', '0', '0', '1', '1', '1', now());

INSERT INTO 
`board`.`board_group` (`id`, `simple_name`, `detailed_name`, `parent`, `deleted`, `available`, `commentable`, `writable`, `date`) 
VALUES 
('2', 'tip', '팁n강의 게시판', '0', '0', '1', '1', '1', now());

INSERT INTO 
`board`.`board_group` (`id`, `simple_name`, `detailed_name`, `parent`, `deleted`, `available`, `commentable`, `writable`, `date`) 
VALUES 
('3', 'community', '커뮤니티', '0', '0', '1', '1', '1', now());

INSERT INTO 
`board`.`board_group` (`id`, `simple_name`, `detailed_name`, `parent`, `deleted`, `available`, `commentable`, `writable`, `date`) 
VALUES 
('4', 'notice', '공지사항', '3', '0', '1', '1', '1', now());

INSERT INTO 
`board`.`board_group` (`id`, `simple_name`, `detailed_name`, `parent`, `deleted`, `available`, `commentable`, `writable`, `date`) 
VALUES 
('5', 'forum', '포럼', '3', '0', '1', '1', '1', now());

INSERT INTO 
`board`.`board_group` (`id`, `simple_name`, `detailed_name`, `parent`, `deleted`, `available`, `commentable`, `writable`, `date`) 
VALUES 
('6', 'free', '자유게시판', '3', '0', '1', '1', '1', now());

#테스트 프로시져
delimiter //
create procedure insert_articles(num int)
begin
	declare i int;
	set i = 1;
	while i <= num do
		insert into board_article(group_id, title, writer, content, date, hit, deleted)
		values (1, concat('제목',i), concat('작성자',i), concat('내용',i), now(), 0, 0);
		set i = i + 1;
	end while;
end//
delimiter ;

call insert_articles(10);
