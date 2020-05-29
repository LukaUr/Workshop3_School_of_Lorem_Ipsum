<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../../fragments/head-section.jsp" %>
    <title>School - group details</title>
</head>
<body>
<%@include file="../../fragments/header.jsp" %>
<div class="container">
    <h2><span class="lighter">Group:</span> <c:out value="${group.name}"/></h2>
    <p>id: <c:out value="${group.id}"/></p>
    <hr>
    <br>
    <table>
        <tr>
            <th>No</th>
            <th>Name</th>
            <th>Email</th>
            <th>Id</th>
        </tr>
        <c:forEach items="${users}" var="user" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td><c:out value="${user.username}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.id}"/></td>
            </tr>
        </c:forEach>
    </table>
    <div class="distancer"></div>
    <hr>
    <div>
        <p>
            <a href="/app/group/groups" class="button grey">Back</a>
        </p>
    </div>
</div>
<%@include file="../../fragments/footer.jsp" %>
</body>
</html>
