<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

</head>
<body>

<c:set var="dto" value="${requestScope.dto}"></c:set>
 
<form method="post" action="myinforesult.do">

<input type="submit" id="id" value="내 정보">

<table>
       <tr><td>아이디 : </td><td><c:out value="${dto.id }"></c:out></td></tr>
       <tr><td>이름 : </td><td><c:out value="${dto.name }"></c:out></td></tr>
       <tr><td>이메일 : </td><td><c:out value="${dto.email }"></c:out></td></tr>
  </table>
  </form>

</body>
</html>