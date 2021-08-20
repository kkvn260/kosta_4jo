<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title> 

<link rel="stylesheet" href="style/style.css">


<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>
<h1 id="main"><strong><a href="main.do">Talk together!</a></strong></h1>
<div class="header">
<c:if test="${sessionScope.id==null}">
           <a href="login.do">로그인 </a>
           <label>| </label>
           <a href="join.do">회원가입</a>
    </c:if>
    <c:if test="${sessionScope.id!=null }">
       
           <a href="myinfo.do"><%=session.getAttribute("id") %>님 | </a>
           <a href="logout.do">로그아웃</a>
    </c:if>
</div>
<!-- <<<<<<< HEAD -->
<div class="button">
<input type="button" id="all" value="전체" onclick="location.href='/kosta_4jo/list.do'">
<input type="button" id="book" value="도서" onclick="location.href='/kosta_4jo/list.do?cat=도서'" >
<input type="button" id="travel" value="여행" onclick="location.href='/kosta_4jo/list.do?cat=여행'">
<input type="button" id="movie" value="영화" onclick="location.href='/kosta_4jo/list.do?cat=영화'">
<input type="button" id="notice" value="공지사항" onclick="location.href='/kosta_4jo/list.do?cat=공지사항'">
</div>
<!-- =======
	
>>>>>>> branch 'master' of https://github.com/kkvn260/kosta_4jo.git -->
</body>
</html>