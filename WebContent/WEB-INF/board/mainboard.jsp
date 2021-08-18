<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="style/style.css">
</head>
<body>
<c:set var="list" value="${requestScope.list}"></c:set>
<c:set var="startrow" value="${requestScope.startrow }"></c:set>

	<div style="width: 30%; height: 200px; overflow: auto">
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

</body>
</html>