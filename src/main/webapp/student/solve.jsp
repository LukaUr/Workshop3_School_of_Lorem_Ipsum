<%--
  Created by IntelliJ IDEA.
  User: lukasz
  Date: 09.05.2020
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../fragments/head-section.jsp" %>
    <title>School of Lorem Ipsum - Student Service</title>
</head>
<body>
<%@include file="../fragments/header-student.jsp" %>
<div class="container">
    <%@include file="../fragments/student.jsp" %>
    <form method="post" action="/student/solve">
        <p>
            Exercise: <span class="bold"> <c:out value="${solution.exerciseTitle}"/></span><br>
            Assigned: <c:out value="${solution.created}"/></p>
        <p>Description:<br>
            <textarea cols="80" rows="10" contenteditable="false" disabled><c:out
                    value="${solution.exerciseDescription}"/>
        </textarea>
        </p>
        <hr>
        <p>
            Solution date: <c:out value="${solution.updated}"/>
        </p>
        <p>Solution: <br>
            <textarea autofocus name="description" cols="80" rows="10" contenteditable="false"><c:out value="${solution.description}"/></textarea>
        </p>
        <input hidden type="number" value="${solution.id}" name="solutionId">
        <label>
            <input class="button grey" value="Send" type="submit"/>
        </label>
    </form>
    <div>
        <hr>
        <p>
            <a href="javascript:history.back()" class="button grey">Back</a>
        </p>
    </div>
</div>
<%@include file="../fragments/footer.jsp" %>
</body>
</html>
