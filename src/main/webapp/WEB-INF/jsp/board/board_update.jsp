<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><c:out value="${boardGroup.detailedName}-${boardArticle.title}"/></title>
<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="/css/header.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/common/header.jsp" />
	<form name="update_form" action="<c:out value="/board/${boardGroup.simpleName}/article/${boardArticle.id}"/>" method="post">
		<table border="1" style="width:600px">
			<caption>게시판</caption>
			<colgroup>
				<col width='15%' />
				<col width='*%' />
			</colgroup>
			<tbody>
				<tr>
					<td>작성자</td> 
					<td><input type="text" name="writer" size="20" maxlength="20" value="<c:out value="${boardArticle.writer}"/>"></td> 
				</tr>
				<tr>
					<td>제목</td> 
					<td><input type="text" name="title" size="70" maxlength="250" value="<c:out value="${boardArticle.title}"/>"></td> 
				</tr>
				<tr>
					<td>내용</td> 
					<td><textarea name="content" rows="5" cols="60"><c:out value="${boardArticle.content}"/></textarea></td> 
				</tr>
			</tbody>
		</table>
		<input type="hidden" name = "_method" value="put">
		<a href="#" onclick="update_form.submit()">저장</a>
	</form>	
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/bootstrap.js"></script>

</body>
</html>
