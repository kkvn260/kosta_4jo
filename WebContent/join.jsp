<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

</head>
<body>

<form method="post" action="joinresult.do">
<ul>
      <li>
          <label for="id">아이디</label><br>
          <input type="text" name="id" id="id" required="required">
          <input type="button" value="중복체크"  onclick="idcheck()">
     </li>
     <li>
          <label for="pwd">패스워드</label><br>
          <input type="password" name="pwd" id="pwd" required="required">
     </li>
     <li>
          <label for="name">이름</label><br>
          <input type="text" name="name" id="name" required="required">
     </li>
     <li>
          <label for="email">이메일</label><br>
          <input type="text" name="email" id="email" required="required">
     </li>
     <li>
            <input type="submit" value="가입">
            <input type="reset" value="취소">
      </li>
</ul>
</form>


</body>
</html>