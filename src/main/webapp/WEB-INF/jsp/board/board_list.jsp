<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><c:out value="${boardGroup.name}"/></title>
<script>
function fn_search_formSubmit(){
	//검색
	document.search_form.submit();
}
</script>
</head>
<body>
	<h1><c:out value="${boardGroup.name}"/></h1>
	<!-- 게시판 그룹 글쓰기 권한 확인 -->
	<c:if test="${boardGroup.readonly==0}">
		<a href="<c:out value="/board/${boardGroup.id}/form"/>">글쓰기</a>
	</c:if>
	<!-- 게시글 테이블 -->
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
			<c:forEach var="articleList" items="${articleList}" varStatus="status">
				<c:url var="link" value="/board/${boardGroup.id}/article/${articleList.articleid}"/>
				<tr>
					<td><c:out value="${articleList.articleid}" /></td>
					<td>
					<a href="${link}"><c:out value="${articleList.title}" /></a>
					</td>
					<td><c:out value="${articleList.writer}" /></td>
					<td><c:out value="${articleList.date}" /></td>
					<td><c:out value="${articleList.hit}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 검색 폼 -->
	<form id="search_form" name="search_form" method="get" action="/board/<c:out value="${boardGroup.id}"/>">
		<jsp:include page="/WEB-INF/jsp/common/paging.jsp" />
		<div>
			<!-- 제목 체크박스 -->
		    <input type="checkbox" name="searchType" value="title" <c:if test="${fn:indexOf(searchVo.searchType, 'title')!=-1}">checked="checked"</c:if>/>
		    <label for="searchType1">제목</label>
		    <!-- 내용 체크박스 -->
		    <input type="checkbox" name="searchType" value="content" <c:if test="${fn:indexOf(searchVo.searchType, 'content')!=-1}">checked="checked"</c:if>/>
		    <label for="searchType2">내용</label>
		    <!-- 검색 내용 (13키:엔터를 누를 시에 등록 함수 실행) -->
		    <input type="text" name="searchKeyword" style="width:150px;" maxlength="50" value='<c:out value="${searchVo.searchKeyword}"/>' 
		    onkeydown="if(event.keyCode == 13) { fn_search_formSubmit();}">
		    <input name="btn_search" value="검색" type="button" onclick="fn_search_formSubmit()" />
		</div>
	</form>
</body>
</html>