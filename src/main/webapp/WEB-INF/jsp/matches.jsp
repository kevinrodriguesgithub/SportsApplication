<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>All Matches</title>
</head>
<body>
    <h1>Entire schedule of IPL Matches</h1>
    <table border="1">
        <tr>
            <th>Match ID</th>
            <th>Date</th>
            <th>Team A</th>
            <th>Team B</th>
            <th>Venue</th>
            <th>Options</th>
            
        </tr>
        <c:forEach var="match" items="${matches}">
            <tr>
                <td>${match.id}</td>
                <td>${match.date}</td>
                <td>${match.teamA.name}</td>
                <td>${match.teamB.name}</td>
                <td>${match.venue}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/sportsApp/match/${match.id}">View Details</a> |
                    <c:if test="${not empty sessionScope.user and sessionScope.user.admin}">
			         	<form action="${pageContext.request.contextPath}/sportsApp/deleteMatch/${match.id}" method="post" style="display:inline;">
	                        <input type="hidden" name="_method" value="DELETE">
	                        <input type="submit" value="Delete" onclick="return confirm('Confirm if you want to delete this match from the schedule?');">
	                    </form>
                    </c:if>
		         </td>
            </tr>
        </c:forEach>
    </table>
    <c:if test="${not empty sessionScope.user and sessionScope.user.admin}">
	    <h4>
	    	<a href="${pageContext.request.contextPath}/sportsApp/match/new">Add a new match</a>
	    </h4>
	    <h4>
	    	<a href="${pageContext.request.contextPath}/players/new/p">Create a new Player in the tournament</a>
	    </h4>
	    <h4>
	    	<a href="${pageContext.request.contextPath}/teams/new">Add a new team in the tournament</a>
	    </h4>
    </c:if>
</body>
</html>
