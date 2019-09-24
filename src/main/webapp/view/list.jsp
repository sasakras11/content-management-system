<%@ page import="project.app.model.user.User" %><%--
  Created by IntelliJ IDEA.
  User: alex_pro
  Date: 9/12/19
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>

    <a href="/addPost/${user.id}" >  add post</a>
<a href="/settings/${user.id}">settings</a>
    <c:forEach var="post" items="${list}">


    <tr>
        <td>${post.id}</td>
         <td>${post.user.name}</td>
        <td>${post.description}</td>
        <td>${post.price}</td>
    </tr>


    </c:forEach>
</table>

</body>
</html>
