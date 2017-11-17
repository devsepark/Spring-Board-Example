<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- 전체 페이지수가 1이상일 경우 -->
<c:if test="${searchVo.totalPage>1}">
	<div class="paging">
		<!-- 현재 페이지가 1보다 클 경우, 처음버튼 생성 -->
		<c:if test="${searchVo.page>1}">
			<a href="javascript:fn_submitForm(1);">[처음]</a>
		</c:if>
		<!-- 시작 페이지가 10 보다 클 경우, 이전버튼 생성 -->
		<c:if test="${searchVo.startPage>10}">
			<a href="javascript:fn_submitForm(${searchVo.startPage-1});">[이전]</a>
		</c:if>
		<!-- 시작 페이지부터 마지막페이지까지 1씩 증가하며 반복 -->
		<c:forEach var="i" begin="${searchVo.startPage}" end="${searchVo.endPage}" step="1" varStatus="status">
            <c:choose>
            	<%-- i가 현재페이지와 같으면 현재 페이지번호 일반 텍스트로 출력 --%>
                <c:when test="${i eq searchVo.page}">
                	<c:out value="${i}"/>
                </c:when>
                <%-- 그렇지 않으면 i를 링크 --%>
                <c:otherwise>
                	<a href="javascript:fn_submitForm(${i});"><c:out value="${i}"/></a>
                </c:otherwise>
            </c:choose>
            <%-- 반복문이 마지막이 아닐경우 |로 구분자를 넣음  --%>
            <c:if test="${not status.last}">|</c:if>
        </c:forEach>
        <!-- 전체페이지가 보이는 마지막페이지보다 클경우, 다음버튼 생성 -->
        <c:if test="${searchVo.totalPage > searchVo.endPage}">
        	<a href="javascript:fn_submitForm(${searchVo.endPage+1});">[다음]</a>
        </c:if>
        <!-- 전체페이지가 현재 페이지보다 클 경우, 마지막 버튼 생성  -->
		<c:if test="${searchVo.totalPage > searchVo.page}">
			<a href="javascript:fn_submitForm(${searchVo.totalPage});">[마지막]</a>
		</c:if>
	</div>
	<br/>
	<!-- 검색 설정 세팅 -->
	<input type="hidden" name="searchType" value=
		<c:choose>
			<c:when test="${fn:indexOf(searchVo.searchType, 'title')!=-1}">
				"title"
			</c:when>
			<c:otherwise>""</c:otherwise>
		</c:choose>
	/>
	<input type="hidden" name="searchType" value=
		<c:choose>
			<c:when test="${fn:indexOf(searchVo.searchType, 'content')!=-1}">
				"content"
			</c:when>
			<c:otherwise>""</c:otherwise>
		</c:choose>
	/>
	<input type="hidden" name="searchKeyword" value="<c:out value="${searchVo.searchKeyword}"/>"/>
		
	<input type="hidden" name="page" id="page" value="" />

	<script type="text/javascript">
	//검색 폼의 현재 페이지를 설정하고 등록
	function fn_submitForm(page){ 
		document.paging_form.page.value=page;
		document.paging_form.submit();
	}
	</script>
</c:if>
