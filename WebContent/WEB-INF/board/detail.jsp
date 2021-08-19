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
 	 <c:out value="${boarddto.filename }"></c:out>
 	 
 	 
 <ul>
 
   <li>
   <label for="bno">글번호</label>
   <input type="text" name="bno" value="${boarddto.boardno }"  readonly="readonly">
   </li>
   <li>
   <label for="title">제목</label>
   <input type="text" name="title" value="${boarddto.title}"  readonly="readonly">
   </li>
   <li>
   <label for="id">아이디</label>
   <input type="text" name="id" value="${boarddto.id }" readonly="readonly">
   </li>
   <li>
   <label for="viewno">조회수</label>
   <input type="text" name="viewno" value="${boarddto.viewno }" readonly="readonly">
   </li>
   <li>
   <label for="content">내용</label>
   <input type="text" name="content" value="${boarddto.content }" readonly="readonly">
   </li>
   <li><img class="fit-picture" src="file/${boarddto.filename }" alt="첨부이미지"></li>
   <li>
   <label for="writedate">작성일</label>
   <input type="text" name="writedate" value="${boarddto.writedate }" readonly="readonly">
   </li>

     <!-- 댓글 -->
    <li id="result"></li>
    
    <li>
	<form method="post" action="replyadd.do">
	<input type="hidden" name="num" value="${boarddto.boardno }">
	<textarea rows="3" cols="20" name="content" required="required" ></textarea><br>
	<input type="text" name="id" value="${sessionScope.id}" required="required"><br>
	<input type="submit" value="댓글쓰기">
	</form>
	</li>
	
 </ul>

	
	<br>
	<a href="list.do?cat=${boarddto.board_name}">목록으로</a>
	

	  <c:if test="${sessionScope.id==boarddto.id}">
	     <a href="del.do?boardno=${boarddto.boardno}&cat=${boarddto.board_name}">삭제</a>
	     <a href="modify.do?boardno=${boarddto.boardno}&cat=${boarddto.board_name}">수정</a>
	  </c:if>
	

<!--<script src="js/detail.js"></script>-->
</body>
</html>