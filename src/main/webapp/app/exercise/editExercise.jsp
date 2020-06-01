<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../../fragments/head-section.jsp" %>
    <title>School - editing exercise</title>
</head>
<body>
<%@include file="../../fragments/header.jsp" %>
<div class="container">
    <p>You are editing this execise</p>
    <p>
        exercise id: <span class="bold"> <c:out value="${exercise.id}"/></span><br>
        exercise title: <span class="bold"> <c:out value="${exercise.title}"/></span><br><br>
        exercise description:<br>
    </p>
    <hr>
    <p>Enter new data:</p>
    <form method="post" action="/app/exercise/edit">
        <input type="number" value="${exercise.id}" name="id" hidden>
        <label>Title:<br>
            <input class="input" name="title" type="text" value="<c:out value="${exercise.title}"/>"/><br>
        </label>
        <label>
            Description:<br>
            <textarea cols="80" rows="10" contenteditable="false" name="description"><c:out
                    value="${exercise.description}"/></textarea><br>
        </label>
        <input type="submit" class="button grey" value="Edit"/>
    </form>
    <hr>
    <a href="javascript:history.back()" class="button grey">Back</a>
</div>
<%@include file="../../fragments/footer.jsp" %>
</body>
</html>
