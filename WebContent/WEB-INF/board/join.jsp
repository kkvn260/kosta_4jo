<%@page import="group4.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>

<style>
    ul li{
        list-style:none;
        text-align:center;
    }
    .a{color:blue;}
    .b{color:red;}
    
</style>
</head>
<body>
	<form name="join" method="post" action="idcheck.do">
	<ul>
	   <li>
	   <h1>회원가입</h1>
	    <label>아이디 중복확인</label>
		      <input type="text" placeholder="UserID"  name="id"> 
		      <input type="submit" value="중복확인">
		<span class="a">
			<c:if test='${param.msg =="OK"}'>&nbsp;&nbsp;사용가능한 아이디</c:if></span>
	    <span class="b">
			<c:if test='${param.msg=="NotOK" }'>&nbsp;&nbsp;이미 존재하는 아이디</c:if></span>   
	    </li>
	</ul>
	</form>

	<form name="join"  method="post" action="joinresult.do">
		<ul>
			<li><label for="id">아이디</label><br> <%-- <input type="text" name="id" id="id" required="required">--%>
				<c:if test='${param.msg == "OK"}'>
                ${param.id }<input type="hidden" name="id" value="${param.id }">
				</c:if></li>
			<li><label for="pwd">패스워드</label><br>
			       <input type="password" placeholder="Password" name="pwd" id="pwd" required="required" ></li>
			<li><label for="name">이름</label><br> 
			      <input type="text" placeholder="Name" name="name" id="name" required="required"></li>
			<li><label for="email">이메일</label><br> 
			       <input type="text" placeholder="Email" name="email" id="email" required="required"><br><br></li>
			
			<li><input type="submit" value="회원가입" onclick="checkpwd()">
			       <input type="reset" value="취소"></li> 
			<li>
                   <label>이미 아이디가 있으신가요?</label>
                   <a href="login.do">로그인</a>
            </li>      
		</ul>
	</form>



</body>
</html>
