<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><c:out value="${boardGroup.detailedName}"/></title>
<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="/css/header.css">
<link rel="stylesheet" href="/css/summernote.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/common/header.jsp" />
<div class="container">
  <div class="col-lg-12">
	<!-- 글쓰기 폼 -->
	<form name="write_form" action="<c:out value="/board/${boardGroup.simpleName}"/>" method="post">
	  <h3 class="text-muted">${boardGroup.detailedName} 게시판</h3>
	  <input type="text" name="title" class="form-control" placeholder="제목을 입력해주세요." required>
	  <br style="clear: both"> 
	  <textarea name="content" id="summernote"></textarea>
	  <!-- 돌아가기, 저장 버튼 활성화. -->
	  <a href="#" onclick="writeFormSubmit()" role="button" class="btn btn-primary pull-right">저장</a>
	</form>	
  </div>
</div><!-- container -->
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/bootstrap.js"></script>
<script src="/js/summernote.js"></script>
<script src="/js/summernote-ko-KR.js"></script>
<script>
	$(document).ready(function(){
		$('#summernote').summernote({
			placeholder: '내용을 적어주세요..',
			lang: 'ko-KR',
			height: 320,
			minHeight: null,
	        maxHeight: null,
	        callbacks: {
	        	onImageUpload: function(files, editor) {
		        	sendFile(files[0], editor)
		        }
	        }
		});
	});
	
	function sendFile(file, editor){
		var data = new FormData();
		data.append('file', file);
		$.ajax({
			data: data,
			type: "POST",
			url: "/image",
			cache: false,
			contentType: false,
			enctype: 'multipart/form-data',
			processData: false,
			success: function(url) {
				console.log(url);
				$('#summernote').summernote('insertImage', url);
			}
		});
	}
	function writeFormSubmit(){
		var writeForm = document.write_form;
		
		if(writeForm.title.value=="") {
			alert("글 제목을 입력해주세요.");
			writeForm.title.focus();
			return;
		}
		if($('#summernote').summernote('isEmpty')) {
			  alert('글 내용을 입력해주세요.');
			return;
		}
		var content = $('#summernote').summernote('code');
		document.write_form.submit();
	}
</script>
</body>
</html>
