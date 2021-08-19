<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="style/style.css">
<style>
	#wrap1{
		float: left;
	}
	#wrap3{
		float: right;
	}
	#wrap2{
		clear: both;
	}

</style>
</head>
<body>
	<c:set var="list" value="${requestScope.list}"></c:set>
	<c:set var="list2" value="${requestScope.list2}"></c:set>
	<c:set var="list3" value="${requestScope.list3}"></c:set>
	<c:set var="startrow" value="${requestScope.startrow }"></c:set>

	<!-- 조회수 높은 게시물 탑10-->
	<div id="wrap1">
		<h3>조회수 TOP10</h3>
		<div style="width: 400px; height: 200px; overflow: auto">
			<table style="width:100%; border:0; cellspacing:0; cellpadding:0;">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>좋아요</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="no" value="${startrow }"></c:set>
					<c:forEach var="item" items="${list}">
						<c:set var="no" value="${no+1 }" />
						<tr>
							<td><c:out value="${no }" /></td>
							<td><a href="detail.do?boardno=${item.boardno }"><c:out
										value="${item.title }" /></a></td>
							<td><c:out value="${item.id }"></c:out></td>
							<td><c:out value="${item.viewno }"></c:out></td>
							<td><c:out value="${item.writedate }"></c:out></td>
							<td><c:out value="${item.likeno }"></c:out></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>


	<!-- 공지사항-->
	<div id="wrap3">
		<h3>최근 공지사항</h3>
		<div style="width: 400px; height: 200px; overflow: auto">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>좋아요</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="no" value="${startrow }"></c:set>
					<c:forEach var="item" items="${list3}">
						<c:set var="no" value="${no+1 }" />
						<tr>
							<td><c:out value="${no }" /></td>
							<td><a href="detail.do?boardno=${item.boardno }"><c:out
										value="${item.title }" /></a></td>
							<td><c:out value="${item.id }"></c:out></td>
							<td><c:out value="${item.viewno }"></c:out></td>
							<td><c:out value="${item.writedate }"></c:out></td>
							<td><c:out value="${item.likeno }"></c:out></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<!-- 좋아요 높은 게시물 탑5 -->
	<div id="wrap2">
	<br>
		<h3>좋아요 TOP5 미리보기</h3>
		<div style="width: 100%; height: 200px; overflow: auto" id="preview">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<c:forEach var="item" items="${list2}">
						<c:choose>
							<c:when test="${not empty item.filename }">
								<td><a href="detail.do?boardno=${item.boardno }"> <img
										src="file/${item.filename }" alt="${item.title }"
										width="300px" height="175px" />
								</a></td>
							</c:when>
							<c:otherwise>
								<td><a href="detail.do?boardno=${item.boardno }"> <c:out
											value="${item.title }"></c:out>
								</a></td>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>