<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of Teams</title>
</head>
<body>
<h1>List of All Teams</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="team" items="${teams}">
        <tr>
            <td>${team.id}</td>
            <td>${team.name}</td>
            <td>
                <a href="${pageContext.request.contextPath}/teams/${team.id}">View</a> |       
                <c:if test="${not empty sessionScope.user and sessionScope.user.admin}">
	            	<form action="${pageContext.request.contextPath}/teams/delete/${team.id}" method="post" style="display:inline;">
	                        <input type="hidden" name="_method" value="DELETE">
	                        <input type="submit" value="Delete" onclick="return confirm('You sure want to delete this Team ?');">
	                </form> 
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
<c:if test="${not empty sessionScope.user and sessionScope.user.admin}">
	<a href="${pageContext.request.contextPath}/teams/new">Add New Team</a>
</c:if>
</body>
</html>
