<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Tip&강좌 게시판</title>
</head>
<body>
	<a href="/board/tip/form">글쓰기</a>

	<table border="1" style="width: 600px">
		<caption>게시판</caption>
		<colgroup>
			<col width='8%' />
			<col width='*%' />
			<col width='15%' />
			<col width='15%' />
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>등록자</th>
				<th>등록일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="list" items="${list}" varStatus="status">
				<c:url var="link" value="/board/tip/article/${list.id}" />
				<tr>
					<td><c:out value="${list.id}" /></td>
					<td><a href="${link}"><c:out value="${list.title}" /></a></td>
					<td><c:out value="${list.writer}" /></td>
					<td><c:out value="${list.date}" /></td>
					<td><c:out value="${list.hit}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${pageVo.totalPage>1}">
		<div class="paging">
			<c:forEach var="i" begin="${pageVo.pageStart}"
				end="${pageVo.pageEnd}" step="1">
				<c:url var="pageLink" value="/board/tip/">
					<c:param name="page" value="${i}" />
				</c:url>
				<a href="${pageLink}"><c:out value="${i}" /></a>
			</c:forEach>
		</div>
	</c:if>
	<form id="form1" name="form1" method="get" action="/board/tip/">
<div>
    <input type="checkbox" name="searchType" value="title" <c:if test="${fn:indexOf(searchVo.searchType, 'title')!=-1}">checked="checked"</c:if>/>
    <label class="chkselect" for="searchType1">제목</label>
    <input type="checkbox" name="searchType" value="content" <c:if test="${fn:indexOf(searchVo.searchType, 'content')!=-1}">checked="checked"</c:if>/>
    <label class="chkselect" for="searchType2">내용</label>
    <input type="text" name="searchKeyword" style="width:150px;" maxlength="50" value='<c:out value="${searchVo.searchKeyword}"/>' onkeydown="if(event.keyCode == 13) { fn_formSubmit();}">
    <input name="btn_search" value="검색" class="btn_sch" type="button" onclick="fn_formSubmit()" />
</div>
</form>
</body>
</html>