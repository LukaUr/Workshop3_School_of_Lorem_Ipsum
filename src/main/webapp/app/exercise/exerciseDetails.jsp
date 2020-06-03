<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../../fragments/head-section.jsp" %>
    <title>School - exercise details</title>
</head>
<body>
<%@include file="../../fragments/header.jsp" %>
<div class="container">
    <h2><span class="lighter">Exercise title: </span><c:out value="${exercise.title}"/></h2>
    <p>Exercise id: <span class="bold"> <c:out value="${exercise.id}"/></span><p>
    <p>Description:</p>
    <textarea cols="80" rows="10" contenteditable="false" disabled><c:out
            value="${exercise.description}"/></textarea><br>
    </p>
    <hr>
<c:if test="${empty solutions}">
    <p>No usages of this exercise found</p>
    <div class="distancer"></div>
</c:if>
<c:if test="${not empty solutions}">
    <p>Usages:</p>
    <table>
        <tr>
            <th>No</th>
            <th>Created</th>
            <th>Updated</th>
            <th>User</th>
            <th>Us. Id</th>
            <th>Solution</th>
            <th>So. Id</th>
            <th colspan="2">Actions</th>
        </tr>
        <c:forEach items="${solutions}" var="solution" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td><c:out value="${solution.created}"/></td>
                <td><c:out value="${solution.updated}"/></td>
                <td><c:out value="${solution.userName}"/></td>
                <td><c:out value="${solution.userId}"/></td>
                <td><c:out value="${solution.description}"/></td>
                <td><c:out value="${solution.id}"/></td>
                <td><a href="/app/solution/details?id=${solution.id}" class="link">Details</a></td>
                <td><a href="/app/solution/delete?id=${solution.id}" class="link">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
    <hr>
    <div>
        <p>
            <a href="/app/exercise/delete?id=${exercise.id}" class="button grey">Delete</a>
            <a href="/app/exercise/edit?id=${exercise.id}" class="button grey">Edit</a>
            <a href="javascript:history.back()" class="button grey">Back</a>
        </p>
    </div>

</div>
<%@include file="../../fragments/footer.jsp" %>
</body>
</html>
