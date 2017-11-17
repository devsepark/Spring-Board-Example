<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><c:out value="${boardGroup.name}"/></title>
</head>
<body>
	<!-- 글쓰기 폼 -->
	<form name="write_form" action="/board/tip" method="post">
		<table border="1" style="width:600px">
			<caption>게시판</caption>
			<colgroup>
				<col width='15%' />
				<col width='*%' />
			</colgroup>
			<tbody>
				<tr>
					<td>작성자</td> 
					<td><input type="text" name="writer" size="20" maxlength="20"></td> 
				</tr>
				<tr>
					<td>제목</td> 
					<td><input type="text" name="title" size="70" maxlength="250"></td> 
				</tr>
				<tr>
					<td>내용</td> 
					<td><textarea name="content" rows="5" cols="60"></textarea></td> 
				</tr>
			</tbody>
		</table>    
		<a href="#" onclick="writeFormSubmit()">저장</a>
	</form>	
	
<script>
	function writeFormSubmit(){
		var writeForm = document.write_form;
		
		if(writeForm.writer.value=="") {
			alert("작성자를 입력해주세요.");
			writeForm.writer.focus();
			return;
		}
		if(writeForm.title.value=="") {
			alert("글 제목을 입력해주세요.");
			writeForm.title.focus();
			return;
		}
		if(writeForm.content.value=="") {
			alert("글 내용을 입력해주세요.");
			writeForm.content.focus();
			return;
		}
		document.write_form.submit();
	}
</script>
</body>
</html>
