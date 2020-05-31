<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../../fragments/head-section.jsp" %>
    <title>School - adding new exercise</title>
</head>
<body>
<%@include file="../../fragments/header.jsp" %>
<div class="container">
    <div class="distancer"></div>
    <hr>
    <p class="bold">Enter details of the new exercise</p>
    <form action="/app/exercise/add" method="post">
        <label>Title of the exercise: <br>
            <input type="text" name="title" class="input"/>
        </label><br>
        <label>Description: <br>
            <textarea name="description" cols="80" rows="10" placeholder="enter description..."></textarea>
        </label><br>
        <label>
            <input type="submit" value="Add" class="button grey">
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
