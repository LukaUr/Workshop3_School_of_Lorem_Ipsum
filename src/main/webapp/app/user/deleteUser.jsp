<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../../fragments/head-section.jsp" %>
    <title>School - deleting user</title>
</head>
<body>
<%@include file="../../fragments/header.jsp" %>
<div class="container">

    <div class="distancer"></div>
    <p>You are about to delete this user</p>
    <p>
        user id: <span class="bold"> <c:out value="${user.id}"/></span><br>
        user name: <span class="bold"> <c:out value="${user.name}"/></span><br>
        user email: <span class="bold"> <c:out value="${user.email}"/></span><br>
        group: <span class="bold"> <c:out value="${user.groupName}"/></span>
    </p>
    <p><span class="bold">Are you sure?</span></p>
    <form method="post" action="/app/user/delete">
        <input type="number" value="${user.id}" name="id" hidden>
        <input type="submit" class="button grey" value="Yes"/>
        <a href="javascript:history.back()" class="button grey">No</a>
    </form>


</div>
<%@include file="../../fragments/footer.jsp" %>
</body>
</html>
