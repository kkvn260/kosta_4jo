<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style/style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body> 
<div id="main">
	<div> 
		<%@ include file="header.jsp"%>
	</div>
	<section id="content">
		<c:set var="page" value="${param.page }"></c:set>
		<jsp:include page="${page }"></jsp:include>
	</section>
	
	<footer>
		<%@include file="footer.jsp"%>
	</footer>
</div>
</body>
</html>