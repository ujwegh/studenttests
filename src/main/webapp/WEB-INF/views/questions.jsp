<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%request.setCharacterEncoding("UTF-8");%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>questions!!!</h2>
<form method="post">
    <c:if test="${not empty questions}">
        <c:forEach items="${questions}" var="questions">
            <p><b>
                Question ${questions.id}: ${questions.question}<br>
            </b></p>
            <c:forEach items="${questions.answers}" var="entry">
                <input type="radio" name="answer ${questions.id}" value="${entry.value}"/> ${entry.value}<br/>
            </c:forEach>
        </c:forEach>
        <input type="submit" value="Submit">
    </c:if>
    <c:if test="${empty questions}">
        Вопросов нет)
    </c:if>

</form>
</body>
</html>
