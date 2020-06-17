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
    <h2><span class="lighter">name:</span> <c:out value="${loggedUser.name}"/></h2>
    <p>
        email: <c:out value="${loggedUser.email}"/><br>
        id: <c:out value="${loggedUser.id}"/>
    </p>
    <p>
        group: <span class="bold"><c:out value="${loggedUser.groupName}"/></span><br>
        group id: <c:out value="${loggedUser.groupId}"/>
    </p>
    <hr>
    <c:if test="${countAll == 0}">
        <p>There are no exercises assigned to you so far.</p>
        <div class="distancer"></div>
    </c:if>
    <c:if test="${countAll > 0}">
        <p>
            You have ${countAll} assigned exercises.<br>
            ${countSolved} of them are solved.
        </p>
        <p><a href="/student/exercises" class="button grey">Details</a></p>
    </c:if>
    <hr>
    <div>
        <p>
            <a href="javascript:history.back()" class="button grey">Back</a>
        </p>
    </div>
</div>
<%@include file="../fragments/footer.jsp" %>
</body>
</html>
