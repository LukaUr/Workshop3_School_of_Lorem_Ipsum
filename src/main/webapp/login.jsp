<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="/fragments/head-section.jsp" %>
    <title>Log in</title>
</head>
<body>
<%@include file="/fragments/header-main.jsp" %>
<div class="container">
    <div class="distancer"></div>
    <c:if test="${message != null}">
        <div class="strong-message">
            <c:out value="${message}"></c:out>
        </div>
        <div class="distancer"></div>
    </c:if>
    <form action="/login" method="post">
        <label>Your email:<br>
            <input name="email" class="input" type="text"><br>
        </label>
        <label>
            Password:<br>
            <input name="password" class="input" type="password"><br>
        </label>
        <label>
            <input type="submit" class="button grey" name = "logging" value="Log in as student">
        </label>
        <br>
        <label>
            <input type="submit" class="button grey" name = "logging" value="Log in as teacher">
        </label>
    </form>
    <hr>
    <a href="javascript:history.back()" class="button grey">Back</a>
</div>
<%@include file="/fragments/footer.jsp" %>
</body>
</html>
