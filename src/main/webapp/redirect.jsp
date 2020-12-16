<%--
  Created by IntelliJ IDEA.
  User: gabigutu
  Date: 16/12/2020
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Redirect</title>
</head>
<body>
    <%
        response.sendRedirect(request.getContextPath() + "/todo-servlet");
    %>
</body>
</html>
