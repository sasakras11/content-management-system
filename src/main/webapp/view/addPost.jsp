<%--
  Created by IntelliJ IDEA.
  User: alex_pro
  Date: 9/23/19
  Time: 4:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:url value="/addPost" var="var"/>

<form action="${var}" method="POST">

    <input type="hidden" name="id_user" value="${user.id}">

    <input type="text" name="topic" id="topic" placeholder="Write your topic here...">
    <label for="topic"></label>

    <input type="text" name="description" placeholder="Describe your offer" id="description">
    <label for="description"></label>

    <input type="number" name="price" placeholder="set price" id="price">
    <label for="price"></label>
    <input type="submit" value="edit">


</form>

</body>
</html>
