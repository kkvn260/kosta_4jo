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
<style>
	#mainjsp{
		width: 1200px;
		height: 800px;
		margin: 0 auto;
		padding: 0 0;
	}
	#content{
		width:900px;
		margin: auto; 
	}
	body{
		background-image: url("https://i.pinimg.com/564x/b5/46/39/b546396b5256a3fcc3cd3d6bef742da3.jpg");
	}
</style>
</head>
<body> 
<div id="mainjsp">
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