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

</head>
<body>

<c:set var="boarddto" value="${requestScope.dto }"></c:set>


<form method="post" action="modifyresult.do">
   <input type="hidden" name="cat" value="${boardto.board_name }">
 <ul>
   <li>
   <label for="bno">글번호</label>
   <input type="text" name="bno" value="${boarddto.boardno }"  readonly="readonly">
   </li>
   <li> 작성자 : ${boarddto.id } </li>
   <li>
   <label for="title">글제목</label>
   <input type="text" name="title" id="title" value="${boarddto.title }">
   </li>
   <li>
   <label for="content">글내용</label>
   <textarea rows="15" cols="125" name="content" id="content">${boarddto.content }</textarea>
   </li>
   <li> 작성일 : ${boarddto.writedate } </li>
 
   
   <li>
   	<a href="list.do?cat=${boarddto.board_name}">목록으로</a>
    <input type="submit" value="등록">
   </li>
   
   </ul>
 </form>


	
</body>
</html>