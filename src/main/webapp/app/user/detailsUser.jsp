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

    <h2><span class="lighter">User name:</span> <c:out value="${user.userName}"/></h2>
    <p>id: <c:out value="${user.id}"/></p>
    <p>email: <c:out value="${user.email}"/></p>
    <br>
    <p>group: <c:out value="${group.name}"/></p>
    <p>group id: <c:out value="${group.id}"/></p>
    <hr>
    <br>

</div>
<%@include file="../../fragments/footer.jsp" %>
</body>
</html>
