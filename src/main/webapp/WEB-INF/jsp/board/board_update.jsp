<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><c:out value="${boardGroup.detailedname}"/></title>
</head>
<body>
	<form name="update_form" action="<c:out value="/board/${boardGroup.simplename}/article/${boardArticle.articleid}"/>" method="post">
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
</body>
</html>
