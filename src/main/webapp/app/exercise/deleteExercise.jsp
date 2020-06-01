<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../../fragments/head-section.jsp" %>
    <title>School - deleting exercise</title>
</head>
<body>
<%@include file="../../fragments/header.jsp" %>
<div class="container">

    <div class="distancer"></div>
    <p>You are about to delete this execise</p>
    <p>
        exercise id: <span class="bold"> <c:out value="${exercise.id}"/></span><br>
        exercise title: <span class="bold"> <c:out value="${exercise.title}"/></span><br><br>
        exercise description:<br>
        <textarea cols="80" rows="10" contenteditable="false" disabled><c:out value="${exercise.description}"/></textarea><br>
    </p>
    <p><span class="bold">Are you sure?</span></p>
    <form method="post" action="/app/exercise/delete">
        <input type="number" value="${exercise.id}" name="id" hidden>
        <input type="submit" class="button grey" value="Yes"/>
        <a href="javascript:history.back()" class="button grey">No</a>
    </form>

</div>
<%@include file="../../fragments/footer.jsp" %>
</body>
</html>
