<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="js/detail.js"></script>
<script>

/* 댓글조회 */
$(document).ready(function(){
	 let no = ${boarddto.boardno};
    console.log(no);
	 $.ajax({
		url:'replydetail.do'
		,data:{'num':no}
		,method:'post'
		,dataType:'json'
		,success:function(data){
			
			$.each(data,function(index,list){
                reply="<span>";  
				reply+=list.id+"</span><br>";
				reply+="<span>"+list.reply_writedate+"</span><br>";
				reply+="<span>"+list.replycontent+"</span>";
				
			    if(list.id == "${sessionScope.id}"){  
				reply+="<span><input type='button' value='삭제' onclick=del("+list.replyno+","+list.boardno+")></span><br>";
				} 
				$('#result').append(reply);
			});
		}
		,error:function(xhr){
			console.log('error'+xhr);
		}
		 
	 });
});
</script>


<c:set var="boarddto" value="${requestScope.boarddto }"></c:set>
</head>
<body>


 	<div><br>
 		<span>[${boarddto.board_name }]</span><span>   ${boarddto.title }</span>
 	</div>
 	<div>
 		<span>${boarddto.id }  |</span><span>  ${boarddto.writedate }</span>
 	</div>
 	<div>
 		<span>조회수 : ${boarddto.viewno }</span>
 		<span>좋아요수 : ${boarddto.likeno }</span>
 	</div>
 	
   <label for="content">내용</label><br>
   <textarea rows="15" cols="125" readonly="readonly">${boarddto.content }</textarea>
   	<c:if test="${not empty boarddto.filename}">
   <li><img class="fit-picture" src="file/${boarddto.filename }" alt="첨부이미지"></li>
   	</c:if>
    <br>
    <label>댓글 내용</label><br>


     <!-- 댓글 -->

    <div id="result"></div>

	<form method="post" action="replyadd.do">
	<input type="hidden" name="num" value="${boarddto.boardno }">
	<textarea rows="3" cols="20" name="content" required="required" ></textarea><br>
	<label>작성자</label><br>
	<input type="text" name="id" value="${sessionScope.id}" required="required"><br>
	<input type="submit" value="댓글쓰기">
	</form>


	
	<br>
	<a href="list.do?cat=${boarddto.board_name}">목록으로</a>
	

	  <c:if test="${sessionScope.id==boarddto.id}">
	     <a href="del.do?boardno=${boarddto.boardno}&cat=${boarddto.board_name}">삭제</a>
	     <a href="modify.do?boardno=${boarddto.boardno}&cat=${boarddto.board_name}">수정</a>
	  </c:if>
	

</body>
</html>