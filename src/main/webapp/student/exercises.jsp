<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 09.05.2020
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../fragments/head-section.jsp" %>
    <title>School of Lorem Ipsum - Student Service</title>
</head>
<body>
<%@include file="../fragments/header-student.jsp" %>
<div class="container">
    <%@include file="../fragments/student.jsp" %>

    <c:if test="${empty solutions}">
        <p>There are no exercises assigned to you so far.</p>
        <div class="distancer"></div>
    </c:if>
    <c:if test="${solutions.size() > 0}">
        <h2>Solutions</h2>
        <table>
            <tr>
                <th>No</th>
                <th>Assigned</th>
                <th>Exercise</th>
                <th>Solved</th>
                <th>Your solution</th>
                <th>Id</th>
                <th colspan="2">Actions</th>
            </tr>
            <c:forEach items="${solutions}" var="solution" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td><c:out value="${solution.created}"/></td>
                    <td><c:out value="${solution.exerciseTitle}"/></td>
                    <td><c:out value="${solution.updated}"/></td>
                    <td><c:out value="${solution.description}"/></td>
                    <td><c:out value="${solution.id}"/></td>
                    <td><a href="/student/exerciseDetails?id=${solution.id}" class="link">Details</a></td>
                    <td><a href="/student/solve?id=${solution.id}" class="link">Solve/Edit</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <div>
        <p>
            <a href="javascript:history.back()" class="button grey">Back</a>
        </p>
    </div>
</div>
<%@include file="../fragments/footer.jsp" %>
</body>
</html>
