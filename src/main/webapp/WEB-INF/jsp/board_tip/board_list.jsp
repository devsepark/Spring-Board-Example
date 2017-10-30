<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Tip&강좌 게시판</title>
</head>
<body>
<a href="/board/tip/form">글쓰기</a>
                    
<table border="1" style="width:600px">
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
        </tr>
    </thead>
    <tbody>
        <c:forEach var="list" items="${list}" varStatus="status">    
            <c:url var="link" value="/board/tip/article/${list.id}"/>   
            <tr>
                <td><c:out value="${list.id}"/></td>
                <td><a href="${link}"><c:out value="${list.title}"/></a></td>
                <td><c:out value="${list.writer}"/></td>
                <td><c:out value="${list.date}"/></td>
           </tr>
        </c:forEach>
    </tbody>
</table>    
</body>
</html>