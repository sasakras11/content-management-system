<%--
  Created by IntelliJ IDEA.
  User: alex_pro
  Date: 9/11/19
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>

    <title>Title</title>
</head>

<body>


  <form action="/confirm" method="GET" >
      <input type="text" name="name" >
      <input type="text" name="pass">
      <input type="submit" value="Log In" >
  </form>
</body>
</html>
