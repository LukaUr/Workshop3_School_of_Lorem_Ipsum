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
    <c:if test="${users.size() == 0}">
        <p>No users to show</p>
    </c:if>
    <c:if test="${users.size() > 0}">
        <table>
            <tr>
                <th>No</th>
                <th>Name</th>
                <th>Email</th>
                <th>Id</th>
                <th colspan="3">Actions</th>
            </tr>
            <c:forEach items="${users}" var="user" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td><c:out value="${user.name}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.id}"/></td>
                    <td><a href="/app/user/details?id=${user.id}" class="link">Details</a></td>
                    <td><a href="/app/user/delete?id=${user.id}" class="link">Delete</a></td>
                    <td><a href="/app/user/edit?id=${user.id}" class="link">Edit</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <div class="distancer"></div>
    <hr>
    <div>
        <p>
            <a href="javascript:history.back()" class="button grey">Back</a>
        </p>
    </div>
</div>
<%@include file="../../fragments/footer.jsp" %>
</body>
</html>
