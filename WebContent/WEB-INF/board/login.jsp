<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="style/style.css">
<style>
      h2.meet{margin-left:340px;}
      p.text-info{margin-left:300px; margin-top:20px; margin-bottom:50px;}
      .login2{margin-left:280px;}
</style>
</head>
<body>

<form method="post" action="loginresult.do">
<h2 class="meet">방문을 환영합니다</h2>
<p class="text-info"><strong>로그인을 하시면 다양한 서비스를 이용하실 수 있습니다.</strong></p>
   <div class="login2">
   <ul>
        
        <li ><div class="id">
             <label for="id" >아이디</label>
             <input type="text" name="id" id="id">
       </div></li>
       <li>
            <label for="pwd">패스워드</label>
            <input type="password" name="pwd" id="pwd"><br><br>
      </li>
      <li><div class="login">
            <input type="submit" value="로그인" class="btn btn-info">
            <input type="reset" value="취소" class="btn btn-default"><br><br>
      </div></li>
      <li>
            <span class="bg-info"><label>아직 Talk together! 회원이 아니신가요?</label></span>
            <a href="join.do">회원가입</a>
      </li>      
   </ul>
   </div>
</form>
</body>
</html>