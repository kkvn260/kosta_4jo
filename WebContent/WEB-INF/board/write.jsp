<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<body>
<c:set var="category" value="${requestScope.category }"></c:set>
	<form method="post" action="write.do" enctype="multipart/form-data">
		<div>
			<h3>게시판 글쓰기</h3>
		</div>
		<div>
			<select name="board_name">
				<c:choose>
				<c:when test="${category eq '도서' }"><option value="도서">도서</option></c:when>
				<c:when test="${category eq '여행' }"><option value="여행">여행</option></c:when>
				<c:when test="${category eq '영화' }"><option value="영화">영화</option></c:when>
				<c:when test="${category eq '공지사항' }"><option value="공지사항">공지사항</option></c:when>
				<c:otherwise>
				<option >게시판을 선택해주세요</option>
				<option value="도서">도서</option>
				<option value="여행">여행</option>
				<option value="영화">영화</option>
				</c:otherwise>
				</c:choose>
			</select>
			<input type="text" name="write_title" placeholder="제목을 입력해주세요" style="width: 100%;">
		</div>
		<div>
			<textarea rows="15" cols="125" name="write_content" placeholder="내용을 입력해주세요"></textarea>
		</div>
		<div>
			<label>이미지 미리보기</label>
			<input type="file" name="put_file" accept="image/*" id="put_file">
			<div class="put_img">
				<img src=""/>
			</div>
			<script>
				$("#put_file").change(
						function() {
							if (this.files && this.files[0]) {
								var reader = new FileReader;
								reader.onload = function(data) {
									$(".put_img img").attr("src",
											data.target.result).width(200);
								}
								reader.readAsDataURL(this.files[0]);
							}
						});
			</script>
		</div>
		<input type="submit" value="등록">
		<input type="reset"value="취소">
	</form>
</body>
</html>