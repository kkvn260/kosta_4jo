<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style>
      #myinfo{margin-top:50px; margin-bottom:30px;}
      #myinfo2 tr td{border:1px solid silver; width:200px; height:50px; background-color:#ffffcc; }
</style>
</head>
<body>

<c:set var="dto" value="${requestScope.dto}"></c:set>
 
<form method="post" action="myinforesult.do">
     <div id="myinfo">
           <input type="submit" id="id" value="내 정보 보기" class="btn btn-success"></div>

      <div  id="myinfo2">
           <table>
                 <tr><td><strong>아이디</strong></td><td><c:out value="${dto.id }"></c:out></td></tr>
                 <tr><td><strong>이름</strong></td><td><c:out value="${dto.name }"></c:out></td></tr>
                 <tr><td><strong>이메일</strong></td><td><c:out value="${dto.email }"></c:out></td></tr>
          </table>
       </div>
</form>

</body>
</html>