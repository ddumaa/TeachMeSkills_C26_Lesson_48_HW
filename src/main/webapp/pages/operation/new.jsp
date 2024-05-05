<%--
  Created by IntelliJ IDEA.
  User: dimad
  Date: 05.05.2024
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>new operation</title>
</head>
<body>
<form action="/operation/new" method="post">
    <input type="number" name="number1" placeholder="Number one">
    <input type="text" name="operationType" placeholder="Type">
    <input type="number" name="number2" placeholder="Number two">
    <button>Submit</button>
</form>
</body>
</html>
