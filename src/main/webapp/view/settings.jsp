<%@ page import="project.app.model.user.User" %><%--
  Created by IntelliJ IDEA.
  User: alex_pro
  Date: 9/19/19
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>


<c:url value="/settings" var="var"/>

  <form action="${var}" method="POST">

      <input type="hidden" name="id" value="${user.id}">


      <input type="text" name="name" id="name" placeholder="${user.name}">
      <label for="name"></label>

      <input type="text" name="pass" placeholder="${user.pass}" id="pass">
      <label for="pass"></label>
      <input type="submit" value="edit">


  </form>
  <c:if test ="${isNameFree!=null}">
      <p>name is not free</p>
  </c:if>

</body>
</html>
