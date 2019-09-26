<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: alex_pro
  Date: 9/11/19
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Title</title>
</head>
<body>


<c:url value="/registration" var="var"/>

<form action="${var}" method="POST">

    <input type="hidden" name="id" value="${user.id}">

    <input type="text" name="name" id="name" placeholder="username">
    <label for="name"></label>

    <input type="text" name="pass" placeholder="password" id="pass">
    <label for="pass"></label>

    <input type="text" name="email" placeholder="email" id="email">
    <label for="number"></label>

    <input type="int" name="number" placeholder="number" id="number">
    <label for="number"></label>
    <input type="submit" value="sign up">


</form>
<c:if test ="${isNameFree!=null}">
    <p>name is not free</p>
</c:if>

</body>
</html>
