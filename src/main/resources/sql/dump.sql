-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.2.9-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- board 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `board` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `board`;

-- 테이블 board.board_article 구조 내보내기
CREATE TABLE IF NOT EXISTS `board_article` (
  `group_id` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `writer` varchar(20) DEFAULT NULL,
  `content` varchar(4000) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `hit` int(11) DEFAULT 0,
  `deleted` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8;

-- 테이블 데이터 board.board_article:~127 rows (대략적) 내보내기
DELETE FROM `board_article`;
/*!40000 ALTER TABLE `board_article` DISABLE KEYS */;
INSERT INTO `board_article` (`group_id`, `id`, `title`, `writer`, `content`, `date`, `hit`, `deleted`) VALUES
	(1, 1, '제목0', '작성자0', '내용0', '2017-11-20 03:51:41', 0, 0),
	(1, 2, '제목1', '작성자1', '내용1', '2017-11-20 03:51:41', 0, 0),
	(1, 3, '제목2', '작성자2', '내용2', '2017-11-20 03:51:41', 0, 0),
	(1, 4, '제목3', '작성자3', '내용3', '2017-11-20 03:51:41', 0, 0),
	(1, 5, '제목4', '작성자4', '내용4', '2017-11-20 03:51:41', 0, 0),
	(1, 6, '제목5', '작성자5', '내용5', '2017-11-20 03:51:41', 0, 0),
	(1, 7, '제목6', '작성자6', '내용6', '2017-11-20 03:51:41', 0, 0),
	(1, 8, '제목7', '작성자7', '내용7', '2017-11-20 03:51:41', 0, 0),
	(1, 9, '제목8', '작성자8', '내용8', '2017-11-20 03:51:41', 0, 0),
	(1, 10, '제목9', '작성자9', '내용9', '2017-11-20 03:51:41', 0, 0),
	(1, 11, '제목10', '작성자10', '내용10', '2017-11-20 03:51:41', 0, 0),
	(1, 12, '제목11', '작성자11', '내용11', '2017-11-20 03:51:41', 0, 0),
	(1, 13, '제목12', '작성자12', '내용12', '2017-11-20 03:51:41', 0, 0),
	(1, 14, '제목13', '작성자13', '내용13', '2017-11-20 03:51:41', 0, 0),
	(1, 15, '제목14', '작성자14', '내용14', '2017-11-20 03:51:41', 0, 0),
	(1, 16, '제목15', '작성자15', '내용15', '2017-11-20 03:51:41', 0, 0),
	(1, 17, '제목16', '작성자16', '내용16', '2017-11-20 03:51:41', 0, 0),
	(1, 18, '제목17', '작성자17', '내용17', '2017-11-20 03:51:41', 0, 0),
	(1, 19, '제목18', '작성자18', '내용18', '2017-11-20 03:51:41', 0, 0),
	(1, 20, '제목19', '작성자19', '내용19', '2017-11-20 03:51:41', 0, 0),
	(1, 21, '제목20', '작성자20', '내용20', '2017-11-20 03:51:41', 0, 0),
	(1, 22, '제목21', '작성자21', '내용21', '2017-11-20 03:51:41', 0, 0),
	(1, 23, '제목22', '작성자22', '내용22', '2017-11-20 03:51:42', 0, 0),
	(1, 24, '제목23', '작성자23', '내용23', '2017-11-20 03:51:42', 0, 0),
	(1, 25, '제목24', '작성자24', '내용24', '2017-11-20 03:51:42', 0, 0),
	(1, 26, '제목25', '작성자25', '내용25', '2017-11-20 03:51:42', 0, 0),
	(1, 27, '제목26', '작성자26', '내용26', '2017-11-20 03:51:42', 0, 0),
	(1, 28, '제목27', '작성자27', '내용27', '2017-11-20 03:51:42', 0, 0),
	(1, 29, '제목28', '작성자28', '내용28', '2017-11-20 03:51:42', 0, 0),
	(1, 30, '제목29', '작성자29', '내용29', '2017-11-20 03:51:42', 0, 0),
	(1, 31, '제목30', '작성자30', '내용30', '2017-11-20 03:51:42', 0, 0),
	(1, 32, '제목31', '작성자31', '내용31', '2017-11-20 03:51:42', 0, 0),
	(1, 33, '제목32', '작성자32', '내용32', '2017-11-20 03:51:42', 0, 0),
	(1, 34, '제목33', '작성자33', '내용33', '2017-11-20 03:51:42', 0, 0),
	(1, 35, '제목34', '작성자34', '내용34', '2017-11-20 03:51:42', 0, 0),
	(1, 36, '제목35', '작성자35', '내용35', '2017-11-20 03:51:42', 0, 0),
	(1, 37, '제목36', '작성자36', '내용36', '2017-11-20 03:51:42', 0, 0),
	(1, 38, '제목37', '작성자37', '내용37', '2017-11-20 03:51:42', 0, 0),
	(1, 39, '제목38', '작성자38', '내용38', '2017-11-20 03:51:42', 0, 0),
	(1, 40, '제목39', '작성자39', '내용39', '2017-11-20 03:51:42', 0, 0),
	(1, 41, '제목40', '작성자40', '내용40', '2017-11-20 03:51:42', 0, 0),
	(1, 42, '제목41', '작성자41', '내용41', '2017-11-20 03:51:42', 0, 0),
	(1, 43, '제목42', '작성자42', '내용42', '2017-11-20 03:51:42', 0, 0),
	(1, 44, '제목43', '작성자43', '내용43', '2017-11-20 03:51:42', 0, 0),
	(1, 45, '제목44', '작성자44', '내용44', '2017-11-20 03:51:42', 0, 0),
	(1, 46, '제목45', '작성자45', '내용45', '2017-11-20 03:51:42', 0, 0),
	(1, 47, '제목46', '작성자46', '내용46', '2017-11-20 03:51:42', 0, 0),
	(1, 48, '제목47', '작성자47', '내용47', '2017-11-20 03:51:42', 0, 0),
	(1, 49, '제목48', '작성자48', '내용48', '2017-11-20 03:51:42', 0, 0),
	(1, 50, '제목49', '작성자49', '내용49', '2017-11-20 03:51:43', 0, 0),
	(1, 51, '제목50', '작성자50', '내용50', '2017-11-20 03:51:43', 0, 0),
	(1, 52, '제목51', '작성자51', '내용51', '2017-11-20 03:51:43', 0, 0),
	(1, 53, '제목52', '작성자52', '내용52', '2017-11-20 03:51:43', 0, 0),
	(1, 54, '제목53', '작성자53', '내용53', '2017-11-20 03:51:43', 0, 0),
	(1, 55, '제목54', '작성자54', '내용54', '2017-11-20 03:51:43', 0, 0),
	(1, 56, '제목55', '작성자55', '내용55', '2017-11-20 03:51:43', 0, 0),
	(1, 57, '제목56', '작성자56', '내용56', '2017-11-20 03:51:43', 0, 0),
	(1, 58, '제목57', '작성자57', '내용57', '2017-11-20 03:51:43', 0, 0),
	(1, 59, '제목58', '작성자58', '내용58', '2017-11-20 03:51:43', 0, 0),
	(1, 60, '제목59', '작성자59', '내용59', '2017-11-20 03:51:43', 0, 0),
	(1, 61, '제목60', '작성자60', '내용60', '2017-11-20 03:51:43', 0, 0),
	(1, 62, '제목61', '작성자61', '내용61', '2017-11-20 03:51:43', 0, 0),
	(1, 63, '제목62', '작성자62', '내용62', '2017-11-20 03:51:43', 0, 0),
	(1, 64, '제목63', '작성자63', '내용63', '2017-11-20 03:51:43', 0, 0),
	(1, 65, '제목64', '작성자64', '내용64', '2017-11-20 03:51:43', 0, 0),
	(1, 66, '제목65', '작성자65', '내용65', '2017-11-20 03:51:43', 0, 0),
	(1, 67, '제목66', '작성자66', '내용66', '2017-11-20 03:51:43', 0, 0),
	(1, 68, '제목67', '작성자67', '내용67', '2017-11-20 03:51:43', 0, 0),
	(1, 69, '제목68', '작성자68', '내용68', '2017-11-20 03:51:43', 0, 0),
	(1, 70, '제목69', '작성자69', '내용69', '2017-11-20 03:51:43', 0, 0),
	(1, 71, '제목70', '작성자70', '내용70', '2017-11-20 03:51:43', 0, 0),
	(1, 72, '제목71', '작성자71', '내용71', '2017-11-20 03:51:43', 0, 0),
	(1, 73, '제목72', '작성자72', '내용72', '2017-11-20 03:51:43', 0, 0),
	(1, 74, '제목73', '작성자73', '내용73', '2017-11-20 03:51:43', 0, 0),
	(1, 75, '제목74', '작성자74', '내용74', '2017-11-20 03:51:43', 0, 0),
	(1, 76, '제목75', '작성자75', '내용75', '2017-11-20 03:51:44', 0, 0),
	(1, 77, '제목76', '작성자76', '내용76', '2017-11-20 03:51:44', 0, 0),
	(1, 78, '제목77', '작성자77', '내용77', '2017-11-20 03:51:44', 0, 0),
	(1, 79, '제목78', '작성자78', '내용78', '2017-11-20 03:51:44', 0, 0),
	(1, 80, '제목79', '작성자79', '내용79', '2017-11-20 03:51:44', 0, 0),
	(1, 81, '제목80', '작성자80', '내용80', '2017-11-20 03:51:44', 0, 0),
	(1, 82, '제목81', '작성자81', '내용81', '2017-11-20 03:51:44', 1, 0),
	(1, 83, '제목82', '작성자82', '내용82', '2017-11-20 03:51:44', 0, 0),
	(1, 84, '제목83', '작성자83', '내용83', '2017-11-20 03:51:44', 0, 0),
	(1, 85, '제목84', '작성자84', '내용84', '2017-11-20 03:51:44', 0, 0),
	(1, 86, '제목85', '작성자85', '내용85', '2017-11-20 03:51:44', 0, 0),
	(1, 87, '제목86', '작성자86', '내용86', '2017-11-20 03:51:44', 0, 0),
	(1, 88, '제목87', '작성자87', '내용87', '2017-11-20 03:51:44', 0, 0),
	(1, 89, '제목88', '작성자88', '내용88', '2017-11-20 03:51:44', 0, 0),
	(1, 90, '제목89', '작성자89', '내용89', '2017-11-20 03:51:44', 0, 0),
	(1, 91, '제목90', '작성자90', '내용90', '2017-11-20 03:51:44', 0, 0),
	(1, 92, '제목91', '작성자91', '내용91', '2017-11-20 03:51:44', 0, 0),
	(1, 93, '제목92', '작성자92', '내용92', '2017-11-20 03:51:44', 2, 1),
	(1, 94, '제목93', '작성자93', '내용93', '2017-11-20 03:51:44', 0, 0),
	(1, 95, '제목94', '작성자94', '내용94', '2017-11-20 03:51:44', 0, 0),
	(1, 96, '제목95', '작성자95', '내용95', '2017-11-20 03:51:44', 1, 0),
	(1, 97, '제목96', '작성자96', '내용96', '2017-11-20 03:51:44', 1, 0),
	(1, 98, '제목97', '작성자97', '내용97', '2017-11-20 03:51:44', 0, 0),
	(1, 99, '제목98', '작성자98', '내용98', '2017-11-20 03:51:44', 18, 0),
	(1, 100, '제목99', '작성자99', '내용99', '2017-11-20 03:51:44', 1, 0),
	(1, 101, '제목100', '작성자100', '내용100', '2017-11-20 03:51:44', 3, 1),
	(1, 102, '테스트1', '테스트작성자', '테스트1', '2017-11-20 05:54:27', 4, 0),
	(1, 103, 'test2', 'test1', 'test3', '2017-11-23 22:12:59', 1, 0),
	(1, 104, 'ㅅㄷㄴ', 'ㅅㄷㄴㅅ', '123', '2017-11-26 06:24:13', 1, 0),
	(1, 105, '테스트제목', 'user1', '테스트', '2017-11-28 20:45:00', 1, 0),
	(1, 106, 'test', 'name1', 'test', '2017-11-28 20:45:33', 0, 0),
	(1, 107, '1', 'name1', '1', '2017-11-29 03:52:51', 0, 0),
	(1, 108, '1', 'id1', '1', '2017-11-29 03:53:07', 0, 0),
	(1, 109, '2', 'id1', '2', '2017-11-29 03:54:34', 0, 0),
	(1, 110, '3', 'id1', '3', '2017-11-29 03:56:37', 3, 0),
	(1, 111, '4', 'name1', '4', '2017-11-29 03:58:46', 6, 0),
	(2, 112, '1', 'name1', '1', '2017-11-29 04:01:22', 0, 0),
	(1, 113, '5', 'name1', '5', '2017-11-29 04:04:44', 12, 0),
	(1, 114, '서머노트 테스트임', 'name1', '<p>테스트<span style="font-weight: bold;">임</span></p><p><span style="color: rgb(255, 0, 0); background-color: rgb(206, 198, 206);">테스트임</span></p><p><span style="color: rgb(255, 0, 0); background-color: rgb(206, 198, 206);"><br></span></p><table class="table table-bordered"><tbody><tr><td>ㅇㅇ</td><td>11</td></tr><tr><td>2</td><td>333</td></tr></tbody></table><p><span style="color: rgb(255, 0, 0); background-color: rgb(206, 198, 206);"><br></span></p>', '2017-11-30 02:05:55', 7, 0),
	(1, 115, '제목1', '작성자1', '내용1', '2017-12-02 13:41:29', 0, 0),
	(1, 116, '제목2', '작성자2', '내용2', '2017-12-02 13:41:29', 0, 0),
	(1, 117, '제목3', '작성자3', '내용3', '2017-12-02 13:41:29', 0, 0),
	(1, 118, '제목4', '작성자4', '내용4', '2017-12-02 13:41:29', 0, 0),
	(1, 119, '제목5', '작성자5', '내용5', '2017-12-02 13:41:29', 0, 0),
	(1, 120, '제목6', '작성자6', '내용6', '2017-12-02 13:41:29', 0, 0),
	(1, 121, '제목7', '작성자7', '내용7', '2017-12-02 13:41:29', 1, 1),
	(1, 122, '제목8', '작성자8', '내용8', '2017-12-02 13:41:29', 0, 0),
	(1, 123, '제목9', '작성자9', '내용9', '2017-12-02 13:41:29', 3, 0),
	(1, 124, '제목10', '작성자10', '내용10', '2017-12-02 13:41:29', 1, 0),
	(1, 125, '11', 'name1', '<p>22</p>', '2017-12-02 14:17:04', 1, 0),
	(1, 126, '12', 'name1', '<p>123</p>', '2017-12-03 00:47:07', 3, 0),
	(1, 127, '123', 'name1', '<p>12</p>', '2017-12-03 01:18:18', 1, 0),
	(2, 128, '12312사진1', 'name1', '<p>12<img src="/image/6" style="width: 1088px;">asdfsd</p><p><br></p>', '2017-12-03 04:03:07', 1, 0),
	(2, 129, '사진2', 'name1', '<p>1<img src="/image/7" style="width: 1088px;"></p><p><br></p><p>2.</p><p><img src="/image/8" style="width: 1088px;"></p><p><br></p><p>끝</p>', '2017-12-03 04:03:58', 3, 0),
	(2, 130, '태ㅔ스트', 'name1', '<p>te</p>', '2017-12-03 04:29:12', 1, 0);
/*!40000 ALTER TABLE `board_article` ENABLE KEYS */;

-- 테이블 board.board_comment 구조 내보내기
CREATE TABLE IF NOT EXISTS `board_comment` (
  `article_id` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `writer` varchar(20) NOT NULL,
  `content` varchar(500) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 board.board_comment:~13 rows (대략적) 내보내기
DELETE FROM `board_comment`;
/*!40000 ALTER TABLE `board_comment` DISABLE KEYS */;
INSERT INTO `board_comment` (`article_id`, `id`, `writer`, `content`, `date`, `deleted`) VALUES
	(147, 1, 'test1', 'test2', '2017-11-17 19:23:03', 1),
	(147, 2, 'test2', 'test3', '2017-11-17 19:23:22', 1),
	(147, 3, 'test1', 'test123', '2017-11-17 19:38:22', 1),
	(147, 4, 'test2', 'test2', '2017-11-17 19:38:26', 1),
	(147, 5, 'test1', 'test12', '2017-11-17 19:38:51', 1),
	(147, 6, '1', '12', '2017-11-17 19:38:53', 0),
	(147, 7, '22', '222', '2017-11-17 19:38:55', 0),
	(99, 8, '123', '123', '2017-11-23 02:10:51', 1),
	(99, 9, '123', '123', '2017-11-23 02:13:39', 0),
	(113, 10, 'name1', '11', '2017-11-29 04:16:08', 1),
	(113, 11, 'name1', '22', '2017-11-29 04:16:10', 0),
	(111, 12, 'name1', '1', '2017-11-29 05:25:27', 1),
	(111, 13, 'name1', '2', '2017-11-29 05:25:30', 0),
	(111, 14, 'name1', '3', '2017-11-29 05:25:31', 0),
	(123, 15, 'name1', '11', '2017-12-02 14:16:54', 0);
/*!40000 ALTER TABLE `board_comment` ENABLE KEYS */;

-- 테이블 board.board_file 구조 내보내기
CREATE TABLE IF NOT EXISTS `board_file` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) DEFAULT NULL,
  `storage_name` varchar(150) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- 테이블 데이터 board.board_file:~7 rows (대략적) 내보내기
DELETE FROM `board_file`;
/*!40000 ALTER TABLE `board_file` DISABLE KEYS */;
INSERT INTO `board_file` (`id`, `name`, `storage_name`, `path`, `type`, `size`, `date`) VALUES
	(1, 'Hearthstone Screenshot 08-12-17 12.03.21.png', '2017/11/03/c2467ee8c6314b379bad4ba66e8da2a1.png', 'd:/test\\2017/11/03/c2467ee8c6314b379bad4ba66e8da2a1.png', 'image/png', 2552798, '2017-12-03 03:26:22'),
	(2, 'Hearthstone Screenshot 08-12-17 12.03.21.png', '2017/11/03/d424ddbe14d7426a88308f91e6ca980d.png', 'd:/test\\2017/11/03/d424ddbe14d7426a88308f91e6ca980d.png', 'image/png', 2552798, '2017-12-03 03:48:23'),
	(3, 'Hearthstone Screenshot 08-12-17 12.03.21.png', '2017/11/03/001e7950370b43358e1e7994eff2b100.png', 'd:/test\\2017/11/03/001e7950370b43358e1e7994eff2b100.png', 'image/png', 2552798, '2017-12-03 03:54:13'),
	(4, 'Hearthstone Screenshot 08-12-17 12.03.21.png', '2017/11/03/4e22495eb2344ed586ca4e88945e4ecc.png', 'd:/test\\2017/11/03/4e22495eb2344ed586ca4e88945e4ecc.png', 'image/png', 2552798, '2017-12-03 03:55:54'),
	(5, 'Hearthstone Screenshot 08-12-17 12.03.21.png', '2017/11/03/b061d3b5cdac40089fca05e2398f1539.png', 'd:/test\\2017/11/03/b061d3b5cdac40089fca05e2398f1539.png', 'image/png', 2552798, '2017-12-03 04:02:02'),
	(6, 'Hearthstone Screenshot 08-12-17 12.03.21.png', '2017/11/03/b3a9063d41c343b18b95d1f298b1162d.png', 'd:/test\\2017/11/03/b3a9063d41c343b18b95d1f298b1162d.png', 'image/png', 2552798, '2017-12-03 04:02:53'),
	(7, 'Hearthstone Screenshot 08-12-17 12.03.21.png', '2017/11/03/138f9a253eb04b988152dce85ada0a88.png', 'd:/test\\2017/11/03/138f9a253eb04b988152dce85ada0a88.png', 'image/png', 2552798, '2017-12-03 04:03:29'),
	(8, '1120솔치킨.png', '2017/11/03/ca82bddef4ee4921bb8f6299a6c91812.png', 'd:/test\\2017/11/03/ca82bddef4ee4921bb8f6299a6c91812.png', 'image/png', 2370293, '2017-12-03 04:03:49'),
	(9, '1120솔치킨.png', '2017/12/03/5e090bba44094fc88f4a432883283583.png', 'd:/test\\2017/12/03/5e090bba44094fc88f4a432883283583.png', 'image/png', 2370293, '2017-12-03 04:25:03'),
	(10, '10_10솔치킨.png', '2017/12/03/b6c3608d942d4f13a71feebb51828f67.png', 'd:/test\\2017/12/03/b6c3608d942d4f13a71feebb51828f67.png', 'image/png', 3471704, '2017-12-03 04:28:48'),
	(11, '2등.jpg', '2017/12/03/97f531e9054f4638be2220311b4aee06.jpg', 'd:/test\\2017/12/03/97f531e9054f4638be2220311b4aee06.jpg', 'image/jpeg', 306371, '2017-12-03 04:29:05');
/*!40000 ALTER TABLE `board_file` ENABLE KEYS */;

-- 테이블 board.board_group 구조 내보내기
CREATE TABLE IF NOT EXISTS `board_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `simple_name` varchar(20) DEFAULT NULL,
  `detailed_name` varchar(20) DEFAULT NULL,
  `parent` int(11) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT NULL,
  `available` tinyint(1) DEFAULT NULL,
  `commentable` tinyint(1) DEFAULT NULL,
  `writable` tinyint(1) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- 테이블 데이터 board.board_group:~6 rows (대략적) 내보내기
DELETE FROM `board_group`;
/*!40000 ALTER TABLE `board_group` DISABLE KEYS */;
INSERT INTO `board_group` (`id`, `simple_name`, `detailed_name`, `parent`, `deleted`, `available`, `commentable`, `writable`, `date`) VALUES
	(1, 'qna', 'QnA', 0, 0, 1, 1, 1, '2017-11-20 17:56:15'),
	(2, 'tip', '팁n강의 게시판', 0, 0, 1, 1, 1, '2017-11-12 04:36:02'),
	(3, 'community', '커뮤니티', 0, 0, 1, 1, 1, '2017-11-20 17:56:55'),
	(4, 'notice', '공지사항', 3, 0, 1, 1, 1, '2017-11-20 17:57:21'),
	(5, 'forum', '포럼', 3, 0, 1, 1, 1, '2017-11-20 17:57:42'),
	(6, 'free', '자유게시판', 3, 0, 1, 1, 1, '2017-11-20 17:58:02');
/*!40000 ALTER TABLE `board_group` ENABLE KEYS */;

-- 프로시저 board.insert_articles 구조 내보내기
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_articles`(
	IN `num` int


)
begin
	declare i int;
	set i = 1;
	while i <= num do
		insert into board_article(group_id, title, writer, content, date, hit, deleted)
		values (1, concat('제목',i), concat('작성자',i), concat('내용',i), now(), 0, 0);
		set i = i + 1;
	end while;
end//
DELIMITER ;

-- 테이블 board.user 구조 내보내기
CREATE TABLE IF NOT EXISTS `user` (
  `id` varchar(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(20) NOT NULL,
  `email` varchar(30) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `authority` varchar(30) DEFAULT 'role_user',
  `enabled` tinyint(1) DEFAULT 1,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 board.user:~4 rows (대략적) 내보내기
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `password`, `name`, `email`, `date`, `authority`, `enabled`) VALUES
	('id1', '23e6e8c04a33a34cfab0e35f6c3dd9f04779ba3e140344f05a76ba24016ce2c5', 'id1', NULL, '2017-11-28 01:44:40', 'ROLE_USER', 1),
	('test1', '935cb0d9c7d6013604827029fc61d31d1ab587cb9706bdd0a2951b87ee8bf59c', 'test1', NULL, '2017-11-28 18:33:39', 'ROLE_USER', 1),
	('test2', '5b15dfa1dec81f0d1c94bb834f4cf9bf9fac769bc7914856561e6af389bb9bcd', 'test2', 'test2@test.com', '2017-11-28 19:12:19', 'ROLE_USER', 1),
	('user1', 'ad5050928515d4ddfa2373573ee870cdd7629a8c2b9121e3f357f455fdb8e1e0', 'name1', 'user1@user.com', '2017-11-28 20:43:55', 'ROLE_USER', 1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
