<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>

/* 댓글삭제 */
function del(rno, bno){
	 console.log(rno,bno);
	 location.href="replydel.do?rno="+rno+"&bno="+bno;
}



/* 댓글조회 */
$(document).ready(function(){
	 let no = ${boarddto.boardno};
	 $.ajax({
		url:'replydetail.do'
		,data:{'num':no}
		,method:'post'
		,dataType:'json'
		,success:function(data){
			   
			$.each(data,function(index,list){
                reply="<tr>";  
				reply+="<td>"+list.id+"</td>";
				reply+="<td>"+list.replycontent+"</td>";
				reply+="<td>"+list.reply_writedate+"</td>";

			    /*if(list.id=="세션으로 받을 id"){   /*  세션으로 받아오는 id가 없어서 임시id로 테스트  */
			    if(list.id == "${sessionScope.id}"){  

				reply+="<td><input type='button' value='삭제' onclick=del("+list.replyno+","+list.boardno+")>";
				} 
				reply+="</td></tr>";
				$('#result').append(reply);
			});
		}
		,error:function(xhr){
			console.log('error'+xhr);
		}
		 
	 });
});



</script>
</head>
<body>

<c:set var="boarddto" value="${requestScope.boarddto }"></c:set>

<table>
   <thead>
   	<tr><td>글번호</td><td><c:out value="${boarddto.boardno }"></c:out></td></tr>
   	<tr><td>제목</td><td><c:out value="${boarddto.title }"></c:out></td></tr>
   	<tr><td>아이디</td><td><c:out value="${boarddto.id }"></c:out></td></tr>
   	<tr><td>조회수</td><td><c:out value="${boarddto.viewno }"></c:out></td></tr>
   	<tr><td>내용</td><td><c:out value="${boarddto.content }"></c:out></td></tr>
   	<tr><td>작성일</td> <td><c:out value="${boarddto.writedate }"></c:out></td></tr>
   </thead>
 	
</table>

	<!-- 댓글 -->
   <table id="result"></table>
   
	<form method="post" action="replyadd.do">
	<input type="hidden" name="num" value="${boarddto.boardno }">
	<textarea rows="3" cols="20" name="content" required="required" ></textarea><br>
	<input type="text" name="id" value="${sessionScope.id}" required="required"><br>
	<input type="submit" value="댓글쓰기">
	</form>
	<br>
	<a href="list.do?cat=${boarddto.board_name}">목록으로</a>
	

	  <c:if test="${sessionScope.id==boarddto.id}">
	     <a href="del.do?boardno=${boarddto.boardno}&cat=${boarddto.board_name}">삭제</a>
	     <a href="modify.do?boardno=${boarddto.boardno}&cat=${boarddto.board_name}">수정</a>
	  </c:if>
	

<!--<script src="js/detail.js"></script>-->
</body>
</html>