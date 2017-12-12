# Spring-Board-Example
Spring board example. (practice project)

- Spring 4.2.3
- log4j 2.10.0
- slf4j 1.7.25
- MyBatis 3.4.5
- Maria DB 10.2.9
- tomcat 8.0
- Bootstrap 3.3.7
- jquery-3.2.1
- summernote 0.8.8

1. create database (src/main/resources/sql/createDb.sql)
2. database setting (src/main/webapp/WEB-INF/config/context-datasource.xml)
3. tomcat setting (path : /, port: 80)
4. http://localhost


## Interface Architecture
------
|Method		|Resource													|Remark				|
|:----------|:----------------------------------------------------------|:------------------|
|GET 		| /, /index													|메인 인덱스 페이지 		|
|GET		|/board/{boardid}/											|게시판 게시글 리스트		|
|GET		|/board/{boardid}/form										|게시판 글쓰기 폼			|
|POST		|/board/{boardid}/											|게시판 글쓰기			|
|GET		|/board/{boardid}/article/{articleid}/form					|게시글 수정 폼			|
|PUT		|/board/{boardid}/article/{articleid}						|게시글 수정		 	|
|GET		|/board/{boardid}/article/{articleid}						|게시글 읽기			|
|DELETE		|/board/{boardid}/article/{articleid}						|게시글 삭제		 	|
|POST		|/board/{boardid}/article/{articleid}/comment				|댓글 저장				|
|PUT		|/board/{boardid}/article/{articleid}/comment/{commentid}	|댓글 수정				|
|DELETE		|/board/{boardid}/article/{articleid}/comment/{commentid}	|댓글 삭제				|
|GET		|/user/regist												|회원가입 페이지			|
|POST		|/user/regist												|회원가입				|
|GET		|/user/login												|로그인 페이지			|
|POST		|/user/login												|로그인				|
|POST		|/user/logout												|로그아웃				|


## A List Of Functions
------
|Function	        |Completed |Remark				              |
|:------------------|:--------:|:---------------------------------|
|메인 페이지	        |O         |메뉴 및 메인 페이지	                  |
|게시글 리스트	        |O         |게시글 리스트 출력		                  |
|게시글 페이징	        |O         |게시글 페이징 처리		                  |
|게시판 그룹	        |O         |각 게시판 그룹화		                  |
|게시글 등록	        |O         |게시글 등록			                  |
|게시글 읽기	        |O         |게시글 읽기			                  |
|게시글 수정	        |O         |게시글 수정			                  |
|게시글 삭제	        |O         |게시글 삭제			                  |
|게시글 조회수   	        |O         |게시글 조회수 증가 및 출력	              |
|게시판 검색	        |O         |게시글 작성자, 제목, 내용, 댓글 검색	      |
|이미지등록		        |O         |Summernote 이미지	                  |
|게시글 댓글 등록	        |O         |				                  |
|게시글 댓글 출력	        |O         |				                  |
|게시글 댓글 수정	        |O	       |				                  |
|게시글 댓글 삭제	        |O         |				                  |
|로그인		        |O         |				                  |
|로그 아웃		        |O         |				                  |
|회원 가입		        |O         |				                  |
|비밀번호 암호화	        |O         |SHA-256			                  |