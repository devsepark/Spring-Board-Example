<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Tip&강좌 게시판</title>
</head>
<body>
	<table border="1" style="width: 600px">
		<caption>게시판</caption>
		<colgroup>
			<col width='15%' />
			<col width='*%' />
		</colgroup>
		<tbody>
			<tr>
				<td>작성자</td>
				<td><c:out value="${boardTip.writer}" /></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><c:out value="${boardTip.title}" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><c:out value="${boardTip.content}" escapeXml="false" /></td>
			</tr>
		</tbody>
	</table>
	<a href="#" onclick="history.back(-1)">돌아가기</a>
	<a href="<c:out value="${boardTip.id}/form"/>">수정</a>
	<form name="form1" action="<c:out value="${boardTip.id}"/>"
		method="post">
		<input type="hidden" name="_method" value="delete"> <a
			href="#" onclick="form1.submit()">삭제</a>
	</form>
	<p>&nbsp;</p>
	<div style="border: 1px solid; width: 600px; padding: 5px">
		<form name="replyform" action="<c:out value="/board/tip/article/${boardTip.id}/reply"/>" method="post">
			 작성자: <input type="text" name="writer" size="20" maxlength="20"> <br />
			<textarea name="content" rows="3" cols="60" maxlength="500"
				placeholder="댓글을 달아주세요."></textarea>
			<a href="#" onclick="fn_formSubmit()">저장</a>
		</form>
	</div>
</body>
</html>
