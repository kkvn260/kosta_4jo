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
<link rel="stylesheet" href="style/style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>
    .a{color:blue;}
    .b{color:red;}
    .join{margin-top:30px; margin-bottom:50px; text-align:center;}
    .joinfo{margin-left:1px;}
    #joinform{border:3px double black; width:450px; height:410px; padding-top:20px; padding-right:30px;text-align:center; position:relative; left:230px;}
    #joinform2{text-align:center; margin-left:-20px;}
</style>
</head>
<body>
	<form method="post" action="idcheck.do">
	<div id="joinform2">
	<ul>
	   <li><br>
	   <h2 class="joinfo">회원가입</h2><br>
	    <label>아이디 중복확인</label>
		      <input type="text" placeholder="UserID"  name="id"> 
		      <input type="submit" value="중복확인">
		<span class="a">
			<c:if test='${param.msg =="OK"}'>&nbsp;&nbsp;사용가능한 아이디</c:if></span>
	    <span class="b">
			<c:if test='${param.msg=="NotOK" }'>&nbsp;&nbsp;이미 존재하는 아이디</c:if></span><br>
	    </li>
	</ul>
	</div>
	</form>

	<form method="post" action="joinresult.do">
	    <div id="joinform">
		<ul>
			<li><label for="id">아이디</label><br>
				<c:if test='${param.msg == "OK"}'>
                ${param.id }<input type="hidden" name="id" value="${param.id }">
				</c:if></li>
			<li><label for="pwd">패스워드</label><br>
			       <input type="password" placeholder="Password" name="pwd" id="pwd" required="required" ></li>
			<li><label for="name">이름</label><br> 
			      <input type="text" placeholder="Name" name="name" id="name" required="required"></li>
			<li><label for="email">이메일</label><br> 
			       <input type="text" placeholder="Email" name="email" id="email" required="required"><br><br></li>
			
			<li><div class="join">
			      <input type="submit" value="회원가입" class="btn btn-info">
			       <input type="reset" value="취소" class="btn btn-default"></div></li> 
			<li>
                   <span class="bg-info"><label>이미 아이디가 있으신가요?</label></span>
                   <a href="login.do">로그인</a>
            </li>      
		</ul>
		</div>
	</form>



</body>
</html>
