<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../../fragments/head-section.jsp" %>
    <title>School - renaming a group</title>
</head>
<body>
<%@include file="../../fragments/header.jsp" %>
<div class="container">

    <div class="distancer"></div>
    <p>You are changing the name of this group</p>
    <p>
        group id: ${group.id}<br>
        group name: ${group.name}
    </p>
    <hr>
    <div class="distancer"></div>
    <form action="/app/group/update" method="post">
        <input type="number" value="${group.id}" name="id" hidden>
        <label>Enter new name of the group: <br>
            <input type="text" name="groupName"/>
        </label>
        <br>
        <label>
            <input type="submit" value="Edit" class="button grey">
        </label>
    </form>
    <div class="distancer"></div>
    <hr>
    <p>
        <a href="/app/group/groups" class="button grey">Back</a>
    </p>

</div>
<%@include file="../../fragments/footer.jsp" %>
</body>
</html>