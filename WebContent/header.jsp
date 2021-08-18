
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title> 
</head>
<body>
<div>
<h2>talk together</h2>
<c:if test="${sessionScope.id==null}">
           <a href="login.do">로그인</a>
           <a href="join.do">회원가입</a>
    </c:if>
    <c:if test="${sessionScope.id!=null }">
           <a href="logout.do">로그아웃</a>
           <a href="myinfo.do"><%=session.getAttribute("id") %>님</a>
    </c:if>
</div>
	
</body>
</html>