<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../../fragments/head-section.jsp" %>
    <title>School - all solutions</title>
</head>
<body>
<%@include file="../../fragments/header.jsp" %>
<div class="container">
    <h2>Solutions</h2>
    <hr>
    <br>
    <table>
        <tr>
            <th>No</th>
            <th>Created</th>
            <th>Updated</th>
            <th>Description</th>
            <th>Id</th>
            <th>Exercise</th>
            <th>Ex. Id</th>
            <th>User</th>
            <th>Us. Id</th>
            <th colspan="2">Actions</th>
        </tr>
        <c:forEach items="${solutions}" var="solution" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td><c:out value="${solution.created}"/></td>
                <td><c:out value="${solution.updated}"/></td>
                <td><c:out value="${solution.description}"/></td>
                <td><c:out value="${solution.id}"/></td>
                <td><c:out value="${solution.exerciseTitle}"/></td>
                <td><c:out value="${solution.exerciseId}"/></td>
                <td><c:out value="${solution.userName}"/></td>
                <td><c:out value="${solution.userId}"/></td>
                <td><a href="/app/solution/details?id=${solution.id}" class="link">Details</a></td>
                <td><a href="/app/solution/delete?id=${solution.id}" class="link">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <div class="distancer"></div>
    <hr>
    <div>
        <p>
            <a href="/app/solution/add" class="button grey">Add solution</a>
            <a href="javascript:history.back()" class="button grey">Back</a>
        </p>
    </div>

</div>
<%@include file="../../fragments/footer.jsp" %>
</body>
</html>
