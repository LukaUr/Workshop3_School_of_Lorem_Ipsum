<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../../fragments/head-section.jsp" %>
    <title>School - adding solution</title>
</head>
<body>
<%@include file="../../fragments/header.jsp" %>
<div class="container">

    <h2>Assign exercise to student</h2>
    <hr>
    <div class="distancer"></div>
    <form action="/app/solution/add" method="post">
        <label>
            Select exercise:<br>
            <select name="exercise" class="dropList">
                <c:forEach items="${exercises}" var="exercise">
                    <option value="${exercise.id}">
                        [id: ${exercise.id}] <c:out value="${exercise.title}"></c:out>
                    </option>
                </c:forEach>
            </select>
        </label><br>
        <label>
            Select user:<br>
            <select name="user" class="dropList">
                <c:forEach items="${users}" var="user">
                    <option value="${user.id}">
                        [id: ${user.id}] <c:out value="${user.name}"></c:out>
                    </option>
                </c:forEach>
            </select>
        </label>
        <br>
        <label>
            <input type="submit" class="button grey" value="Add"/>
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
