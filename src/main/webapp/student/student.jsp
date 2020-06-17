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
    <title>School of Lorem Ipsum - Student Service</title>
</head>
<body>
<%@include file="../fragments/header-student.jsp" %>
<div class="container">
    <%@include file="../fragments/student.jsp" %>
    <div class="distancer"></div>
    <p class="bold">Welcome <span class="bold"><c:out value="${loggedUser.name}"></c:out></span>.</p>
    <nav>
        <a href="/student/exercises" class="box">Your Exercises</a>
        <a href="/student/statistics" class="box">Your Statistics</a>
    </nav>
    <hr>
    <p><a  class="button grey" href="/logoff">Log off</a></p>
</div>
<%@include file="../fragments/footer.jsp" %>
</body>
</html>
