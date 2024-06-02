<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Player Details</title>
</head>
<body>
<h1>Player Details</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <td>${player.id}</td>
    </tr>
    <tr>
        <th>Name</th>
        <td>${player.name}</td>
    </tr>
    <tr>
        <th>Jersey Number</th>
        <td>${player.jerseyNumber}</td>
    </tr>
    <tr>
        <th>Team</th>
        <td>${player.team.name}</td>
    </tr>
</table>
<a href="${pageContext.request.contextPath}/players/all">Back to List</a>
</body>
</html>
