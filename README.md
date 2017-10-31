# Spring-Board-Example
Spring board example. (practice project)

- Maria DB 10.2.9
- Bootstrap 3.3.7
- jquery-3.2.1
- tomcat 8.0


1. create database (src/main/resources/sql/createDb.sql)
2. tomcat setting (path : /, port: 80)
3. http://localhost

빌드 실패 시: 
1. maven repository 확인
2. project facets 확인 (Dynamic web module 3.0, java 1.8)

mariadb 한글 오류시 :
- my.ini
[mysqld]
datadir=D:/Program Files/MariaDB 10.2/data
port=3306
innodb_buffer_pool_size=1010M
init_connect="SET collation_connection = utf8_general_ci"
init_connect="SET NAMES utf8"
character-set-server = utf8
collation-server = utf8_general_ci
[client]
port=3306
plugin-dir=D:/Program Files/MariaDB 10.2/lib/plugin
default-character-set=utf8
[mysqldump]
default-character-set = utf8 
[mysql]
default-character-set = utf8
