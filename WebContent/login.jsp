<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="loginresult.do">
   <ul>
        <li>
             <label for="id">아이디</label>
             <input type="text" name="id" id="id">
       </li>
       <li>
            <label for="pwd">패스워드</label>
            <input type="password" name="pwd" id="pwd">
      </li>
      <li>
            <input type="submit" value="로그인">
            <input type="reset" value="취소">
      </li>
   </ul>
</form>
</body>
</html>