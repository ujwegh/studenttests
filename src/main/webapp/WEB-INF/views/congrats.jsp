<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h1><spring:message code="result.congrats"/></h1>

    <h2>${name} ${surname}, <spring:message code="result.score"/>: </h2>
    <h1>${score}</h1>
</div>
</body>
</html>
