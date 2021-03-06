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
<style>
	#likeUpdate{
		background-color: #FFDFE0;
		border: 0;
		float: right;
	}	

	label,textarea,.t1{
		font-size:18px;
	}
	.label1{
		magin:0;
		float:left;
	}
	#result{
	  	font-size:18px;
	}
	
</style>
<script>

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
                reply="<span>";  
				reply+=list.id+"</span>&emsp;&emsp;";
				reply+="<span>"+list.replycontent+"</span>&emsp;";
				reply+="<span>"+list.reply_writedate+"</span>";
				
			    if(list.id == "${sessionScope.id}"){  
				reply+="<span><input type='button' value='삭제' onclick=del("+list.replyno+","+list.boardno+")></span>";
				} 
			    reply+="<br>"
				$('#result').append(reply);
			});
		}
		,error:function(xhr){
			console.log('error'+xhr);
		}
	 });
	 
	 
	 /* 좋아요 증감 */
	$(function(){	 
		$(".likeUpdate").click(function(){
			console.log('현재 좋아요 값:'+${boarddto.likeno });
			if(!"${id}"){
				alert("회원만 추천할 수 있습니다");
				location.href="login.do";
			}else{
				$.ajax({
					url:'like.group4'
				   ,data:{'no':no}
				   ,method:'post'
				   ,dataType:'json'
				   ,success: function(data){
					   console.log(data);
				      $("#likeUpdate span").text(data.total); 
				      $(".t1").eq(-1).text(data.total);
				      if(data.likeCheck == 0){
				    	  $("#likeUpdate span").eq(-1).text(" ${sessionScope.id}님이 이 게시글을 좋아합니다!");
				      }else{
				    	  $("#likeUpdate span").eq(-1).text(" ${sessionScope.id}님이 '좋아요'를 취소했습니다!");
				      }
				   }
				   ,error:function(xhr){
						console.log('error'+xhr);
					}
				})
			}	
		});
	});
	 
	 
	 
});
</script>

<c:set var="boarddto" value="${requestScope.boarddto }"></c:set>
</head>
<body>


 	<div><br>
 		<span class="t1">[${boarddto.board_name }]</span><span class="t1">   ${boarddto.title }</span>
 	</div>
 	<div>
 		<span class="t1">${boarddto.id }  |</span><span class="t1">  ${boarddto.writedate }</span>
 	</div>
 	<div>
 		<span class="t1">조회수 : ${boarddto.viewno }</span>
 		<span class="t1">좋아요수 : </span>
 		<span class="t1">${boarddto.likeno } </span>
 		
 	</div>
 	
      	<!-- 좋아요! -->
     	<div>
   			<label for="content" class="label1">내용</label>
     		<button class="likeUpdate" id="likeUpdate">
     			<img src="file/11.png" width="30px">
     		   <span>${boarddto.likeno }</span>
     		   <c:choose>
     		        <c:when test="${likecheck!=0 }">
     		   		&nbsp;<span><mark> ${sessionScope.id}님이 '좋아요'한 게시글입니다</mark></span>
     		   		</c:when>
     		   		<c:otherwise>
     		   		&nbsp;<span></span>
     		   		</c:otherwise>
     		   </c:choose>
     		</button>
     	</div>
   <br>
   <textarea rows="15" cols="100" readonly="readonly">${boarddto.content }</textarea>
   	<c:if test="${not empty boarddto.filename}">
   		<p>이미지 미리보기</p>
   		<img class="fit-picture" src="file/${boarddto.filename }" alt="첨부이미지">
   	</c:if>

    <br>
    <label>댓글 내용</label><br>


     <!-- 댓글 -->
    <div id="result"></div><br>
    
    <!-- 댓글 추가 -->
    <form method="post" action="replyadd.do" >
	<h4><input type="text" name="id" value="${sessionScope.id}" required="required" readonly="readonly" style="border:none;" ></h4>
	<input type="hidden" name="num" value="${boarddto.boardno }">
	<textarea rows="3" cols="60" name="content" required="required" placeholder="댓글을 남겨주세요" ></textarea><br>
	<input type="submit" value="댓글쓰기">
	</form>

	
	<br>
	<button type="button" class="btn btn-success" onclick ="location.href='/kosta_4jo/list.do?cat=${boarddto.board_name}'">목록으로</button>
	

	  <c:if test="${sessionScope.id==boarddto.id}">
	     &nbsp;<button type="button" class="btn btn-default" onclick ="location.href='/kosta_4jo/modify.do?boardno=${boarddto.boardno}&cat=${boarddto.board_name}'">수정</button> 
	     &nbsp;<button type="button" class="btn btn-default" onclick="location.href='/kosta_4jo/del.do?boardno=${boarddto.boardno}&cat=${boarddto.board_name}'">삭제</button>
	  </c:if>
	

</body>
</html>