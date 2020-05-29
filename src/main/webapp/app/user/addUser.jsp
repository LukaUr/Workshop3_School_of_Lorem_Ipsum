<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../../fragments/head-section.jsp" %>
    <title>School - adding user</title>
</head>
<body>
<%@include file="../../fragments/header.jsp" %>
<div class="container">

    <div class="distancer"></div>
    <hr>
    <form action="/app/user/add" method="post">
        <p class="bold">Enter the details of the user:</p> <br>
        <label>
            Name:<br>
            <input type="text" name="userName" class="input"/>
        </label>
        <br>
        <label>
            Email:<br>
            <input type="text" name="email" class="input"/>
        </label>
        <br>
        <label>
            Password:<br>
            <input type="text" name="password" class="input"/>
        </label>
        <br>
        <label>
            Group id:<br>
            <select name="groupId" class="dropList">
                <c:forEach items="${groups}" var="group">
                    <option value="${group.id}"><c:out value="${group.name}"/></option>
                </c:forEach>
            </select>
        </label>
        <br><br>
        <label>
            <input type="submit" value="Add" class="button grey">
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
