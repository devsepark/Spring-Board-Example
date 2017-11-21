<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- 전체 페이지수가 1이상일 경우 -->
<c:if test="${searchVo.totalPage>1}">
	<div class="text-center">
		<ul class="pagination">
		
		<!-- 현재 페이지가 1보다 클 경우, 처음버튼 생성 -->
		<c:if test="${searchVo.page>1}">
		  <li><a href="javascript:submitForm(1);">처음</a></li>
		</c:if>
		<!-- 시작 페이지가 10 보다 클 경우, 이전버튼 생성 -->
		<c:if test="${searchVo.startPage>10}">
			<li><a href="javascript:submitForm(${searchVo.startPage-1});">이전</a></li>
		</c:if>
		<!-- 시작 페이지부터 마지막페이지까지 1씩 증가하며 반복 -->
		<c:forEach var="i" begin="${searchVo.startPage}" end="${searchVo.endPage}" step="1" varStatus="status">
            <c:choose>
            	<%-- i가 현재페이지와 같으면 현재 페이지번호 일반 텍스트로 출력 --%>
                <c:when test="${i eq searchVo.page}">
                	<li class="active"><a href="javascript:submitForm(${i});"><c:out value="${i}"/></a></li>
                </c:when>
                <%-- 그렇지 않으면 i를 링크 --%>
                <c:otherwise>
                	<li><a href="javascript:submitForm(${i});"><c:out value="${i}"/></a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <!-- 전체페이지가 보이는 마지막페이지보다 클경우, 다음버튼 생성 -->
        <c:if test="${searchVo.totalPage > searchVo.endPage}">
        	<li><a href="javascript:submitForm(${searchVo.endPage+1});">다음</a></li>
        </c:if>
        <!-- 전체페이지가 현재 페이지보다 클 경우, 마지막 버튼 생성  -->
		<c:if test="${searchVo.totalPage > searchVo.page}">
			<li><a href="javascript:submitForm(${searchVo.totalPage});">마지막</a></li>
		</c:if>
		</ul><!-- pagination -->
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
	function submitForm(page){ 
		document.paging_form.page.value=page;
		document.paging_form.submit();
	}
	</script>
</c:if>
