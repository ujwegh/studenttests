<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setCharacterEncoding("UTF-8");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h1>Hello there!!!</h1>

    <form action="" method="post">
        <label>
            <spring:message code="name.input"/>
            <input type="text" name="name"/>
        </label>
        <br>
        <br>
        <label>
            <spring:message code="surname.input"/>
            <input type="text" name="surname"/>
        </label>
        <br>
        <input type="submit" value="submit">
    </form>
</div>


</body>
</html>
