<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>IT Info - <c:out value="${boardGroup.detailedName}"/></title>
<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="/css/header.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/common/header.jsp" />
  <div class="container">
    <div class="row">
      <a href="<c:out value="/board/${boardGroup.simpleName}"/>" class="btn btn-lg pull-left" role="button">
	  <c:out value="${boardGroup.detailedName}"/></a>
      <!-- 게시판 그룹 글쓰기 권한 확인 -->
	  <c:if test="${boardGroup.writable==1}">
		<a href="<c:out value="/board/${boardGroup.simpleName}/form"/>" class="btn btn-success pull-right" role="button">글쓰기</a>
      </c:if>
    </div>
    <!-- 번호| 제목 (댓글)| 작성자|조회수|날짜 -->
    <div class="table-responsive">
      <table class="table table-hover">
        <thead>
		  <tr>
		    <th class="col-lg-1 text-center">번호</th>
			<th class="col-lg-7 text-center">제목</th>
			<th class="col-lg-2 text-center">작성자</th>
			<th class="col-lg-1 text-center">조회수</th>
			<th class="col-lg-1 text-center">등록일</th>
		  </tr>
		</thead>
		<tbody>
		  <c:forEach var="articleList" items="${articleList}">
		    <c:url var="link" value="/board/${boardGroup.simpleName}/article/${articleList.id}"/>
		    <tr>
			  <td class="text-center"><c:out value="${articleList.id}" /></td>
			  <td class="text-left">
			    <a href="${link}"><c:out value="${articleList.title}" />
			    	<c:if test="${articleList.commentCount != '0'}">[${articleList.commentCount}]</c:if>
			    </a>
			  </td>
			  <td class="text-center"><c:out value="${articleList.writer}" /></td>
			  <td class="text-center"><c:out value="${articleList.hit}" /></td>
			  <td class="text-center"><c:out value="${articleList.date}" /></td>
		    </tr>
		  </c:forEach>
		</tbody>
      </table>
    </div>
    <!-- 페이징 폼 -->
	<form id="paging_form" name="paging_form" method="get" action="<c:out value="/board/${boardGroup.simpleName}"/>">
		<!-- 페이징 처리 -->
		<jsp:include page="/WEB-INF/jsp/common/paging.jsp" />
	</form>
	<!-- TODO 검색 시, 내용이 없으면 검색된 내용이 없다고 표시. -->
	<!-- TODO 검색 기능 확장 (드롭박스로)(제목,내용,제목+내용,작성자,댓글) -->
	<!-- 검색 폼 -->
	<form id="search_form" class="form-inline" name="search_form" method="get">
	  <!-- 제목 체크박스 -->
	  <label class="checkbox-inline">
	    <input type="checkbox" name="searchType" value="title" <c:if test="${fn:indexOf(searchVo.searchType, 'title')!=-1}">checked="checked"</c:if>/>
	         제목
	  </label>
	  <!-- 내용 체크박스 -->
	  <label class="checkbox-inline">
	    <input type="checkbox" name="searchType" value="content" <c:if test="${fn:indexOf(searchVo.searchType, 'content')!=-1}">checked="checked"</c:if>/>
	         내용
	  </label>
	  <div class="form-group">
	  <!-- 검색 내용 (13키:엔터를 누를 시에 등록 함수 실행) -->
	    <input type="text" class="form-control" placeholder="Search" value='<c:out value="${searchVo.searchKeyword}"/>'
	    onkeydown="if(event.keyCode == 13) { fn_search_formSubmit();}">
	  </div>
	  <input type="button" class="btn btn-default" name="btn_search" value="검색"  onclick="searchFormSubmit()" />
	</form>
  </div><!-- container -->
	
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/bootstrap.js"></script>
<script>
	function searchFormSubmit(){
		//검색
		document.search_form.submit();
	}
</script>

</body>
</html>