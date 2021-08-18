<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Talk together</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
#all,#book,#travel,#movie,#notice{
	margin-top:20px;
	width: 250px;
	height:50px;
	border: none;
	font-weight: bold;
	font-size: 20px;
	color:gray;

}

}
table{
	border-collapse: collapse;
    width:750px;
	
	
}

th, td{
	border:1px solid silver;
}

thead th{
	  background-color:silver;

}

div.page1 a{
	margin-top:20px;
	text-decoration: none;
	display: inline-block;
	float:left;
	margin-left:10px; 

}
div.page1 a:hover{
	background-color:skyblue;
}
div.page2{
	margin-top:20px;

	float:left;
	margin-left:5px;
}

div.page2 a{
	display:inline-block;
	background-color:skyblue;
	color:white;
	text-decoration:none;
	width:20px; 
	
}

div.page3 a{
	margin-top:20px;
	margin-top:20px;
	text-decoration: none;
	display: inline-block;
	float:left;
	margin-left:10px; 
	
}
div.page3 a:hover{
	background-color:skyblue;
}

div.clear{
	clear:both;
}

div.search{
	
	margin-top:10px;
	display:inline-block;
	
}



</style>


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



<div class="search">
<form method="get"  action="list.do" >
     <select name="search">
       <option value="title">제목</option>
       <option value="content">내용</option>
       <option value="id">작성자</option>
     </select>
     <input type="text" name="searchtxt">
    <input type="submit" value="검색">
 </form>

 </div>
 
<table>

  <thead><tr><th>번호</th><th>제목</th><th>내용</th><th>작성자</th><th>조회수</th><th>작성일</th>
  <th>좋아요</th></tr>
  </thead>
  <tbody>
  	<c:set var="no" value="${startrow-1 }"></c:set>
    <c:forEach var="item" items="${list}">
		<c:set var="no" value="${no+1 }" />
      <tr><td><c:out value="${no }" /></td>
      <td><a href="detail.do?boardno=${item.boardno }"><c:out value="${item.title }"/></a></td>
      <td><c:out value="${item.content }"></c:out></td>
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
	<a href="list.do?curr=${currpage-1 }&search=${search}&searchtxt=${searchtxt}">이전</a>
</c:if>
</div>
<div class="page2">
<c:forEach var="index" begin="${startblock }" end="${endblock}">
<c:if test="${currpage==index }">
	<c:out value="${index }"></c:out>
</c:if>
<c:if test="${currpage!=index }">
	<a href="list.do?curr=${index}&search=${search}&searchtxt=${searchtxt }">${index}</a>
</c:if>
</c:forEach>
</div>
<div class="page3">
<c:if test="${endblock<totalpage }">
	<a href="list.do?curr=${currpage+1}&search=${search}&searchtxt=${searchtxt}">다음</a>
</c:if>
</div>

<a href="writeform.do">글쓰기</a>

</body>
</html>