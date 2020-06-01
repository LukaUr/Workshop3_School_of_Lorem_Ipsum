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

    <div class="distancer"></div>
    <p>Exercise details:</p>
    <p>
    <h2><span class="lighter">Exercise title: </span><c:out value="${exercise.title}"/></h2><br>
    Exercise id: <span class="bold"> <c:out value="${exercise.id}"/></span><br><br>
    Description:<br>
    <textarea cols="80" rows="10" contenteditable="false" disabled><c:out
            value="${exercise.description}"/></textarea><br>
    </p>
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
