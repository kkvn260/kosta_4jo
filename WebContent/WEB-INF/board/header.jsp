<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title> 
<style>
#all,#book,#travel,#movie,#notice{
	margin-top:20px;
	width: 250px;
	height:50px;
	border: none;
	font-weight: bold;
	font-size: 20px;
	color:gray;

}
</style>

</head>
<body>
<div>
<h2>talk together</h2>
<c:if test="${sessionScope.id==null}">
           <a href="login.do">로그인</a>
           <a href="join.do">회원가입</a>
    </c:if>
    <c:if test="${sessionScope.id!=null }">
       
           <a href="myinfo.do"><%=session.getAttribute("id") %>님</a>
           <a href="logout.do">로그아웃</a>
    </c:if>
</div>
<!-- <<<<<<< HEAD -->
<input type="button" id="all" value="전체" onclick="location.href='/kosta_4jo/list.do'">
<input type="button" id="book" value="도서" onclick="location.href='/kosta_4jo/list.do?cat=도서'" >
<input type="button" id="travel" value="여행" onclick="location.href='/kosta_4jo/list.do?cat=여행'">
<input type="button" id="movie" value="영화" onclick="location.href='/kosta_4jo/list.do?cat=영화'">
<input type="button" id="notice" value="공지사항" onclick="location.href='/kosta_4jo/list.do?cat=공지사항'">
<!-- =======
	
>>>>>>> branch 'master' of https://github.com/kkvn260/kosta_4jo.git -->
</body>
</html>