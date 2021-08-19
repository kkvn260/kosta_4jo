<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Talk together</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="style/style.css">

</head>
<body>

	<c:set var="list" value="${requestScope.list}"></c:set>
	<c:set var="currpage" value="${requestScope.currpage }"></c:set>
	<c:set var="datacount" value="${requestScope.datacount }"></c:set>
	<c:set var="startblock" value="${requestScope.startblock }"></c:set>
	<c:set var="endblock" value="${requestScope.endblock }"></c:set>
	<c:set var="totalpage" value="${requestScope.totalpage }"></c:set>
	<c:set var="search" value="${requestScope.search }"></c:set>
	<c:set var="searchtxt" value="${requestScope.searchtxt }"></c:set>
	<c:set var="startrow" value="${requestScope.startrow }"></c:set>
	<c:set var="category" value="${requestScope.category }"></c:set>
	<c:set var="id" value="${requestScope.id }"></c:set>



	<div class="search">
		<form method="get" action="list.do">
			<input type="hidden" name="cat" value="${category }"> <select
				name="search">
				<option value="title">제목</option>
				<option value="content">내용</option>
				<option value="id">작성자</option>
			</select> <input type="text" name="searchtxt"> <input type="submit"
				value="검색">
		</form>

	</div>

	<table>

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
			<c:set var="no" value="${startrow-1 }"></c:set>
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
	<div class="page1">
		<c:if test="${startblock>1 }">
			<a
				href="list.do?curr=${currpage-1 }&search=${search}&searchtxt=${searchtxt}&cat=${category}">이전</a>
		</c:if>
	</div>
	<div class="page2">
		<c:forEach var="index" begin="${startblock }" end="${endblock}">
			<c:if test="${currpage==index }">
				<c:out value="${index }"></c:out>
			</c:if>
			<c:if test="${currpage!=index }">
				<a
					href="list.do?curr=${index}&search=${search}&searchtxt=${searchtxt }&cat=${category}">${index}</a>
			</c:if>
		</c:forEach>
	</div>
	<div class="page3">
		<c:if test="${endblock<totalpage }">
			<a
				href="list.do?curr=${currpage+1}&search=${search}&searchtxt=${searchtxt}&cat=${category}">다음</a>
		</c:if>
	</div>
	
	<c:choose>
		<c:when test="${category eq '공지사항' }">
			<c:if test="${id eq 'admin' }">
				<a href="writeform.do?cat=${category }">글쓰기</a>
			</c:if>
		</c:when>
		<c:otherwise>
			<a href="writeform.do?cat=${category }">글쓰기</a>
		</c:otherwise>
	</c:choose>

</body>
</html>