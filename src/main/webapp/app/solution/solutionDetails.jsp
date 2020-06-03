<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../../fragments/head-section.jsp" %>
    <title>School - solution details</title>
</head>
<body>
<%@include file="../../fragments/header.jsp" %>
<div class="container">
    <h2><span class="lighter">User name:</span> <c:out value="${solution.userName}"/></h2>
    <p>
        User id: <c:out value="${solution.userId}"/><br>
        Solution id: <c:out value="${solution.id}"/>
    </p>
    <hr>
    <br>
    <p>
        Exercise: <span class="bold"> <c:out value="${solution.exerciseTitle}"/></span><br>
        Exercise id: <c:out value="${solution.exerciseId}"/><br>
        Created: <c:out value="${solution.created}"/></p>
    <p>Description:<br>
        <textarea cols="80" rows="10" contenteditable="false" disabled><c:out value="${solution.exerciseDescription}"/>
        </textarea>
    </p>
    <hr>
    <p>
        Solution date: <c:out value="${solution.updated}"/>

    </p>

        <p>Solution: <br>
        <textarea cols="80" rows="10" contenteditable="false" disabled><c:out value="${solution.description}"/>
        </textarea>
    </p>
    <div>
        <p>
            <a href="/app/solution/delete?id=${solution.id}" class="button grey">Delete</a>
            <a href="/app/solution/edit?id=${solution.id}" class="button grey">Edit</a>
            <a href="javascript:history.back()" class="button grey">Back</a>
        </p>
    </div>
</div>
<%@include file="../../fragments/footer.jsp" %>
</body>
</html>
