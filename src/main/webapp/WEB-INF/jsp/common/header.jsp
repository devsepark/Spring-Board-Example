<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/index">IT Info</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
			<li<c:if test="${boardGroup.simplename eq 'qna'}"> class="active"</c:if>><a href="/board/qna">QnA</a></li>
            <li<c:if test="${boardGroup.simplename eq 'tip'}"> class="active"</c:if>><a href="/board/tip">강좌n팁</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">커뮤니티 <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li<c:if test="${boardGroup.simplename eq 'community'}"> class="active"</c:if>><a href="/board/community">전체</a></li>
                <li role="separator" class="divider"></li>
                <li<c:if test="${boardGroup.simplename eq 'notice'}"> class="active"</c:if>><a href="/board/notice">공지사항</a></li>
                <li<c:if test="${boardGroup.simplename eq 'forum'}"> class="active"</c:if>><a href="/board/forum">포럼</a></li>
                <li<c:if test="${boardGroup.simplename eq 'free'}"> class="active"</c:if>><a href="/board/free">자유게시판</a></li>
              </ul>
            </li>
            <li<c:if test="${boardGroup.simplename eq 'chat'}"> class="active"</c:if>><a href="/chat">채팅</a></li>
          </ul>
		  <!-- TODO 전체 검색 -->
		  <form class="navbar-form navbar-left">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
			<button type="submit" class="btn btn-default">검색</button>
		  </form>
		  <ul class="nav navbar-nav navbar-right">
			<li><a href="#" data-toggle="modal" data-target="#regist-modal"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
			<li><a href="#" data-toggle="modal" data-target="#login-modal"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
		  </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    	  <div class="modal-dialog">
				<div class="loginmodal-container">
					<h1>Login to Your Account</h1><br>
				  <form>
					<input type="text" name="user" placeholder="Username">
					<input type="password" name="pass" placeholder="Password">
					<input type="submit" name="login" class="login loginmodal-submit" value="Login">
				  </form>
					
				  <div class="login-help">
					<a href="#">Register</a> - <a href="#">Forgot Password</a>
				  </div>
				</div>
			</div>
		  </div>