<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="/css/bootstrap.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="/js/bootstrap.js"></script>

<title>IT QnA - 회원가입</title>
</head>
<body>
	<form name="regist_form" action="/user/regist" method="post">
	    <table border="1" width="400px">
            <tr>
                <td>아이디</td>
                <td><input name="id"></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input name="name"></td>
            </tr>
            <tr>
                <td>이메일주소</td>
                <td><input name="email"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="확인">
                    <input type="reset" value="취소">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>