<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 29.05.2020
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../../fragments/head-section.jsp" %>
    <title>School - adding a group</title>
</head>
<body>
<%@include file="../../fragments/header.jsp" %>
<div class="container">
    <div class="distancer"></div>
    <hr>
    <div class="distancer"></div>
    <form action="/app/group/add" method="post">
        <label>Enter the name of the group: <br>
            <input type="text" name="groupName"/>
        </label><br>
        <label>
            <input type="submit" value="Add" class="button grey">
        </label>
    </form>
    <div class="distancer"></div>
    <hr>
    <p>
        <a href="javascript:history.back()" class="button grey">Back</a>
    </p>
</div>
<%@include file="../../fragments/footer.jsp" %>
</body>
</html>

