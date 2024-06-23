<%--
  Created by IntelliJ IDEA.
  User: Хчо
  Date: 20.06.2024
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<%
    String errorMessage = (String)request.getAttribute("errorMessage");
    if (errorMessage != null){
        response.getWriter().println(errorMessage);
    }
%>

<form method="post" action="/registration">
    <h1> Welcome </h1>
    name: <input type ="text" name="name"><br><br>
    surname: <input type="text" name="surname"><br><br>
    year:<input  type="text" name="year"><br><br>
    email:<input  type="text" name="email"><br><br>
    password:<input  type="text" name="password"><br><br>
    <input type ="submit"><br>
</form>
<a href="registration.jsp">sign-up</a>
</body>
</html>
