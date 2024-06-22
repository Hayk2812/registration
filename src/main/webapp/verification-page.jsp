
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Verification Page</title>
</head>
<%
    String  verificationCode = (String) request.getAttribute("verification_code");
    String  errorMessage = (String) request.getAttribute("errorMessage");
    if (verificationCode !=null){
        response.getWriter().println(verificationCode);
    }
    if (errorMessage != null){
        response.getWriter().println(errorMessage);
    }
%>
<body>
<form method="post" action="/verification-page.jsp">

<h1> Verificatoion Page </h1><br><br>
email: <input type="text" name="email"><br><br>
verification code: <input type="text" name="verify-code"><br><br>
<input type="submit"><br>
</form>

</body>
</html>
