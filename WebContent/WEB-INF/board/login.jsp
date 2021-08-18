<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<style>
    ul li{
        list-style:none;
        text-align:center;
    }
    h1{
        text-align:center;
    }
    p{
      text-align:center;
    }
</style>
</head>
<body>

<form method="post" action="loginresult.do">
<h1>방문을 환영합니다</h1>
<p><strong>로그인을 하시면 다양한 서비스를 이용하실 수 있습니다.</strong></p>
   <ul>
        <li>
             <label for="id">아이디</label>
             <input type="text" name="id" id="id">
       </li>
       <li>
            <label for="pwd">패스워드</label>
            <input type="password" name="pwd" id="pwd"><br><br>
      </li>
      <li>
            <input type="submit" value="로그인">
            <input type="reset" value="취소"><br><br>
      </li>
      <li>
            <label>아직 회원이 아니신가요?</label>
            <a href="join.do">회원가입</a>
      </li>      
   </ul>
</form>
</body>
</html>