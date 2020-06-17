<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="fragments/head-section.jsp" %>
    <title>About</title>
</head>
<body>
<%@include file="fragments/header-main.jsp" %>
<div class="container">

    <h2>School of Lorem Ipsum</h2>
    <p>
        School of Lorem Ipsum is the result of the third workshop during the Java course by <span class="bold">CodersLab.pl</span>.<br>
        The main goal of this workshop is to prepare a simple web service for a school.<br>
        You may log in as a student or teacher (acting as an admin for this application).
    </p>
    <p class="styled-red">
        For the review purposes use this data to log in as a teacher:<br>
        email: admin<br>
        password: admin123
    </p>
    <p>
        This project is based on the CMV principle, where:
    <ul>
        <li>controller is compound of <span class="bold">Java servlets</span>,</li>
        <li>model is <span class="bold">DAO</span>, based on <span class="bold">JAVA</span> classes comunicating with
            <span class="bold">MySQL database</span>,</li>
        <li>view is using <span class="bold">JSP files</span>.</li>
    </ul>
    </p>
    <p>This project is focused mainly on the back-end development, with small use of CSS and occasional JavaScript.</p>

</div>
<%@include file="fragments/footer.jsp" %>
</body>
</html>
