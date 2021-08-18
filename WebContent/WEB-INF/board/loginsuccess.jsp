
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${result==1 }">
      <script type="text/javascript">
              alert("<%=session.getAttribute("id")%>님 로그인 되셨습니다");
              location.href="main.jsp";
      </script>
</c:if>
<c:if test="${result==0 }">
       <script type="text/javascript">
               alert("비밀번호가 틀렸습니다")
               history.go(-1);
       </script>
</c:if>
<c:if test="${result==-1 }">
        <script type="text/javascript">
                alert("존재하지 않는 아이디 입니다")
                history.go(-1);
        </script>
</c:if>
</body>
</html>