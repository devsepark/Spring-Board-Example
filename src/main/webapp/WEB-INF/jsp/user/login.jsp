<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="/css/bootstrap.css">
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/bootstrap.js"></script>

<title>IT QnA - 로그인</title>

<script>
    $(document).ready(function(){
        $("#btnLogin").click(function(){
            var id = $("#id").val();
            var password = $("#password").val();
            if(id == ""){
                alert("아이디를 입력하세요.");
                $("#id").focus(); // 입력포커스 이동
                return; // 함수 종료
            }
            if(password == ""){
                alert("아이디를 입력하세요.");
                $("#id").focus();
                return;
            }
            // 폼 내부의 데이터를 전송할 주소
            document.form1.action="/user/login"
            // 제출
            document.form1.submit();
        });
    });
</script>
</head>
<body>
	<h2>로그인1</h2>
    <form name="form1" method="post">
        <table border="1" width="400px">
            <tr>
                <td>아이디</td>
                <td><input name="id" id="id"></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name="password" id="password"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="button" id="btnLogin">로그인</button>
                <c:if test="${msg == 'failure'}">
                    <div style="color: red">
                        	아이디 또는 비밀번호가 일치하지 않습니다.
                    </div>
                </c:if>
                <c:if test="${msg == 'logout'}">
                    <div style="color: red">
                        	로그아웃되었습니다.
                    </div>
                </c:if>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>