<%--
  Created by IntelliJ IDEA.
  User: dimad
  Date: 05.05.2024
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Name: ${user.name}</p>
<p>Username: ${user.username}</p>
<p>Password: ${user.password}</p>
<ul>
    <c:forEach items="${user.operations}" var="operation">
        <li><p>Operation: ${operation.number1} ${operation.operationType} ${operation.number2} = ${operation.result}</p></li>
    </c:forEach>
</ul>
</body>
</html>
