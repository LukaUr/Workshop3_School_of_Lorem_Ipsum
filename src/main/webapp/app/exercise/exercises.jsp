<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../../fragments/head-section.jsp" %>
    <title>School - exercises</title>
</head>
<body>
<%@include file="../../fragments/header.jsp" %>
<div class="container">
    <h2>Exercises</h2>
    <hr>
    <br>
    <table>
        <tr>
            <th>No</th>
            <th>Title</th>
            <th>Description</th>
            <th>Usages</th>
            <th>Id</th>
            <th colspan="3">Actions</th>
        </tr>
        <c:forEach items="${exercises}" var="exercise" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td><c:out value="${exercise.title}"/></td>
                <td><c:out value="${exercise.description}"/></td>
                <td><c:out value="${exercise.usagesCount}"/></td>
                <td><c:out value="${exercise.id}"/>
                </td>
                <td><a href="/app/exercise/details?id=${exercise.id}" class="link">Details</a></td>
                <td><a href="/app/exercise/delete?id=${exercise.id}" class="link">Delete</a></td>
                <td><a href="/app/exercise/edit?id=${exercise.id}" class="link">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
    <div class="distancer"></div>
    <hr>
    <div>
        <p>
            <a href="/app/exercise/add" class="button grey">Add exercise</a>
            <a href="javascript:history.back()" class="button grey">Back</a>
        </p>
    </div>

</div>
<%@include file="../../fragments/footer.jsp" %>
</body>
</html>
