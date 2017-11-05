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
- 로그인 로그아웃 처리를 OAuth를 이용하도록 수정할 예정.

##Interface Architecture
------
|Method		|Resource						|Remark				|
|:----------|:-----------------------------:|:------------------|
|GET 		| /, /index						|main index page	|
|GET		|/board/tip/					|board tip list		|
|GET		|/board/tip/form				|board write form	|
|POST		|/board/tip/					|write article		|
|GET		|/board/tip/article/{id}/form	|article update form|
|PUT		|/board/tip/article/{id}		|update article 	|
|GET		|/board/tip/article/{id}		|read article page	|
|DELETE		|/board/tip/article/{id}		|delete	article 	|
|GET		|/user/regist/form				|user regist form	|
|POST		|/user/regist					|regist user		|
|GET		|/user/login					|user login form	|
|POST		|/user/login					|login user			|
|POST		|/user/logout					|logout user		|
