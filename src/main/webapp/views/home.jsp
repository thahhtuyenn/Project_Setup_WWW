<%@ page language="java" contentType="text/html;charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>

<body>
<c:forEach begin="1" end="5" var="i">
    ${i}
</c:forEach>
<p>${demo.id}</p>
</body>
</html>