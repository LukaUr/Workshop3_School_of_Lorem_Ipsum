<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../../fragments/head-section.jsp" %>
    <title>School - edit user data</title>
</head>
<body>
<%@include file="../../fragments/header.jsp" %>
<div class="container">

    <div class="distancer"></div>
    <p>You are changing data of this user</p>
    <p>
        user name: <span class="bold"> <c:out value="${user.name}"/></span><br>
        user id: <span class="bold"> <c:out value="${user.id}"/></span>
    </p>
    <hr>
    <div class="distancer"></div>
    <form action="/app/user/edit" method="post">
        <input type="number" value="${user.id}" name="id" hidden>
        <p>Enter new user data: </p>
        <label>
            User name:<br>
            <input type="text" class="input" name="userName" value="<c:out value="${user.name}"/>"/><br>
        </label>
        <label>
            User email (email must be unique)<br>
            <input type="email" class="input" name="email" value="<c:out value="${user.email}"/>"/><br>
        </label>
        <label>
            Password (type new password only if necessary)<br>
            <input type="password" class="input" name="password" placeholder="enter new password..."/><br>
        </label>
        <label>
            Group name:<br>
            <select name="groupId" class="droplist">
                <c:forEach var="group" items="${groups}">
                    <option value="${group.id}" <c:if test="${group.id == user.groupId}">selected</c:if>> ${group.name}</option>
                </c:forEach>
            </select>
        </label>
        <br>
        <label>
            <input type="submit" value="Edit" class="button grey">
        </label>
    </form>
    <div class="distancer"></div>
    <hr>
    <p>
        <a href="javascript:history.back()" class="button grey">Back</a>
    </p>


</div>
<%@include file="../../fragments/footer.jsp" %>
</body>
</html>
