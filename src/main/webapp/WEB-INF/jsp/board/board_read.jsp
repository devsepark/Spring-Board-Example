<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><c:out value="${boardGroup.name}-${boardArticle.title}"/></title>
</head>
<body>
	<!-- 글 내용 테이블 -->
	<table border="1" style="width: 600px">
		<caption>게시판</caption>
		<colgroup>
			<col width='15%' />
			<col width='*%' />
		</colgroup>
		<tbody>
			<tr>
				<td>작성자</td>
				<td><c:out value="${boardArticle.writer}" /></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><c:out value="${boardArticle.title}" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><c:out value="${boardArticle.content}" escapeXml="false" /></td>
			</tr>
		</tbody>
	</table>
	<!-- 뒤로가기 -->
	<a href="<c:out value="/board/${boardArticle.groupid}"/>">돌아가기</a>
	<!-- 수정 -->
	<a href="<c:out value="/board/${boardArticle.groupid}/article/${boardArticle.articleid}/form"/>">수정</a>
	<!-- 삭제 폼 -->
	<form name="delete_form" action="<c:out value="/board/${boardArticle.groupid}/article/${boardArticle.articleid}"/>" method="post">
		<input type="hidden" name="_method" value="delete"> 
		<a href="#" onclick="delete_form.submit()">삭제</a>
	</form>
	<p>&nbsp;</p>
</body>
</html>
