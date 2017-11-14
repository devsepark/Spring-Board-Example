# Spring-Board-Example
Spring board example. (practice project)

- Maria DB 10.2.9
- Bootstrap 3.3.7
- jquery-3.2.1
- tomcat 8.0


1. create database (src/main/resources/sql/createDb.sql)
2. database setting (src/main/webapp/WEB-INF/config/context-datasource.xml)
3. tomcat setting (path : /, port: 80)
4. http://localhost

- 추후 기타 디바이스에서 접근시 /json을 앞에 붙여 json 반환할 수 있도록 할 예정.

## Interface Architecture
------
|Method		|Resource										|Remark				|
|:----------|:----------------------------------------------|:------------------|
|GET 		| /, /index										|main index page	|
|GET		|/board/{boardid}/								|board {id} list	|
|GET		|/board/{boardid}/form							|board write form	|
|POST		|/board/{boardid}/								|write article		|
|GET		|/board/{boardid}/article/{articleid}/form		|article update form|
|PUT		|/board/{boardid}/article/{articleid}			|update article 	|
|GET		|/board/{boardid}/article/{articleid}			|read article page	|
|DELETE		|/board/{boardid}/article/{articleid}			|delete	article 	|
|GET		|/user/regist/form								|user regist form	|
|POST		|/user/regist									|regist user		|
|GET		|/user/login									|user login form	|
|POST		|/user/login									|login user			|
|POST		|/user/logout									|logout user		|

## Create Test data
------
-create procedure.
delimiter //
create procedure insert_articles(num int)
begin
	declare i int;
	set i = 0;
	while i <= num do
		insert into board_article(groupid, title, writer, content, date, hit, isdeleted)
		values ('tip', concat('제목',i), concat('작성자',i), concat('내용',i), now(), 0, 0);
		set i = i + 1;
	end while;
end//
delimiter ;

- use
call insert_articles(10);

## A List Of Functions
------
|Function	        |Completed |Remark				              |
|:------------------|:--------:|:---------------------------------|
|메인 페이지	        |          |메뉴 및 메인 페이지	                  |
|게시글 리스트	        |O         |게시글 리스트 출력		                  |
|게시글 페이징	        |O         |게시글 페이징 처리		                  |
|게시판 그룹	        |O         |각 게시판 그룹화		                  |
|게시글 등록	        |O         |게시글 등록			                  |
|게시글 읽기	        |O         |게시글 읽기			                  |
|게시글 수정	        |O         |게시글 수정			                  |
|게시글 삭제	        |O         |게시글 삭제			                  |
|게시글 조회수   	        |O         |게시글 조회수 증가 및 출력	              |
|게시판 검색	        |          |게시글 작성자, 제목, 내용, 댓글 검색	      |
|파일 등록		        |          |				                  |
|파일 수정		        |	       |				                  |
|게시글 댓글 등록	        |          |				                  |
|게시글 댓글 출력	        |          |				                  |
|게시글 댓글 수정	        |	       |				                  |
|게시글 댓글 삭제	        |          |				                  |
|로그인		        |          |				                  |
|로그 아웃		        |          |				                  |
|회원 가입		        |          |				                  |
|입력 여부 확인		    |          |게시글, 댓글 입력 여부 안내 메시지	          |
|게시글 스크립트 방지    	    |O         |게시글 스크립트 삽입 방지   	              |
