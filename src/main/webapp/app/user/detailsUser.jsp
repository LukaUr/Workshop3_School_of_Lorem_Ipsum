<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../../fragments/head-section.jsp" %>
    <title>School - user details</title>
</head>
<body>
<%@include file="../../fragments/header.jsp" %>
<div class="container">

    <h2><span class="lighter">User name:</span> <c:out value="${user.name}"/></h2>
    <p>
        email: <c:out value="${user.email}"/><br>
        id: <c:out value="${user.id}"/>
    </p>
    <p>
        group: <span class="bold"><c:out value="${user.groupName}"/></span><br>
        group id: <c:out value="${user.groupId}"/>
    </p>
    <hr>
    <c:if test="${empty solutions}">
        <p>No exercises assigned to this user</p>
        <div class="distancer"></div>
    </c:if>
    <c:if test="${solutions.size() > 0}">
        <p>Assigned exercises</p>
        <table>
            <tr>
                <th>No</th>
                <th>Created</th>
                <th>Updated</th>
                <th>Id</th>
                <th>Exercise</th>
                <th>Ex. Id</th>
                <th>Solution</th>
                <th colspan="2">Actions</th>
            </tr>
            <c:forEach items="${solutions}" var="solution" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td><c:out value="${solution.created}"/></td>
                    <td><c:out value="${solution.updated}"/></td>
                    <td><c:out value="${solution.id}"/></td>
                    <td><c:out value="${solution.exerciseTitle}"/></td>
                    <td><c:out value="${solution.exerciseId}"/></td>
                    <td><c:out value="${solution.description}"/></td>
                    <td><a href="/app/solution/details?id=${solution.id}" class="link">Details</a></td>
                    <td><a href="/app/solution/delete?id=${solution.id}" class="link">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <hr>
    <div>
        <p>
            <a href="/app/user/delete?id=${user.id}" class="button grey">Delete</a>
            <a href="/app/user/edit?id=${user.id}" class="button grey">Edit</a>
            <a href="javascript:history.back()" class="button grey">Back</a>
        </p>
    </div>
</div>
<%@include file="../../fragments/footer.jsp" %>
</body>
</html>
