<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 09.05.2020
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../../fragments/head-section.jsp" %>
    <title>School - User Groups</title>
</head>
<body>
<%@include file="../../fragments/header.jsp" %>
<div class="container">
    <h2>User groups</h2>
    <hr>
    <br>
    <table class="groups">
        <tr>
            <th>No</th>
            <th>Name</th>
            <th>Id</th>
            <th colspan="3">Actions</th>
        </tr>
        <c:forEach items="${groups}" var="group" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td><c:out value="${group.name}"/></td>
                <td><c:out value="${group.id}"/></td>
                <td><a href="/app/group/details?id=${group.id}" class="link">Details</a></td>
                <td><a href="/app/group/delete?id=${group.id}" class="link">Delete</a></td>
                <td><a href="/app/group/update?id=${group.id}" class="link">Change name</a></td>
            </tr>
        </c:forEach>
    </table>
    <div class="distancer"></div>
    <hr>
    <div>
        <p>
            <a href="/app/group/add" class="button grey">Add group</a>
        </p>
    </div>
</div>
<%@include file="../../fragments/footer.jsp" %>
</body>
</html>
