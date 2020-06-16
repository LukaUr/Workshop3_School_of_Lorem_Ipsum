<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 09.05.2020
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../fragments/head-section.jsp" %>
    <title>School - Main Page</title>
</head>
<body>
<%@include file="../fragments/header.jsp" %>
<div class="container">
    <div class="distancer"></div>
    <p class="bold">Welcome to the School of Lorem Ipsum.</p>
    <p>You are logged as a <span class="bold">Teacher</span> (aka Admin).</p>
    <hr>
    <nav>
        <a href="/app/group/groups" class="box">Groups</a>
        <a href="/app/user/users" class="box">Users</a>
        <br>
        <a href="/app/exercise/exercises" class="box">Exercises</a>
        <a href="/app/solution/solutions" class="box">Solutions</a>
    </nav>
    <hr>
    <p><a  class="button grey" href="/logoff">Log off</a></p>
</div>
<%@include file="../fragments/footer.jsp" %>
</body>
</html>
