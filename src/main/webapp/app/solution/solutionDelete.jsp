<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../../fragments/head-section.jsp" %>
    <title>School - deleting solution</title>
</head>
<body>
<%@include file="../../fragments/header.jsp" %>
<div class="container">
    <div class="distancer"></div>
    <p>You are about to delete this solution</p>
    <p>
        Solution id: <span class="bold"> <c:out value="${solution.id}"/></span><br>
        User name: <span class="bold"> <c:out value="${solution.userName}"/></span><br>
        User id: <span class="bold"> <c:out value="${solution.userId}"/></span><br>
        Exercise title: <span class="bold"> <c:out value="${solution.exerciseTitle}"/></span><br>
        Exercise id: <span class="bold"> <c:out value="${solution.exerciseId}"/></span><br>
        Created: <span class="bold"> <c:out value="${solution.created}"/></span><br>
        Solved: <span class="bold"> <c:out value="${solution.updated}"/></span><br>
        Solution: <span class="bold"> <c:out value="${solution.description}"/></span><br>
    </p>
    <p><span class="bold">Are you sure?</span></p>
    <form method="post" action="/app/solution/delete">
        <input type="number" value="${solution.id}" name="id" hidden>
        <input type="submit" class="button grey" value="Yes"/>
        <a href="javascript:history.back()" class="button grey">No</a>
    </form>
</div>
<%@include file="../../fragments/footer.jsp" %>
</body>
</html>
