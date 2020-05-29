<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 29.05.2020
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="fragments/head-section.jsp" %>
    <title>School - User Groups</title>
</head>
<body>
<%@include file="fragments/header.jsp" %>
<div class="container">
    <h2>User groups - edit mode </h2>
    <hr>
    <br>
    <table class="groups">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th colspan="3">Action</th>
        </tr>
        <c:forEach items="${groups}" var="group">
            <tr>
                <td>${group.id}</td>
                <td>${group.name}</td>
                <td><a href="/groups" class="link">Details</a></td>
            </tr>
        </c:forEach>
    </table>
    <h1>${number}</h1>    <hr>
</div>
<%@include file="fragments/footer.jsp" %>
</body>
</html>
