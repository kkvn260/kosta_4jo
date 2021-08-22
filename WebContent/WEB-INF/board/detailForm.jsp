<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="style/style.css">
<style>
	label,input,textarea,a{
		font-size: 18px;
	}
</style>
</head>
<body>

<c:set var="boarddto" value="${requestScope.dto }"></c:set>

<form method="post" action="modifyresult.do">

   <label for="bno">글번호 : ${boarddto.boardno }</label>
   <input type="hidden" name="bno" value="${boarddto.boardno }">
	<br>
    	<label>작성자 : ${boarddto.id }</label> <br>
  		<label>작성일 : ${boarddto.writedate }</label> 
   <br>
   <label for="title">글제목</label><br>
   <input type="text" name="title" id="title" value="${boarddto.title }">
  <br>

   <label for="content">글내용</label><br>
   <textarea rows="15" cols="125" name="content" id="content">${boarddto.content }</textarea>
   <br>
    <button type="button" class="btn btn-success" onclick ="location.href='/kosta_4jo/list.do?cat=${boarddto.board_name}'">목록으로</button>
    <input type="submit" value="등록"><br>

 </form>

</body>
</html>