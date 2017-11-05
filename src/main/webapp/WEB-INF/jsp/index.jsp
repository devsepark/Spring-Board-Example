<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IT QnA</title>
</head>
<body>
	<a href="/board/tip">팁n강의 게시판</a>
	
	<c:choose>
    <c:when test="${sessionScope.user.getId() == null}">
        <a href="/user/login/form">로그인</a>
        <a href="/user/regist/form">회원가입</a>
    </c:when>
    <c:otherwise>
    	<br>
        ${sessionScope.user.getName()}님이 로그인중입니다.
        <form action="/user/logout" method="post">
        	<input type="submit" value="로그아웃">
        </form>
    </c:otherwise>
	</c:choose>
</body>
</html>