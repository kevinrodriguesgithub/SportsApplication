<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Team Details</title>
</head>
<body>
<h1>Team Details</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <td>${team.id}</td>
    </tr>
    <tr>
        <th>Name</th>
        <td>${team.name}</td>
    </tr>
</table>
<a href="${pageContext.request.contextPath}/teams/allTeams">Back to List</a>
</body>
</html>
