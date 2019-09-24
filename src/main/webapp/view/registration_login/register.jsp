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



<form action="/registration" method="POST">
    <input type="text" name="name"/>
    <input type="text" name="pass"/>
    <input type="submit" value="Sign Up">
</form>
<c:if test ="${isNameFree!=null}">
    <p>name is not free</p>
</c:if>

</body>
</html>
