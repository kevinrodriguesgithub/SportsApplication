<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of Players</title>
</head>
<body>
<h1>List of All Players</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Jersey Number</th>
        <th>Team</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="player" items="${players}">
        <tr>
            <td>${player.id}</td>
            <td>${player.name}</td>
            <td>${player.jerseyNumber}</td>
            <td>${player.team.name}</td>
            <td>
                <a href="${pageContext.request.contextPath}/players/${player.id}">View Details</a> |
                <c:if test="${not empty sessionScope.user and sessionScope.user.admin}">       
	            	<form action="${pageContext.request.contextPath}/players/delete/${player.id}" method="post" style="display:inline;">
	                        <input type="hidden" name="_method" value="DELETE">
	                        <input type="submit" value="Delete" onclick="return confirm('Do you want to delete this Player ?');">
	                </form>   
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
<c:if test="${not empty sessionScope.user and sessionScope.user.admin}">
	<a href="${pageContext.request.contextPath}/players/new/p">Add New Player</a>
</c:if>
</body>
</html>
