<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><c:out value="${boardGroup.detailedname}-${boardArticle.title}"/></title>
<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="/css/header.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/common/header.jsp" />
  <div class="container">
    <div class="table-responsive">
	  <!-- 글 내용 테이블 -->
	  <table class="table table-hover">
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
	</div>
	<!-- 뒤로가기 -->
	<a href="<c:out value="/board/${boardGroup.simplename}"/>">돌아가기</a>
	<!-- 수정 -->
	<a href="<c:out value="/board/${boardGroup.simplename}/article/${boardArticle.id}/form"/>">수정</a>
	<!-- 삭제 폼 -->
	<form name="delete_form" action="<c:out value="/board/${boardGroup.simplename}/article/${boardArticle.id}"/>" method="post">
		<input type="hidden" name="_method" value="delete"> 
		<a href="#" onclick="delete_form.submit()">삭제</a>
	</form>
	<p>&nbsp;</p>
	<!-- 댓글 폼 -->
	<div style="border: 1px solid; width: 600px; padding: 5px">
    	<form name="comment_form" action="/board/${boardGroup.simplename}/article/${boardArticle.id}/comment" method="post">
       		 작성자: <input type="text" name="writer" size="20" maxlength="20"> <br/>
        	<textarea name="content" rows="3" cols="60" maxlength="500" placeholder="댓글을 달아주세요."></textarea>
        	<a href="#" onclick="commentFormSubmit()">저장</a>
    	</form>
	</div>
	<!-- 댓글 리스트 -->
	<c:forEach var="commentList" items="${commentList}" varStatus="status">
	    <div style="border: 1px solid gray; width: 600px; padding: 5px; margin-top: 5px;">    
	        <c:out value="${commentList.writer}"/> <c:out value="${commentList.date}"/>
	        <a href="#" onclick="commentDelete('<c:out value="${commentList.id}"/>')">삭제</a>
	        <a href="#" onclick="commentUpdate('<c:out value="${commentList.id}"/>')">수정</a>
	        <br/>
	        <div id="comment<c:out value="${commentList.id}"/>"><c:out value="${commentList.content}"/></div>
	    </div>
	</c:forEach>
	<!-- 댓글 수정 폼 -->
	<div id="comment_div" style="width: 99%; display:none">
	    <form name="comment_update_form" action="/board/${boardGroup.simplename}/article/${boardArticle.id}/comment/" method="post">
	    	<input type="hidden" name="_method" value="put">
	        <textarea name="content" rows="3" cols="60" maxlength="500"></textarea>
	        <a href="#" onclick="commentUpdateSave()">저장</a>
	        <a href="#" onclick="commentUpdateCancel()">취소</a>
	    </form>
	</div>
  </div>
<script>
//댓글 저장
function commentFormSubmit(){
	var commentForm = document.comment_form;
	
	if (commentForm.content.value=="") {
		alert("글 내용을 입력해주세요.");
		commentForm.content.focus();
		return;
	}
	commentForm.submit();
}
//댓글 삭제 (댓글id)
function commentDelete(commentId){
	if (!confirm("삭제하시겠습니까?")) {
		return;
	}
	var updateForm = document.comment_update_form;
	
	updateForm.action += commentId;
	updateForm._method.value="delete";
	updateForm.submit();	
} 

//수정 댓글 id, 내용
var updateCommentId = null;
var updateCommentContent = null;

//댓글 수정 페이지 (댓글id)
function commentUpdate(commentId){
	var updateForm = document.comment_update_form;
	var comment = document.getElementById("comment"+commentId);
	var commentDiv = document.getElementById("comment_div");
	commentDiv.style.display = "";
	//기존 댓글을 수정중이었다면 기존 댓글을 원래대로 바꿈.
	if (updateCommentId) {
		document.body.appendChild(commentDiv);
		var existingComment = document.getElementById("comment"+updateCommentId);
		existingComment.innerText = updateCommentContent;
	} 
	//댓글 수정폼의 내용을 commentId의 내용으로 채움.
	updateForm.content.value = comment.innerText;
	comment.innerText ="";
	comment.appendChild(commentDiv);
	updateCommentId   = commentId;
	updateCommentContent = updateForm.content.value;
	updateForm.content.focus();
} 
//댓글 수정 저장
function commentUpdateSave(){
	var updateForm = document.comment_update_form;
	if (updateForm.content.value=="") {
		alert("글 내용을 입력해주세요.");
		updateForm.content.focus();
		return;
	}
	
	updateForm.action += updateCommentId;
	updateForm._method.value="put";
	updateForm.submit();	
} 
//댓글 수정 취소
function commentUpdateCancel(){
	var updateForm = document.comment_update_form;
	var commentDiv = document.getElementById("comment_div");
	document.body.appendChild(commentDiv);
	commentDiv.style.display = "none";
	
	var existingComment = document.getElementById("comment"+updateCommentId);
	existingComment.innerText = updateCommentContent;
	updateCommentId = null;
	updateCommentContent = null;
} 

	
</script>
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/bootstrap.js"></script>
</body>
</html>
