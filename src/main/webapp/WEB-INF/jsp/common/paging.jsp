<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${searchVo.totalPage>1}">
	<div class="paging">
		<c:if test="${searchVo.page>1}">
			<a href="javascript:fnSubmitForm(1);">[처음]</a>
			<a href="javascript:fnSubmitForm(${searchVo.page-1});">[이전]</a>
		</c:if>
				
		<c:forEach var="i" begin="${searchVo.pageStart}" end="${searchVo.pageEnd}" step="1" varStatus="status">
            <c:choose>
                <c:when test="${i eq searchVo.page}">
                	<c:out value="${i}"/>
                </c:when>
                <c:otherwise>
                	<a href="javascript:fnSubmitForm(${i});"><c:out value="${i}"/></a>
                </c:otherwise>
            </c:choose>
            <c:if test="${not status.last}">|</c:if>
        </c:forEach>
        
		<c:if test="${searchVo.totalPage > searchVo.page}">
			<a href="javascript:fnSubmitForm(${searchVo.page+1});">[다음]</a>
			<a href="javascript:fnSubmitForm(${searchVo.totalPage});">[마지막]</a>
		</c:if>
	</div>
	<br/>
		
	<input type="hidden" name="page" id="page" value="" />
		
	<script type="text/javascript">
	function fnSubmitForm(page){ 
		document.form1.page.value=page;
		document.form1.submit();
	}
	</script>
</c:if>
