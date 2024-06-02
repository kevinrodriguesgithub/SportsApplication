<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Match Details</title>
</head>
<body>
	<h1>Match Details of match ${match.id}</h1>
	<table >
		<tr>
			<th>ID</th>
			<td>${match.id}</td>
		</tr>
		<tr>
			<th>Date</th>
			<td>${match.date}</td>
		</tr>
		<tr>
			<th>Team A</th>
			<td>${match.teamA.name}</td>
		</tr>
		<tr>
			<th>Team B</th>
			<td>${match.teamB.name}</td>
		</tr>
		<tr>
			<th>Venue</th>
			<td>${match.venue}</td>
		</tr>
		<tr>
			<th>Description</th>
			<td>${match.description}</td>
		</tr>
	</table>
	
	<h2>Players Involved</h2>
    <ul>
        <c:forEach items="${match.players}" var="player">
            <li><c:out value="${player.name}"/></li>
        </c:forEach>
    </ul>
	<a href="${pageContext.request.contextPath}/sportsApp/allMatches">Back
		to all matches</a>
</body>
</html>
