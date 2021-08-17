<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
	<div> 
		<%@ include file="header.jsp"%>
	</div>
	<section>
		<c:set var="page" value="${param.page }"></c:set>
		<jsp:include page="${page }"></jsp:include>
	</section>
	<footer>
		<%@include file="footer.jsp"%>
	</footer>

</body>
</html>