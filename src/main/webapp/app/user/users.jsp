<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../../fragments/head-section.jsp" %>
    <title>School - all users</title>
</head>
<body>
<%@include file="../../fragments/header.jsp" %>
<div class="container">

    <h2>All users</h2>
    <hr>
    <br>
    <table>
        <tr>
            <th>No</th>
            <th>Name</th>
            <th>Email</th>
            <th>User Id</th>
            <th>Group Id</th>
            <th colspan="2">Actions</th>
        </tr>
        <c:forEach items="${users}" var="user" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td><c:out value="${user.userName}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.id}"/></td>
                <c:forEach var="group" items="${groups}">
                    <c:if test="${group.id == user.user_group_id}">
                        <c:set var="groupName" value="${group.name}"/>
                    </c:if>
                </c:forEach>
                <td><c:out value="${groupName}"/></td>
                <td><a href="/app/user/details" class="link">Details</a></td>
                <td><a href="/app/user/delete?id=${user.id}" class="link">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <div class="distancer"></div>
    <hr>
    <div>
        <p>
            <a href="/app/user/add" class="button grey">Add user</a>
        </p>
    </div>
</div>
<%@include file="../../fragments/footer.jsp" %>
</body>
</html>
